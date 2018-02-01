package com.dawn.controller;

import com.dawn.pojo.ActiveUser;
import com.dawn.pojo.TbCompany;
import com.dawn.service.TbCompanyService;
import com.dawn.util.MsgUtil;
import com.dawn.util.Result;
import com.dawn.util.TreePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/background")
public class TbCompanyController {
	@Autowired
	private TbCompanyService tbCompanyService;

	// 公司tree
	@RequestMapping("/company/tree")
	@ResponseBody
	public List<TreePojo> queryCompany(@RequestParam(value = "id", defaultValue = "0") long parentid) {
		return tbCompanyService.queryCompany(parentid);
	}

	// 新增公司
	@RequestMapping("/saveCompany")
	@ResponseBody
	public MsgUtil saveCompany(long targetId, String companyinfo, String corporate, TbCompany company,
			HttpServletRequest request) {
		// 从session中获取登陆信息
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
		// 数据补全
		Integer userType = 0;
		if (activeUser != null && activeUser.getUser_type() != 0) {
			userType = activeUser.getUser_type();
		}
		// 用户所属部门
		company.setUserType(userType);
		// 用户ID
		company.setUserid(activeUser.getUserid());
		// 审核状态
		company.setAuditStatus("2");
		company.setParentid(targetId);
		company.setCompanyinfo(companyinfo);
		company.setCorporate(corporate);
		try {
			tbCompanyService.saveCompany(company);
			MsgUtil m = new MsgUtil();
			m.setTitle("提示信息");
			m.setMsg("保存成功");
			return m;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MsgUtil m = new MsgUtil();
			m.setTitle("提示信息");
			m.setMsg("保存成功");
			return m;
		}
	}

	// 修改知识点
	@RequestMapping("/updateCompany")
	@ResponseBody
	public MsgUtil updateCompany(long companyId, String companyinfo, String corporate, TbCompany company,
			HttpServletRequest request) {
		company.setCompanyId(companyId);
		company.setCorporate(corporate);
		company.setCompanyinfo(companyinfo);
		/*
		 * AuthPermission auth = new AuthPermission(); boolean flag =
		 * auth.authPermissionUserCompany(companyId, request);
		 */
		// 判断是否有权限操作
		// if (flag) {
		try {
			tbCompanyService.updateCompany(company);
			MsgUtil m = new MsgUtil();
			m.setTitle("提示信息");
			m.setMsg("修改成功");
			return m;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MsgUtil m = new MsgUtil();
			m.setTitle("提示信息");
			m.setMsg("修改失败");
			return m;
		}
		// }
		/*
		 * MsgUtil m = new MsgUtil(); m.setTitle("提示信息"); m.setMsg("修改失败");
		 * return m;
		 */
	}

	// 删除公司tree
	@RequestMapping("/deleteCompany")
	@ResponseBody
	public MsgUtil deleteCompany(long targetId, HttpServletRequest request) {
		// AuthPermission auth = new AuthPermission();
		// boolean flag = auth.authPermissionUserCompany(targetId, request);
		MsgUtil m = new MsgUtil();
		// 判断是否有权限操作
		// if (flag) {
		List<TbCompany> list = tbCompanyService.getChildList(targetId);
		for (int i = 0; i < list.size(); i++) {
			Long id = list.get(i).getCompanyId();
			tbCompanyService.deleteCompany(id);
		}
		tbCompanyService.deleteCompany(targetId);
		m.setTitle("提示信息");
		m.setMsg("删除成功");
		return m;
		// }
		/*
		 * m.setTitle("提示信息"); m.setMsg("您无权操作!"); return m;
		 */

	}

	// 根据公司名称模糊查询
	@RequestMapping(value = "company/likename/{params}", produces = MediaType.APPLICATION_JSON_VALUE
			+ ";charset=utf-8;")
	@ResponseBody
	public Result queryLike(int page, int rows, @PathVariable String params, HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
		Integer userType = activeUser.getUser_type();// 用户类型
		params = new String(params.getBytes("ISO8859-1"), "utf-8");
		Result queryByName = tbCompanyService.queryByName(page, rows, params, userType);
		return queryByName;
	}
	// 删除公司信息
	@RequestMapping("/company/delete")
	@ResponseBody
	public MsgUtil deleteCompany(long companyId) {
		tbCompanyService.deleteCompany(companyId);
		MsgUtil m = new MsgUtil();
		m.setTitle("提示信息");
		m.setMsg("删除成功");
		return m;
	}
	// 批量删除公司
	@RequestMapping("/company/deleteMore")
	@ResponseBody
	public MsgUtil deleteMore(Long [] companyIds){
		tbCompanyService.deleteMore(companyIds);
		MsgUtil m = new MsgUtil();
		m.setTitle("提示信息");
		m.setMsg("删除成功");
		return m;
	}
	// 修改公司
	@RequestMapping("/company/updateCompany")
	@ResponseBody
	public MsgUtil updateCompany(Long companyId,String corporate,String companyinfo){
		TbCompany company = tbCompanyService.selectCompanyById(companyId);
		company.setCorporate(corporate);
		company.setCompanyinfo(companyinfo);
		tbCompanyService.updateCompany(company);
		MsgUtil m = new MsgUtil();
		m.setTitle("提示信息");
		m.setMsg("修改成功");
		return m;
	}
	// 新增公司
	@RequestMapping("/saveCompany1")
	@ResponseBody
	public MsgUtil saveCompany1( String companyinfo, String corporate, TbCompany company,
								 HttpServletRequest request) {

		// 用户所属部门
		company.setUserType(1);
		// 审核状态
		company.setAuditStatus("2");
		company.setParentid((long) 318);
		company.setCompanyinfo(companyinfo);
		company.setCorporate(corporate);
		try {
			tbCompanyService.saveCompany(company);
			MsgUtil m = new MsgUtil();
			m.setTitle("提示信息");
			m.setMsg("保存成功");
			return m;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MsgUtil m = new MsgUtil();
			m.setTitle("提示信息");
			m.setMsg("保存成功");
			return m;
		}
	}
}
