package com.dawn.service;

import java.util.List;

import com.dawn.pojo.SysRolePermission;

public interface SysRolePermissionService {

	public int addSysRolePermissionService(SysRolePermission sysRolePermission);

	// 根据角色id查询权限菜单
	public List<SysRolePermission> queryByRoleId(String roleId);

}
