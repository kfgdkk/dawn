package com.dawn.service.impl;

import com.dawn.dto.CompanyDto;
import com.dawn.dto.CompanyTatilDto;
import com.dawn.dtomapper.CompanyDtoMapper;
import com.dawn.dtomapper.TbCategoryTitleDtoMapper;
import com.dawn.mapper.TbCategoryTitleMapper;
import com.dawn.mapper.TbCompanyMapper;
import com.dawn.mapper.TbTitleMapper;
import com.dawn.pojo.*;
import com.dawn.pojo.TbCompanyExample.Criteria;
import com.dawn.service.TbCompanyTitleService;
import com.dawn.util.DawnResult;
import com.dawn.util.PageResult;
import com.dawn.util.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TbCompanyTitleServiceImpl implements TbCompanyTitleService {
	@Autowired
	private TbCategoryTitleDtoMapper tbCategoryTitleDtoMapper;
	@Autowired
	private TbCategoryTitleMapper categoryTitleMapper;
	@Autowired
	private TbCompanyMapper companyMapper;
	@Autowired
	private TbTitleMapper titleMapper;
	@Autowired
	private CompanyDtoMapper mapper;


	// 根据题目id 查出公司的提问明细
	/*
	 * public Result getCompanyTitle(int rows, int page, Long titleId) {
	 * PageHelper.startPage(page, rows); List<CompanyTatilDto> list =
	 * tbCategoryTitleDtoMapper.selectBytitleId(titleId);
	 * PageInfo<CompanyTatilDto> info = new PageInfo<>(list); Result result =
	 * new Result(); result.setRows(list); result.setTotal(info.getTotal());
	 * return result; }
	 */
	public Result getCompanyTitle(Long titleId) {
		List<CompanyTatilDto> list = tbCategoryTitleDtoMapper.selectBytitleId(titleId);
		Result result = new Result();
		result.setRows(list);
		return result;
	}

	// 查询所有公司

	public List<TbCompany> getAllCompany() {
		// TODO Auto-generated method stub
		TbCompanyExample example = new TbCompanyExample();
		example.setOrderByClause("create_time desc");
		return companyMapper.selectByExample(example);
	}

	// 对公司提问过的题目进行一次新的提问追加

	public DawnResult updateAskNum(CompanyTatilDto companyTatilDto) {
		TbCategoryTitle tbCategoryTitle = new TbCategoryTitle();
		tbCategoryTitle.setAsknum(companyTatilDto.getAsknum() + 1);
		tbCategoryTitle.setTbComTitId(companyTatilDto.getTbComTitId());
		Date date = new Date();
		tbCategoryTitle.setUpdatetime(date);
		categoryTitleMapper.updateByPrimaryKeySelective(tbCategoryTitle);
		// categoryTitleMapper.updateByPrimaryKey(tbCategoryTitle);
		TbTitle title = titleMapper.selectByPrimaryKey(companyTatilDto.getTitleId());
		title.setClicknum(title.getClicknum() + 1);
		titleMapper.updateByPrimaryKeySelective(title);
		return DawnResult.ok();
	}

	// 新增公司提问（原先没有该公司提问）

	public DawnResult addAskNum(CompanyTatilDto companyTatilDto) {
		TbCategoryTitle tbCategoryTitle = new TbCategoryTitle();
		TbCategoryTitleExample example = new TbCategoryTitleExample();
		TbCategoryTitleExample.Criteria criteria = example.createCriteria();
		criteria.andCompanyIdEqualTo(companyTatilDto.getCompanyId());
		criteria.andTitleIdEqualTo(companyTatilDto.getTitleId());
		List<TbCategoryTitle> list = categoryTitleMapper.selectByExample(example);
		Date date = new Date();
		if (list.size() <= 0) {

			tbCategoryTitle.setAsknum((long) 1);
			tbCategoryTitle.setTitleId(companyTatilDto.getTitleId());
			tbCategoryTitle.setCompanyId(companyTatilDto.getCompanyId());
			tbCategoryTitle.setCreatetime(date);
			tbCategoryTitle.setUpdatetime(date);

			categoryTitleMapper.insert(tbCategoryTitle);

		} else {
			TbCategoryTitle categoryTitle = list.get(0);
			categoryTitle.setAsknum(categoryTitle.getAsknum() + 1);
			categoryTitle.setUpdatetime(date);
			categoryTitleMapper.updateByPrimaryKey(categoryTitle);
		}
		TbTitle title = titleMapper.selectByPrimaryKey(companyTatilDto.getTitleId());
		title.setClicknum(title.getClicknum() + 1);
		titleMapper.updateByPrimaryKeySelective(title);
		return DawnResult.ok();
	}

	// 根据公司名称模糊查询公司的列表

	public List<TbCompany> getByName(String corporate, int usertype) {
		TbCompanyExample example = new TbCompanyExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCorporateLike("%" + corporate + "%");
		createCriteria.andUserTypeEqualTo(usertype);
		List<TbCompany> list = companyMapper.selectByExample(example);
		return list;
	}
	//分页模糊查询公司
	public PageResult searchCompany(TbCompany tbCompany, int page, int rows,int type) {
		PageHelper.startPage(page,rows);
		TbCompanyExample example = new TbCompanyExample();
		TbCompanyExample.Criteria criteria = example.createCriteria();
		if (tbCompany!=null){
			if(tbCompany.getCorporate()!=null && tbCompany.getCorporate().length()>0){
				criteria.andCorporateLike("%"+tbCompany.getCorporate()+"%");
			}

		}
		criteria.andUserTypeEqualTo(type);
		Page<TbCompany> pageResult = (Page<TbCompany>) companyMapper.selectByExample(example);
		return new PageResult(pageResult.getTotal(),pageResult.getResult());

	}
	//根据父id查询
	public PageResult findByParentId(int page, int rows, long parentId) {
		PageHelper.startPage(page,rows);
		Page<CompanyDto> pageResult = (Page<CompanyDto>) mapper.selectByCompanyId(parentId);
		return new PageResult(pageResult.getTotal(),pageResult.getResult());
	}
}
