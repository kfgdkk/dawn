package com.dawn.service.impl;

import com.dawn.mapper.TbCompanyMapper;
import com.dawn.pojo.TbCompany;
import com.dawn.pojo.TbCompanyExample;
import com.dawn.pojo.TbCompanyExample.Criteria;
import com.dawn.service.TbCompanyService;
import com.dawn.util.DawnResult;
import com.dawn.util.Result;
import com.dawn.util.TreePojo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TbCompanyServiceImpl implements TbCompanyService {
	@Autowired
	private TbCompanyMapper tbCompanyMapper;
	@Value("${COMPANY_URL}")
	private String COMPANY_URL;


	// 查询公司的树形结构
	public List<TreePojo> queryCompany(long parentid) {
		TbCompanyExample example = new TbCompanyExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentidEqualTo(parentid);
		createCriteria.andAuditStatusEqualTo("2");
		example.setOrderByClause("create_time desc");
		List<TbCompany> list = tbCompanyMapper.selectByExampleWithBLOBs(example);
		List<TreePojo> result = new ArrayList<TreePojo>();
		for (TbCompany tbCompany : list) {
			TreePojo tree = new TreePojo();
			tree.setId(tbCompany.getCompanyId());
			tree.setText(tbCompany.getCorporate());
			tree.setState(getChildList(tbCompany.getCompanyId()).size() > 0 ? "closed" : "open");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("url", tbCompany.getCompanyId());
			map.put("url", COMPANY_URL + tbCompany.getCompanyId());
			map.put("com", tbCompany.getCompanyinfo());
			tree.setAttributes(map);

			result.add(tree);
		}
		return result;
	}

	public DawnResult getCompany(long parentid) {
		TbCompanyExample example = new TbCompanyExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentidEqualTo(parentid);
		List<TbCompany> list = tbCompanyMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return DawnResult.build(200,null,list);
		}else{
			return DawnResult.build(400,"正在努力加载中");
		}
	}


	// 查询是否有子节点
	public List<TbCompany> getChildList(long parentid) {
		TbCompanyExample example = new TbCompanyExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andParentidEqualTo(parentid);
		List<TbCompany> list = tbCompanyMapper.selectByExample(example);
		return list;
	}


	// 新增公司
	public void saveCompany(TbCompany company) {
		// 补全数据
		Date date = new Date();
		company.setCreateTime(date);
		company.setUpdateTime(date);
		tbCompanyMapper.insert(company);

	}

	// 修改公司

	public void updateCompany(TbCompany company) {
		Date date = new Date();
		company.setUpdateTime(date);
		tbCompanyMapper.updateByPrimaryKeySelective(company);
	}

	// 按照Id查询

	public TbCompany queryById(long companyId) {

		return tbCompanyMapper.selectByPrimaryKey(companyId);
	}

	// 删除公司

	public void deleteCompany(long companyId) {
		tbCompanyMapper.deleteByPrimaryKey(companyId);

	}

	// 模糊查询公司

	public Result queryByName(int page, int rows, String corporate, int userType) {
		TbCompanyExample example = new TbCompanyExample();
		Criteria criteria = example.createCriteria();
		criteria.andCorporateLike("%" + corporate + "%");
		criteria.andUserTypeEqualTo(userType);
		List<TbCompany> list = tbCompanyMapper.selectByExample(example);
		PageHelper.startPage(page, rows);
		PageInfo<TbCompany> info = new PageInfo(list);
		Result result = new Result();
		result.setRows(list);
		result.setTotal(info.getTotal());
		return result;
	}

	/**
	 * 审核机制 根据用户id查询题目的审核状态
	 */

	public List<TbCompany> getCompanyByAuditstatusList(Integer userid) {
		TbCompanyExample example = new TbCompanyExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andAuditStatusNotEqualTo("2");
		List<TbCompany> list = tbCompanyMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	/**
	 * 根据id查看一条数据的名称
	 */

	public TbCompany selectCompanyById(long companyId) {
		return tbCompanyMapper.selectByPrimaryKey(companyId);
	}

	/**
	 * 批量删除公司
	 */
	public void deleteMore(Long[] ids) {
		for(Long companyId:ids){
			tbCompanyMapper.deleteByPrimaryKey(companyId);
		}
	}

}
