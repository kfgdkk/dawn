package com.dawn.service;

import com.dawn.pojo.SysRole;
import com.dawn.pojo.SysUserRole;
import com.dawn.util.Result;

import java.util.List;

public interface SysRoleService {
	// 查询所有角色
	public Result findSysRolefindAll(int page, int rows);

	// 新增角色
	public int addSysRole(SysRole sysrole);

	// 删除角色
	public int deleteSysRole(Integer id);

	// 修改前查询
	public SysRole findByIdSysRole(Integer id);

	// 修改角色
	public int updateSysRole(SysRole sysrole);

	// 查询该角色下是否有用户
	public boolean isRoleUser(Integer roleId);

	// 根据用户id查询用户角色
	public List<SysUserRole> queryByUserId(Integer id);

}
