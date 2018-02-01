package com.dawn.mapper;

import com.dawn.pojo.MobileUser;
import com.dawn.pojo.MobileUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MobileUserMapper {
    int countByExample(MobileUserExample example);

    int deleteByExample(MobileUserExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(MobileUser record);

    int insertSelective(MobileUser record);

    List<MobileUser> selectByExample(MobileUserExample example);

    MobileUser selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") MobileUser record, @Param("example") MobileUserExample example);

    int updateByExample(@Param("record") MobileUser record, @Param("example") MobileUserExample example);

    int updateByPrimaryKeySelective(MobileUser record);

    int updateByPrimaryKey(MobileUser record);
}