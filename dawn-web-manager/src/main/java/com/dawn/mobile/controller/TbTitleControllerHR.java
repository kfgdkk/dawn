package com.dawn.mobile.controller;

import com.dawn.dto.TitleDescDto;
import com.dawn.pojo.TbTitle;
import com.dawn.service.TbTitleService;
import com.dawn.service.TitleDescService;
import com.dawn.util.DawnResult;
import com.dawn.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuenb on 2018/1/25.
 */
@Controller
@RequestMapping("dawnapp")
public class TbTitleControllerHR {
    @Autowired
    private TbTitleService titleService;
    @Autowired
    private TitleDescService titleDescService;


    //本周高频面试问题
    @ResponseBody
    @RequestMapping("/getHFlist")
    public DawnResult getTbTitleHF(){
        List<TbTitle> list = titleService.getTbTitleHF();
        return DawnResult.build(200,"ok",list);
    }



    // HR最常用的20个问题 查询tb_title表
    @RequestMapping(value = "/rank/getHrQuestions",method = RequestMethod.GET)
    @ResponseBody
    public DawnResult getHrQuestions( ){
        List<TbTitle> tbTitles = titleService.selectHRquestions();
        return DawnResult.build(200,"ok",tbTitles);
    }


    //提问次数最多的15个问题
    @RequestMapping("/mobile/questionfifteen")
    @ResponseBody
    public Response selecttopfifteen(){
        return titleService.selecttopfifteen();
    }

    //最容易被面试官看穿的回答
    @RequestMapping("/mobile/seeThrough")
    @ResponseBody
    public Response seeThrough(){
        return  titleService.seeThrough();
    }

    //面试中最需要注意的19个问题
    @ResponseBody
    @RequestMapping(value = "/getImportantQuestions",method = RequestMethod.GET)
    public DawnResult getImportantQuestions(){
        List<TbTitle> list = titleService.getTbTitleHF();
        return DawnResult.build(200,"ok",list);
    }


    //问题详情的展示
    @RequestMapping(value = "/rank/getQuestionsDetail",method = RequestMethod.GET)
    @ResponseBody
    public DawnResult getQuestionsDetail(@RequestParam("tbtitleId") long tbtitleId){
        Map<String,Object> map = new HashMap();
        String titleName = titleService.selectTitleById(tbtitleId);
        TitleDescDto titleDesc = titleDescService.selectByTbtitleId(tbtitleId);
        map.put("titltName",titleName);
        map.put("titleDesc",titleDesc);
        return DawnResult.build(200,"ok",map);
    }








}
