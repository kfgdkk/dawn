package com.dawn.service.impl;

import com.dawn.dto.MobileDto;
import com.dawn.jedis.dao.JedisClient;
import com.dawn.mapper.MobileCollectionMapper;
import com.dawn.mapper.MobileDtoMapper;
import com.dawn.pojo.MobileCollection;
import com.dawn.service.CollectionService;
import com.dawn.test.JedisTest;
import com.dawn.util.DawnResult;
import com.dawn.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yuqiudong on 2018/1/26 0026.
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CollectionServiceImpl.class);
    @Autowired
    private MobileCollectionMapper mobileCollectionMapper;
    @Autowired
    private MobileDtoMapper mobileDtoMapper;
    @Autowired
    private JedisClient jedisClient;

    //添加收藏
    @Override
    public DawnResult addCollection(Integer pid, Long tbtitleId) {
        //创建收藏对象

        try {
            MobileCollection mobileCollection = new MobileCollection();
            mobileCollection.setPid(pid);
            mobileCollection.setTitleId(tbtitleId);
            //格式化时间
            mobileCollection.setCreateTime(new Date());
            int i = mobileCollectionMapper.insert(mobileCollection);
            //判断是否添加成功
            if (i > 0) {
                return DawnResult.ok(mobileCollection);
            }
            return DawnResult.build(400, "收藏失败!");
        } catch (Exception e) {
            LOGGER.error("添加收藏异常", e);
            return  null;
        }
    }




    //查询收藏列表
    @Override
    public List<MobileDto> selectCollectionTitle(Integer pid) {
        //取 先从redis查
      try {
          String jsondata = jedisClient.get("COLLECTION_REDIS:" + pid);

          //判断是否查到
          if (StringUtils.isNotBlank(jsondata)) {
              List<MobileDto> titleList = JsonUtils.jsonToList(jsondata, MobileDto.class);
              return titleList;
          }
          //如果为空就去数据库查
          List<MobileDto> list = mobileDtoMapper.selectMobileDto(pid);

          //将查到该用户收藏的问题存入redis
          jedisClient.set("COLLECTION_REDIS:" + pid, JsonUtils.objectToJson(list));

          return list;
      }catch (Exception e){

              LOGGER.error("查看收藏问题列表异常", e);
              return null;
          }


    }

    //删除收藏问题
    @Override
    public DawnResult delCollectionTitle(Long cid) {
        //根据收藏表的id删除单个的收藏问题
        try {
            int i = mobileCollectionMapper.deleteByPrimaryKey(cid);

            if (i > 0) {
                return DawnResult.ok();
            }
            return DawnResult.build(400, "删除失败!");
        } catch (Exception e) {
            LOGGER.error("删除收藏问题列表异常", e);
            return  null;
        }
    }

}
