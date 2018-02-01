package com.dawn.mapper;

import com.dawn.pojo.TbDesc;
import com.dawn.pojo.TbDescExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbDescMapper {
    int countByExample(TbDescExample example);

    int deleteByExample(TbDescExample example);

    int deleteByPrimaryKey(Long descId);

    int insert(TbDesc record);

    int insertSelective(TbDesc record);

    List<TbDesc> selectByExampleWithBLOBs(TbDescExample example);

    List<TbDesc> selectByExample(TbDescExample example);

    TbDesc selectByPrimaryKey(Long descId);

    int updateByExampleSelective(@Param("record") TbDesc record, @Param("example") TbDescExample example);

    int updateByExampleWithBLOBs(@Param("record") TbDesc record, @Param("example") TbDescExample example);

    int updateByExample(@Param("record") TbDesc record, @Param("example") TbDescExample example);

    int updateByPrimaryKeySelective(TbDesc record);

    int updateByPrimaryKeyWithBLOBs(TbDesc record);

    int updateByPrimaryKey(TbDesc record);

    void deleteByTitleId(@Param("titleid") Long titleid);
}