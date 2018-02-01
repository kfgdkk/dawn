package com.dawn.service;

import java.util.List;

import com.dawn.dto.CompanyDto;

public interface CompanyService {
	/*
	 * // 查询公司知识点 public Result selectCompanyId(int page, int rows, long
	 * companyId);
	 */
	// 查询公司知识点
	public List<CompanyDto> selectCompanyId(long companyId);
}
