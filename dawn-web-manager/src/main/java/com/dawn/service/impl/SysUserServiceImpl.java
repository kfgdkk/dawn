package com.dawn.service.impl;

import com.dawn.mapper.SysPermissionMapperCoustom;
import com.dawn.mapper.SysUserMapper;
import com.dawn.mapper.SysUserRoleMapper;
import com.dawn.pojo.*;
import com.dawn.pojo.SysUserExample.Criteria;
import com.dawn.service.SysUserService;
import com.dawn.util.DawnResult;
import com.dawn.util.Result;
import com.dawn.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;

	// 用户角色表
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@Autowired
	private SysPermissionMapperCoustom sysPermissionMapperCoustom;


	public DawnResult authenticat(String userPhone, String password) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserPhoneEqualTo(userPhone);
		List<SysUser> list = sysUserMapper.selectByExample(example);

		// 判断该用户是否存在
		if (list.size() <= 0) {
			return DawnResult.build(400, "该用户不存在！");
		} else {
			// 获取用户对象
			SysUser sysUser = list.get(0);
			// 判断用户的密码
			// 密码是经过MD5加密
			// 获取到用户的密码
			String pwd_db = sysUser.getPassword(); // 获取到数据库密码

			// 1获得颜值
			String salt = sysUser.getSalt();
			// 2加密
			String salt_pwd = password + salt;
			// 拿数据库密码和页面输入的密码进行比对
			// 页面 密码 111111 使用md5加密进行对比
			String pwd_input = DigestUtils.md5DigestAsHex(salt_pwd.getBytes());

			if (!pwd_db.equalsIgnoreCase(pwd_input)) {
				return DawnResult.build(400, "用户名或密码不正确！");
			}
			Integer userId = sysUser.getId();
			ActiveUser activeUser = new ActiveUser();
			activeUser.setUserPhone(userPhone);
			activeUser.setUsername(sysUser.getUsername());
			activeUser.setUserid(sysUser.getId());
			activeUser.setUser_type(sysUser.getUserType());
			activeUser.setMenus(this.findMenuPermissionByUserID(userId));
			activeUser.setPermissions(this.findUrlPermissionByUserId(userId));
			return DawnResult.ok(activeUser);
		}

	}

	/**
	 * 权限粗拦截
	 * <p>
	 * Title: findMenuPermissionByUserID
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param userId
	 * @return
	 * @see SysUserService#findMenuPermissionByUserID(Integer)
	 */

	public List<SysPermission> findMenuPermissionByUserID(Integer userId) {

		return sysPermissionMapperCoustom.findMenuPermissionByUserID(userId);
	}

	/**
	 * url权限拦截
	 * <p>
	 * Title: findUrlPermissionByUserId
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param userId
	 * @return
	 * @see SysUserService#findUrlPermissionByUserId(Integer)
	 */

	public List<SysPermission> findUrlPermissionByUserId(Integer userId) {

		return sysPermissionMapperCoustom.findUrlPermissionByUserId(userId);
	}

	/**
	 * 查询用户
	 * <p>
	 * Title: findSysRolefindAll
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @return
	 //* @see SysUserService#findSysRolefindAll()
	 */

	public Result findSysRolefindAll(int page, int rows) {
		SysUserExample example = new SysUserExample();
		PageHelper.startPage(page, rows);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		PageInfo<SysUser> pageInfo = new PageInfo(list);
		Result result = new Result();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
    //查询用户
    public Result findSysUsersfindAll(int page, int rows) {
        SysUserExample example = new SysUserExample();
        PageHelper.startPage(page, rows);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        PageInfo<SysUser> pageInfo = new PageInfo(list);
        Result result = new Result();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;

    }

    /**
	 * 删除用户
	 * <p>
	 * Title: deleteSysRole
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param id
	 * @return
	 * @see SysUserService#deleteSysRole(Integer)
	 */

	public int deleteSysRole(Integer id) {

		return sysUserMapper.deleteByPrimaryKey(id);
	}
    // 删除用户
    public int deleteSysUser(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    /**
	 * 添加用户
	 * <p>
	 * Title: addSysUser
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user
	 * @return
	//* @see SysUserService#addSysUser(SysUser)
	 */

	public int addSysUser(SysUser user, int roleId) {
		user.setCreated(new Date());
		user.setUpdated(new Date());
		long worker = SnowflakeIdWorker.getInstance().nextId();
		String salt_pwd = user.getPassword() + worker;
		user.setSalt(String.valueOf(worker));
		user.setPassword(DigestUtils.md5DigestAsHex(salt_pwd.getBytes()));
		user.setCreated(new Date());
		user.setUpdated(new Date());
		int userid = sysUserMapper.insert(user);
		// 新增的用户赋予一个角色
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setSysUserId(user.getId());// 新增返回的用户id
		sysUserRole.setSysRoleId(roleId);// 角色id
		sysUserRoleMapper.insert(sysUserRole);// 保存用户角色
		return userid;
	}

	/**
	 * 根据ID查询
	 * <p>
	 * Title: findByIdSysUser
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param id
	 * @return
	 * @see SysUserService#findByIdSysUser(Integer)
	 */

	public SysUser findByIdSysUser(Integer id) {

		return sysUserMapper.selectByPrimaryKey(id);
	}

	/**
	 * 修改用户
	 * <p>
	 * Title: upadteSysUser
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user
	 * @return
	 * @see SysUserService#updateSysUser(SysUser,int roleId)
	 */

	public int updateSysUser(SysUser user,int roleId) {
		long worker = SnowflakeIdWorker.getInstance().nextId();
		String salt_pwd = user.getPassword() + worker;
		user.setLocked("1");
		user.setSalt(String.valueOf(worker));
		user.setPassword(DigestUtils.md5DigestAsHex(salt_pwd.getBytes()));
		user.setUserType(user.getUserType());
		user.setUsername(user.getUsername());
		user.setUserPhone(user.getUserPhone());
		// 修改用户的角色
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setSysUserId(user.getId());// 修改的用户id
		sysUserRole.setSysRoleId(roleId);// 角色id
		sysUserRoleMapper.insert(sysUserRole);// 保存用户角色
		return sysUserMapper.updateByPrimaryKeySelective(user);
	}


	public int excelUser(SysUser sysUser) throws Exception {
		sysUser.setCreated(new Date());
		sysUser.setUpdated(new Date());
		sysUserMapper.insert(sysUser);
		// 新增的用户赋予一个角色
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setSysUserId(sysUser.getId());// 新增返回的用户id
		sysUserRole.setSysRoleId(3);// 角色 学生角色
		sysUserRoleMapper.insert(sysUserRole);// 保存用户角色
		return sysUser.getId();
	}

	// 老师查询自己学生

	public Result findSysByParentId(int parentId, int page, int rows) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		PageHelper.startPage(page, rows);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		PageInfo<SysUser> pageInfo = new PageInfo(list);
		Result result = new Result();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	//根据密码查用户
    public SysUser selectByUserPhone(String pwd) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUserPhoneEqualTo(pwd);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        return list.size()==0?null:list.get(0);
    }
}
