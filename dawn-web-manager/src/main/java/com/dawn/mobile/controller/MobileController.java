package com.dawn.controller;

import com.dawn.dto.TitleDescDto;
import com.dawn.pojo.TbCategory;
import com.dawn.service.TbCategoryService;
import com.dawn.service.TbTitleService;
import com.dawn.service.TitleDescService;
import com.dawn.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/dawnapp")
public class MobileController {
    @Autowired
    private TbCategoryService tbCategoryService;
    @Autowired
    private TbTitleService titleService;
    @Autowired
    private TitleDescService service;

    /**
     * 根据题目id查询答案
     *
     * @param tbtitleId
     * @return
     */
    @RequestMapping("/titledesc")
    @ResponseBody
    public TitleDescDto selectByTbtitleId(@RequestParam(value = "tbtitleId") long tbtitleId) {
        return service.selectByTbtitleId(tbtitleId);
    }
    //查询知识点列表
    @RequestMapping("/title/lists/{categoryId}")
    @ResponseBody
    public Result getTitleList(@PathVariable Long categoryId, int page, int rows) {

        return titleService.getTitleLists(categoryId, page, rows);
    }

    //查询java大数据目录：数据库，框架类型，java基础与Web，数据结构与算法，互联网技术等。
    @RequestMapping("/title/treez/{parentid}")
    public List<TbCategory> queryzbhishidianz(@PathVariable long parentid){
        return tbCategoryService.getChildList(parentid);
    }


    // 根据知识点名称进行模糊查询
    @RequestMapping("/title/likes/{categoryId}")
    @ResponseBody
    public Result queryLike(int page, int rows, @PathVariable String categoryId, HttpServletRequest request) {
//      ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
//        Integer userType = activeUser.getUser_type();// 用户类型
//        try {
//            categoryId = new String(categoryId.getBytes("ISO8859-1"), "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        Result results = titleService.getByName(categoryId, page, rows, 1);
        return results;
    }
}
