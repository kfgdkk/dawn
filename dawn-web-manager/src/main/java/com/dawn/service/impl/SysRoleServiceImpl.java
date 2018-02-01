package com.dawn.service.impl;

import com.dawn.mapper.SysRoleMapper;
import com.dawn.mapper.SysUserRoleMapper;
import com.dawn.pojo.SysRole;
import com.dawn.pojo.SysRoleExample;
import com.dawn.pojo.SysUserRole;
import com.dawn.pojo.SysUserRoleExample;
import com.dawn.service.SysRoleService;
import com.dawn.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	/**
	 * 注入角色mapper
	 */
	@Autowired
	private SysRoleMapper sysRoleMapper;

	// 用户角色表
	@Autowired
	private SysUserRoleMapper userRoleMapper;

	// 用户角色表
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	/**
	 * 查询所有角色
	 * <p>
	 * Title: findSysRolefindAll
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @return
	 * //@see SysRoleService#findSysRolefindAll()
	 */

	public Result findSysRolefindAll(int page, int rows) {
		SysRoleExample example = new SysRoleExample();
		PageHelper.startPage(page, rows);
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		PageInfo<SysRole> pageInfo = new PageInfo(list);
		Result result = new Result();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	/**
	 * 新增角色
	 * <p>
	 * Title: addSysRole
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param sysrole
	 * @return
	 * @see SysRoleService#addSysRole(SysRole)
	 */

	public int addSysRole(SysRole sysrole) {
		int i = sysRoleMapper.insert(sysrole);
		return i;
	}

	/**
	 * 删除角色
	 * <p>
	 * Title: deleteSysRole
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param id
	 * @return
	 * @see SysRoleService#deleteSysRole(Integer)
	 */

	public int deleteSysRole(Integer id) {
		int i = sysRoleMapper.deleteByPrimaryKey(id);
		return i;
	}

	/**
	 * 修改前根据Id查询角色
	 * <p>
	 * Title: findByIdSysRole
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param id
	 * @return
	 * @see SysRoleService#findByIdSysRole(Integer)
	 */

	public SysRole findByIdSysRole(Integer id) {
		SysRole sys = sysRoleMapper.selectByPrimaryKey(id);
		return sys;
	}

	/**
	 * 修改角色信息
	 * <p>
	 * Title: updateSysRole
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param sysrole
	 * @return
	 * @see SysRoleService#updateSysRole(SysRole)
	 */

	public int updateSysRole(SysRole sysrole) {
		int i = sysRoleMapper.updateByPrimaryKey(sysrole);
		return i;
	}

	// 查看该角色下是否有用户

	public boolean isRoleUser(Integer roleId) {
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andSysRoleIdEqualTo(roleId);
		List<SysUserRole> list = userRoleMapper.selectByExample(example);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	// 根据用户id查询用户角色

	public List<SysUserRole> queryByUserId(Integer id) {
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(id);// 传递UserID
		List<SysUserRole> list = sysUserRoleMapper.selectByExample(example);
		return list;
	}

}
