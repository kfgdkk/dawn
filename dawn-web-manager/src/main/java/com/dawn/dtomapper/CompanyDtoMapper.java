package com.dawn.dtomapper;

import com.dawn.dto.CompanyDto;

import java.util.List;

public interface CompanyDtoMapper {
	// 公司查询题目
	List<CompanyDto> selectByCompanyId(Long companyId);

}
