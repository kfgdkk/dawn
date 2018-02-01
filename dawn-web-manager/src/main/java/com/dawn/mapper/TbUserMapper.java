package com.dawn.mapper;

import com.dawn.pojo.TbUser;
import com.dawn.pojo.TbUserExample;
import java.util.List;

public interface TbUserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}