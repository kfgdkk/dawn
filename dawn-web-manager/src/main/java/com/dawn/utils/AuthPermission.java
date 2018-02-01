package com.dawn.utils;

/**
 * 删除和修改权限工具类,根据id进行拦截
 * <p>
 * Title: AuthPermission
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.bochy.com
 * </p>
 * 
 * @author 涛哥
 * @date 2017年7月21日下午3:34:36
 * @version 1.0
 */
public class AuthPermission {
	/*
	 * @Autowired private TbTitleService tbTitleService;
	 * 
	 * @Autowired private TbCompanyService tbCompanyService;
	 * 
	 * // 角色权限
	 * 
	 * @Autowired private SysRoleService sysRoleService;
	 * 
	 * // 判断该用户是否可以删除.修改 题目和公司 public boolean
	 * authPermissionUserTitleCompany(TbTitle title, TbCompany company,
	 * HttpServletRequest request) { // 获取当前登录对象 ActiveUser activeUser =
	 * (ActiveUser) request.getSession().getAttribute("activeUser"); // 获取用户id
	 * Integer userid = activeUser.getUserid(); // 根据题目id查询用户的userid TbTitle
	 * tbTitle = tbTitleService.queryByTitleId(title.getTbtitleId()); long
	 * userTitleId = tbTitle.getUserid(); // 根据公司id查询用户的userid TbCompany
	 * tbCompany = tbCompanyService.queryById(company.getCompanyId()); long
	 * userCompanyUserId = tbCompany.getCompanyId(); // 根据用户id查询用户角色
	 * List<SysUserRole> userRoles = sysRoleService.queryByUserId(userid);
	 * SysUserRole sysUserRole = null; if (userRoles.size() > 0) { sysUserRole =
	 * userRoles.get(0); }
	 * 
	 * // 如果该题目的id和和用户id相同, // 根据用户id查询出的角色id 为 1 或者是2的 if
	 * (userid.equals(userTitleId) || userid.equals(userCompanyUserId) ||
	 * "1".equals(sysUserRole.getSysRoleId()) ||
	 * "2".equals(sysUserRole.getSysRoleId())) { return true; } return false; }
	 * 
	 * // 判断该用户是否可以删除.修改 题目 public boolean authPermissionUserTitle(Long titleId,
	 * HttpServletRequest request) { // 获取当前登录对象 ActiveUser activeUser =
	 * (ActiveUser) request.getSession().getAttribute("activeUser"); // 获取用户id
	 * Integer userid = activeUser.getUserid(); // 根据题目id查询用户的userid TbTitle
	 * tbTitle = tbTitleService.queryByTitleId(titleId); long userTitleId =
	 * tbTitle.getUserid(); // 根据用户id查询用户角色 List<SysUserRole> userRoles =
	 * sysRoleService.queryByUserId(userid); SysUserRole sysUserRole = null; if
	 * (userRoles.size() > 0) { sysUserRole = userRoles.get(0); }
	 * 
	 * // 如果该题目的id和和用户id相同, // 根据用户id查询出的角色id 为 1 或者是2的 if
	 * (userid.equals(userTitleId) || "1".equals(sysUserRole.getSysRoleId()) ||
	 * "2".equals(sysUserRole.getSysRoleId())) { return true; } return false; }
	 * 
	 * // 判断该用户是否可以删除.修改 公司 public boolean authPermissionUserCompany(long
	 * companyId, HttpServletRequest request) { // 获取当前登录对象 ActiveUser
	 * activeUser = (ActiveUser)
	 * request.getSession().getAttribute("activeUser"); // 获取用户id Integer userid
	 * = activeUser.getUserid(); // 根据公司id查询用户的userid TbCompany tbCompany =
	 * tbCompanyService.queryById(companyId); long userCompanyUserId =
	 * tbCompany.getCompanyId(); // 根据用户id查询用户角色 List<SysUserRole> userRoles =
	 * sysRoleService.queryByUserId(userid); SysUserRole sysUserRole = null; if
	 * (userRoles.size() > 0) { sysUserRole = userRoles.get(0); }
	 * 
	 * // 如果该题目的id和和用户id相同, // 根据用户id查询出的角色id 为 1 或者是2的 if
	 * (userid.equals(userCompanyUserId) ||
	 * "1".equals(sysUserRole.getSysRoleId()) ||
	 * "2".equals(sysUserRole.getSysRoleId())) { return true; } return false; }
	 */
}
