package com.dawn.controller;

import com.dawn.dto.CompanyDto;
import com.dawn.pojo.TbCompany;
import com.dawn.service.CompanyService;
import com.dawn.service.TbCompanyService;
import com.dawn.util.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService service;

	// 查询公司面试题
	@RequestMapping("/category/list/{companyId}")
	@ResponseBody
	public List<CompanyDto> selectCompanyId(@PathVariable long companyId) {

		List<CompanyDto> l = service.selectCompanyId(companyId);

		return l;

	}

	@Autowired
	private TbCompanyService tbCompanyService;

	/**
	 * 跳转页面到
	 * 
	 * @return
	 */
	@RequestMapping("/company/toauditStatus")
	public String toauditStatus3() {
		return "audit_status";
	}

	// 删除公司信息
	@RequestMapping("/company/deletes")
	@ResponseBody
	public MsgUtil deleteCompany(long companyId) {
		tbCompanyService.deleteCompany(companyId);
		MsgUtil m = new MsgUtil();
		m.setTitle("提示信息");
		m.setMsg("删除成功");
		return m;
	}

	/**
	 * 加载用户下的未审核、未通过的公司
	 * 
	 * @param userid
	 * @return
	 */
	@RequestMapping("/company/auditStatus")
	@ResponseBody
	public List<TbCompany> auditStatus2(Integer userid) {
		List<TbCompany> list = tbCompanyService.getCompanyByAuditstatusList(userid);
		return list;
	}

}
