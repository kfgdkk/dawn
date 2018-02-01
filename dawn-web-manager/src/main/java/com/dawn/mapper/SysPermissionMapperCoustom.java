package com.dawn.mapper;

import com.dawn.pojo.SysPermission;

import java.util.List;

public interface SysPermissionMapperCoustom {

	// 1.根据用户id查询用户的菜单
	List<SysPermission> findMenuPermissionByUserID(Integer userId);

	// 2.根据用户的id查询用户的权限
	List<SysPermission> findUrlPermissionByUserId(Integer userId);

}