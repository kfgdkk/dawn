package com.dawn.service.impl;

import com.dawn.dto.TitleDescDto;
import com.dawn.dtomapper.TitleDescDtoMapper;
import com.dawn.mapper.TbDescMapper;
import com.dawn.service.TitleDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleDescServiceImpl implements TitleDescService {
	@Autowired
	private TitleDescDtoMapper mapper;
	@Autowired
	private TbDescMapper tbDescMapper;
	// 根据知识点查询答案

	public TitleDescDto selectByTbtitleId(long tbtitleId) {
		return mapper.selectByTbtitleId(tbtitleId);
	}

	public void deleteByTitleId(Long titleid) {
		tbDescMapper.deleteByTitleId(titleid);
	}

}
