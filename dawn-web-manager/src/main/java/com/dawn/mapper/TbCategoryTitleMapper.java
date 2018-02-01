package com.dawn.mapper;

import com.dawn.pojo.TbCategoryTitle;
import com.dawn.pojo.TbCategoryTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCategoryTitleMapper {
    int countByExample(TbCategoryTitleExample example);

    int deleteByExample(TbCategoryTitleExample example);

    int deleteByPrimaryKey(Long tbComTitId);

    int insert(TbCategoryTitle record);

    int insertSelective(TbCategoryTitle record);

    List<TbCategoryTitle> selectByExample(TbCategoryTitleExample example);

    TbCategoryTitle selectByPrimaryKey(Long tbComTitId);

    int updateByExampleSelective(@Param("record") TbCategoryTitle record, @Param("example") TbCategoryTitleExample example);

    int updateByExample(@Param("record") TbCategoryTitle record, @Param("example") TbCategoryTitleExample example);

    int updateByPrimaryKeySelective(TbCategoryTitle record);

    int updateByPrimaryKey(TbCategoryTitle record);
}