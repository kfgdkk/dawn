package com.dawn.controller;

import com.dawn.dto.CompanyTatilDto;
import com.dawn.pojo.ActiveUser;
import com.dawn.pojo.TbCompany;
import com.dawn.service.TbCompanyTitleService;
import com.dawn.util.DawnResult;
import com.dawn.util.PageResult;
import com.dawn.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/background")
public class CompanyTitleController {
	@Autowired
	private TbCompanyTitleService companyTitleService;

	// 根据题目id查询公司提问明细
	@RequestMapping("/selectByTitleId/{titleId}")
	@ResponseBody
	public List getCompanyTitlebyTitleId(@PathVariable Long titleId, HttpSession session) {
		Result result = companyTitleService.getCompanyTitle((long) titleId);
		// 把题目id保存到session中，
		session.setAttribute("title_campany_add", titleId);
		return result.getRows();
	}

	// 查询所有公司
	@RequestMapping("/selectAllCompanyId")
	@ResponseBody
	public List<TbCompany> selectAllCompanyId() {
		return companyTitleService.getAllCompany();
	}

	// 对已有的公司提问新增公司提问次数
	@RequestMapping("/updateAskNum")
	@ResponseBody
	public DawnResult updateAskNum(CompanyTatilDto companyTatilDto, HttpSession session) {
		// 在查询题目是保存的session
		Long titleId = (Long) session.getAttribute("title_campany_add");
		companyTatilDto.setTitleId(titleId);
		return companyTitleService.updateAskNum(companyTatilDto);
	}

	// 新增公司提问（原来没有该公司）
	@RequestMapping("/insertAsk")
	@ResponseBody
	public DawnResult insertAsk(CompanyTatilDto companyTatilDto, HttpSession session) {
		// 在查询题目是保存的session
		Long titleId = (Long) session.getAttribute("title_campany_add");
		companyTatilDto.setTitleId(titleId);
		return companyTitleService.addAskNum(companyTatilDto);
	}

	// 根据公司名称模糊查询公司列表
	@RequestMapping("/selectByCompanyName/{param}")
	@ResponseBody
	public List<TbCompany> getByName(@PathVariable String param, HttpServletRequest request) {
		String params;
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
		Integer userType = activeUser.getUser_type();
		try {
			params = new String(param.getBytes("ISO-8859-1"), "utf-8");
			List<TbCompany> list = companyTitleService.getByName(params, userType);
			return list;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	//根据公司名称模糊查询公司列表(yz)
	@RequestMapping("/company/search")
	@ResponseBody
	public PageResult searchBrand(@RequestBody TbCompany tbCompany, int page, int rows, int type){
		return companyTitleService.searchCompany(tbCompany,page,rows,type);
	}
	//查询公司面试题(yz)
	@RequestMapping("/company/findByParentId")
	@ResponseBody
	public PageResult findByParentId(int page, int rows,int parentId){
		return companyTitleService.findByParentId(page,rows,parentId);
	}

}
