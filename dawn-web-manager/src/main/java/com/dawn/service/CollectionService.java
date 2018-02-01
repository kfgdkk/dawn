package com.dawn.service;

import com.dawn.dto.MobileDto;
import com.dawn.util.DawnResult;

import java.util.List;

/**
 * Created by yuqiudong on 2018/1/26 0026.
 */
public interface CollectionService {

    //添加收藏
   DawnResult addCollection(Integer pid, Long titleId);
   //查看我的收藏列表
   List<MobileDto> selectCollectionTitle(Integer pid);

   DawnResult delCollectionTitle(Long cid);

}
