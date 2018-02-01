package com.dawn.service.impl;

import com.dawn.mapper.SysRolePermissionMapper;
import com.dawn.pojo.SysRolePermission;
import com.dawn.pojo.SysRolePermissionExample;
import com.dawn.pojo.SysRolePermissionExample.Criteria;
import com.dawn.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
	@Autowired
	private SysRolePermissionMapper sysRolePermissionmapper;

	 
	public int addSysRolePermissionService(SysRolePermission sysRolePermission) {

		return sysRolePermissionmapper.insert(sysRolePermission);
	}

	// 根据角色id查询菜单
	 
	public List<SysRolePermission> queryByRoleId(String roleId) {
		SysRolePermissionExample example = new SysRolePermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andSysRoleIdEqualTo(roleId);
		List<SysRolePermission> list = sysRolePermissionmapper.selectByExample(example);
		return list;
	}

}
