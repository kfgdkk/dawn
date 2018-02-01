package com.dawn.mapper;

import com.dawn.pojo.TbCompany;
import com.dawn.pojo.TbCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCompanyMapper {
    int countByExample(TbCompanyExample example);

    int deleteByExample(TbCompanyExample example);

    int deleteByPrimaryKey(Long companyId);

    int insert(TbCompany record);

    int insertSelective(TbCompany record);

    List<TbCompany> selectByExampleWithBLOBs(TbCompanyExample example);

    List<TbCompany> selectByExample(TbCompanyExample example);

    TbCompany selectByPrimaryKey(Long companyId);

    int updateByExampleSelective(@Param("record") TbCompany record, @Param("example") TbCompanyExample example);

    int updateByExampleWithBLOBs(@Param("record") TbCompany record, @Param("example") TbCompanyExample example);

    int updateByExample(@Param("record") TbCompany record, @Param("example") TbCompanyExample example);

    int updateByPrimaryKeySelective(TbCompany record);

    int updateByPrimaryKeyWithBLOBs(TbCompany record);

    int updateByPrimaryKey(TbCompany record);
}