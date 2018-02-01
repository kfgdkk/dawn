package com.dawn.mobile.controller;

import com.dawn.service.TbCompanyService;
import com.dawn.util.DawnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/1/25.
 */
@Controller
@RequestMapping("/mobile")
public class TbCompanyMobileController {
    @Autowired
    private TbCompanyService tbCompanyService;

    //首页面试题和内容的接口
    @RequestMapping("/company/tree")
    @ResponseBody
    public DawnResult getCompanyList(@RequestParam(value = "id", defaultValue = "1") long parentid){
        return tbCompanyService.getCompany(parentid);
    }
}
