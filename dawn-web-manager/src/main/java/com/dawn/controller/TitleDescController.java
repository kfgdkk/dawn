package com.dawn.controller;

import com.dawn.dto.TitleDescDto;
import com.dawn.service.TitleDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/background")

public class TitleDescController {

	@Autowired
	private TitleDescService service;

	/**
	 * 
	 * <p>
	 * Title: selectByTbtitleId
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 根据题目id查询答案
	 * 
	 * @param tbtitleId
	 * @return
	 */
	@RequestMapping("/titledesc")
	@ResponseBody


	public TitleDescDto selectByTbtitleId1(@PathVariable long tbtitleId) {
		return service.selectByTbtitleId(tbtitleId);
	}

	@RequestMapping("/company/findOne")
	public TitleDescDto selectByTbtitleId(long id) {
		return service.selectByTbtitleId(id);
	}
}
