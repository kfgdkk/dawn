package com.dawn.service;

import com.dawn.pojo.SysPermission;
import com.dawn.pojo.SysUser;
import com.dawn.util.DawnResult;
import com.dawn.util.Result;

import java.util.List;

public interface SysUserService {
	// 用户认证
	public DawnResult authenticat(String userPhone, String password);

	// 1.根据用户id查询用户的菜单
	List<SysPermission> findMenuPermissionByUserID(Integer userId);

	// 2.根据用户的id查询用户的权限
	List<SysPermission> findUrlPermissionByUserId(Integer userId);

	// 查询用户
	public Result findSysRolefindAll(int page, int rows);
	//查询用户2
	public Result findSysUsersfindAll(int page, int rows);

	// 根据id查询用户
	public Result findSysByParentId(int parentId, int page, int rows);

	public int deleteSysRole(Integer id);
	//删除用户
    public int deleteSysUser(Integer id);

	public int addSysUser(SysUser user, int roleId);

	public SysUser findByIdSysUser(Integer id);

	public int updateSysUser(SysUser user, int roleId);

	public int excelUser(SysUser sysUser) throws Exception;
    //根据密码查询用户（要判断用户名是否存在）
    SysUser selectByUserPhone(String pwd);

}
