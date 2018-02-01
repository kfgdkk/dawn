package com.dawn.mapper;

import com.dawn.pojo.MobileCollection;
import com.dawn.pojo.MobileCollectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MobileCollectionMapper {
    int countByExample(MobileCollectionExample example);

    int deleteByExample(MobileCollectionExample example);

    int deleteByPrimaryKey(Long cid);

    int insert(MobileCollection record);

    int insertSelective(MobileCollection record);

    List<MobileCollection> selectByExample(MobileCollectionExample example);

    MobileCollection selectByPrimaryKey(Long cid);

    int updateByExampleSelective(@Param("record") MobileCollection record, @Param("example") MobileCollectionExample example);

    int updateByExample(@Param("record") MobileCollection record, @Param("example") MobileCollectionExample example);

    int updateByPrimaryKeySelective(MobileCollection record);

    int updateByPrimaryKey(MobileCollection record);
}