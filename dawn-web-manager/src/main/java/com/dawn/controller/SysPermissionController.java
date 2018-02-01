package com.dawn.controller;

import com.dawn.pojo.SysPermission;
import com.dawn.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sysPsermission/*")
public class SysPermissionController {
	@Autowired
	private SysPermissionService sysPermissionService;

	/**
	 * 根据parentid查询权限菜单信息
	 * <p>
	 * Title: selectParentIdPermission
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param parentid
	 * @return
	 */
	@RequestMapping("selectParentIdPermission")
	@ResponseBody
	public List<SysPermission> selectParentIdPermission(@RequestParam(value = "id", defaultValue = "0") int parentid) {
		List<SysPermission> list = sysPermissionService.findPermissionByParentId(parentid);
		List resultMap = new ArrayList();
		for (SysPermission sysPermission : list) {
			Map node = new HashMap();
			node.put("id", sysPermission.getId());
			node.put("name", sysPermission.getName());
			node.put("pId",sysPermission.getParentid());
			node.put("open", sysPermissionService.findByIsParentId(sysPermission.getId()) ? "true" : "");
			node.put("url", sysPermission.getUrl());
			node.put("type", sysPermission.getType());
			resultMap.add(node);
		}
		return resultMap;
	}

	// 保存节点
	@RequestMapping("saveTree")
	@ResponseBody
	public Map savePerssion(String authName, String authPath, Long parentId, String types) {

		SysPermission sysPermission = new SysPermission();
		sysPermission.setName(authName);
		sysPermission.setUrl(authPath);
		sysPermission.setType(types);
		sysPermission.setParentid(parentId);
		Map map = new HashMap();
		try {
			sysPermissionService.saveMenuPermission(sysPermission);
			map.put("success", "保存成功!!");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", "保存失败!!");
			return map;
		}
	}

	// 修改节点
	@RequestMapping("updateTree")
	@ResponseBody
	public Map updateTree(String authName, String authPath, Integer authId, String types) {
		// 查询单条
		SysPermission sysPermission = sysPermissionService.queryById(authId);
		sysPermission.setName(authName);
		sysPermission.setUrl(authPath);
		sysPermission.setType(types);
		sysPermission.setId(authId);

		Map map = new HashMap();
		try {
			sysPermissionService.updateMenuPermission(sysPermission);
			map.put("success", "修改成功!!");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("errorMsg", "保存失败!!");
			return map;
		}
	}

	// 删除节点
	@RequestMapping("deleteTree")
	@ResponseBody
	public Map deleteTree(Integer authId) {
		Map map = new HashMap();
		// 查询单条
		boolean flag = sysPermissionService.findByIsParentId(authId);
		if (flag) {
			map.put("errorMsg", "该菜单节点有子节点，不能删除！");
			return map;
		} else {
			try {
				sysPermissionService.deleteMenuPermission(authId);
				map.put("success", "删除成功!!");
				return map;
			} catch (Exception e) {
				e.printStackTrace();
				map.put("errorMsg", "保存失败!!");
				return map;
			}
		}

	}

}
