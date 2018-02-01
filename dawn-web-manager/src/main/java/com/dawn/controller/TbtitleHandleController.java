package com.dawn.controller;

import com.dawn.pojo.ActiveUser;
import com.dawn.pojo.TbTitle;
import com.dawn.pojo.TitleAndDesc;
import com.dawn.service.TbtitleHandleService;
import com.dawn.util.DawnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/background")
public class TbtitleHandleController {
	/**
	 * 给公司添加题目和答案
	 */
	@Autowired
	private TbtitleHandleService service;

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	@ResponseBody
	public DawnResult saveTitle(TbTitle title, String titleDesc, Long companyId,HttpServletRequest request) throws Exception {
		//从session中获取登陆信息
		ActiveUser activeUser =  (ActiveUser) request.getSession().getAttribute("activeUser");
		service.saveTitle(title, titleDesc, companyId,activeUser);
		return DawnResult.ok();
	}
	@RequestMapping("/company/add")
	public DawnResult save(@RequestBody TitleAndDesc titleAndDesc, HttpServletRequest request) throws Exception {
		//从session中获取登陆信息
		ActiveUser activeUser =  (ActiveUser) request.getSession().getAttribute("activeUser");
		service.saveTitle(titleAndDesc.getTitle(), titleAndDesc.getTitleDesc(), titleAndDesc.getCompanyId(),activeUser);
		return DawnResult.ok();
	}
}
