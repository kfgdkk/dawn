package com.dawn.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/1/26.
 */
@Controller
public class PageController {

    @RequestMapping("/page/{gopage}")
    public String gopage(@PathVariable String gopage){
        return gopage;
    }
}
