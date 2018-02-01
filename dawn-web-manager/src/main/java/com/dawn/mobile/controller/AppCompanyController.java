package com.dawn.mobile.controller;

import com.dawn.dto.CompanyDto;
import com.dawn.dto.TitleDescDto;
import com.dawn.service.CompanyService;
import com.dawn.service.TbCompanyService;
import com.dawn.service.TitleDescService;
import com.dawn.util.DawnResult;
import com.dawn.util.Result;
import com.dawn.util.TreePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by 569711293 on 2018/1/25.
 */
@Controller
@RequestMapping("/dawnapp")
public class AppCompanyController {
    @Autowired
    private TbCompanyService tbCompanyService;
    @Autowired
    private CompanyService companyService;

    @Autowired
    private TitleDescService titleDescService;
    // 公司tree
    @RequestMapping("/company/trees")
    @ResponseBody
    public DawnResult queryCompany(@RequestParam(value = "id", defaultValue = "0") long parentid) {
        List<TreePojo> treePojoList = tbCompanyService.queryCompany(parentid);


        return DawnResult.build(200,"ok",treePojoList);

    }

    // 根据公司名称模糊查询
    @RequestMapping(value = "company/likenames/{params}", produces = MediaType.APPLICATION_JSON_VALUE
            + ";charset=utf-8;")
    @ResponseBody
    public DawnResult queryLike(int page, int rows, @PathVariable("params") String params, HttpServletRequest request)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
       // ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser");
       // Integer userType = activeUser.getUser_type();// 用户类型
       // params = new String(params.getBytes("ISO8859-1"), "utf-8");
        Result queryByName = tbCompanyService.queryByName(page, rows, params, 1);
        return DawnResult.build(200,"ok",queryByName);
    }


    /**
     *  通过公司Id查公司题目
     * @param companyId  公司Id
     * @return DawnResult
     */
    @RequestMapping("/categorys/list/{companyId}")
    @ResponseBody
    public DawnResult selectCompany(@PathVariable long companyId){
        List<CompanyDto> companyDtos = companyService.selectCompanyId(companyId);

        return DawnResult.build(200,"ok",companyDtos);
    }

    /**
     *  通过题目Id查询daan
     * @param tbtitleId 题目Id
     * @return DawnResult
     */

    @RequestMapping("/titledescs/{tbtitleId}")
    @ResponseBody
    public DawnResult selectTitleDesc(@PathVariable long tbtitleId){
        TitleDescDto titleDescDto = titleDescService.selectByTbtitleId(tbtitleId);

        return  DawnResult.build(200,"ok",titleDescDto);
    }
}
