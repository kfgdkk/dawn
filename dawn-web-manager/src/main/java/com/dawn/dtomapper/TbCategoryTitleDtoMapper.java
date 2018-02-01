package com.dawn.dtomapper;

import java.util.List;

import com.dawn.dto.CompanyTatilDto;

public interface TbCategoryTitleDtoMapper {
	public List<CompanyTatilDto> selectBytitleId(Long titleId);
}
