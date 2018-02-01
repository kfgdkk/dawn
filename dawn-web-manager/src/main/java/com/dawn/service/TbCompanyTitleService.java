package com.dawn.service;

import com.dawn.dto.CompanyTatilDto;
import com.dawn.pojo.TbCompany;
import com.dawn.util.DawnResult;
import com.dawn.util.PageResult;
import com.dawn.util.Result;

import java.util.List;

public interface TbCompanyTitleService {
	// public Result getCompanyTitle(int rows, int page, Long titleId);
	public Result getCompanyTitle(Long titleId);

	public List<TbCompany> getAllCompany();

	// 公司联想查询
	public List<TbCompany> getByName(String corporate, int usertype);

	public DawnResult updateAskNum(CompanyTatilDto companyTatilDto);

	public DawnResult addAskNum(CompanyTatilDto companyTatilDto);
	//分页模糊查询公司
	PageResult searchCompany(TbCompany tbCompany, int page, int rows, int type);
	//按父id查询公司
	PageResult findByParentId(int page, int rows,long parentId);
}
