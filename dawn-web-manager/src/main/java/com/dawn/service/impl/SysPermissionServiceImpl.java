package com.dawn.service.impl;

import com.dawn.mapper.SysPermissionMapper;
import com.dawn.mapper.SysPermissionMapperCoustom;
import com.dawn.pojo.SysPermission;
import com.dawn.pojo.SysPermissionExample;
import com.dawn.pojo.SysPermissionExample.Criteria;
import com.dawn.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * <p>
 * Title: SysPermissionImpl
 * </p>
 * <p>
 * Description: 用户认证实现类
 * </p>
 * <p>
 * Company: www.bochy.com
 * </p>
 * 
 * @author
 * @date 2017年6月13日下午7:41:21
 * @version 1.0
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	@Autowired
	private SysPermissionMapperCoustom sysPermissionMapperCoustom;

	// 根据父节点查询权限菜单
	  
	public List<SysPermission> findPermissionByParentId(long parentid) {
		SysPermissionExample example = new SysPermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(parentid);
		List<SysPermission> list = sysPermissionMapper.selectByExample(example);
		return list;
	}

	// 查询是否为叶子节点

	public boolean findByIsParentId(long parentid) {
		SysPermissionExample example = new SysPermissionExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(parentid);
		List<SysPermission> list = sysPermissionMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	// 保存方法

	public void saveMenuPermission(SysPermission sysPermission) {
		sysPermissionMapper.insert(sysPermission);
	}

	// 修改方法
	 
	public void updateMenuPermission(SysPermission sysPermission) {
		sysPermissionMapper.updateByPrimaryKey(sysPermission);

	}

	// 查询单条

	public SysPermission queryById(Integer id) {
		return sysPermissionMapper.selectByPrimaryKey(id);
	}

	// 删除节点
	
	public void deleteMenuPermission(Integer id) {
		sysPermissionMapper.deleteByPrimaryKey(id);

	}

	//

}
