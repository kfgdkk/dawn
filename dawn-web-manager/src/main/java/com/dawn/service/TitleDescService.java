package com.dawn.service;

import com.dawn.dto.TitleDescDto;

public interface TitleDescService {
	// 查询答案
	TitleDescDto selectByTbtitleId(long tbtitleId);

    void deleteByTitleId(Long titleid);
}
