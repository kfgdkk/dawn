package com.dawn.controller;

import com.dawn.dto.MobileDto;
import com.dawn.service.CollectionService;
import com.dawn.util.DawnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 于秋冬 on 2018/1/26 0026.
 */
@RestController
@RequestMapping("/dawnapp/mobile/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    /**
     * 添加收藏
     * @param request
     * @param response
     * @param pid
     * @param tbtitleId
     * @return
     */
    @RequestMapping("/add")
    public DawnResult addCol(HttpServletRequest request, HttpServletResponse response, int pid, Long tbtitleId){
       //添加收藏
        return  collectionService.addCollection(pid,tbtitleId);

    }
    //查看收藏列表
    @RequestMapping("/select")
    public List<MobileDto> selectTitleList(int pid){
            return  collectionService.selectCollectionTitle(pid);
    }
    //删除收藏问题
    @RequestMapping("/delete")
    public  DawnResult delCollectionTtile(Long cid){
       return collectionService.delCollectionTitle(cid);


    }
}