package com.dawn.mapper;

import java.util.List;

import com.dawn.pojo.TbTitle;
import com.dawn.pojo.TbTitleCustom;

public interface TbTitleCustomMapper {

	// 根据审核状态和用户id查询待审核知识点
	List<TbTitleCustom> getByAuditStatuAndUserId(int id);
}
