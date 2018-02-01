package com.dawn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Pagecontroller {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/{page}")
	public String page(@PathVariable String page) {
		return page;
	}

	@RequestMapping("/{page}/{categoryId}")
	public String page(@PathVariable String page, @PathVariable String categoryId, Model model) {

		model.addAttribute("categoryId", categoryId);
		return page;
	}

}
