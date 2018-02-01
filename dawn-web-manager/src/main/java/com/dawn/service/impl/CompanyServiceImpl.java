package com.dawn.service.impl;

import com.dawn.dto.CompanyDto;
import com.dawn.dtomapper.CompanyDtoMapper;
import com.dawn.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDtoMapper mapper;
	// 导航功能--根据公司名称查询出该公司的所有题目

	// 根据题目类型获取题目列表

	/*
	 * @Override public Result selectCompanyId(int page, int rows, long
	 * companyId) { PageHelper.startPage(page, rows); List<CompanyDto> list =
	 * mapper.selectByCompanyId(companyId); PageInfo<CompanyDto> pageInfo = new
	 * PageInfo<>(list); Result result = new Result();
	 * result.setTotal(pageInfo.getTotal()); result.setRows(list); return
	 * result; }
	 */


	public List<CompanyDto> selectCompanyId(long companyId) {

		List<CompanyDto> list = mapper.selectByCompanyId(companyId);

		return list;
	}

}
