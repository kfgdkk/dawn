package com.dawn.service;

import java.util.List;

import com.dawn.pojo.SysPermission;

public interface SysPermissionService {

	// 根据父节点查询用户
	public List<SysPermission> findPermissionByParentId(long parentid);

	// 查询是否为叶子节点
	public boolean findByIsParentId(long parentid);

	// 保存方法
	public void saveMenuPermission(SysPermission sysPermission);

	// 修改方法
	public void updateMenuPermission(SysPermission sysPermission);

	// 查询单条
	public SysPermission queryById(Integer id);

	// 删除节点
	public void deleteMenuPermission(Integer id);
}
