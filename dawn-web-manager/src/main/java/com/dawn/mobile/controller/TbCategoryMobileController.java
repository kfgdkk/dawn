package com.dawn.mobile.controller;

import com.dawn.service.TbCategoryService;
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
public class TbCategoryMobileController {
    @Autowired
    private TbCategoryService tbCategoryService;

    //首页知识点和展示内容的接口
    @RequestMapping("/title/tree")
    @ResponseBody
    public DawnResult queryVatrgory(@RequestParam(value = "id", defaultValue = "1") long parentid){
        return  tbCategoryService.getCategory(parentid);
    }

}
