package com.dawn.service.impl;

import com.dawn.mapper.TbCategoryMapper;
import com.dawn.pojo.TbCategory;
import com.dawn.pojo.TbCategoryExample;
import com.dawn.pojo.TbCategoryExample.Criteria;
import com.dawn.service.TbCategoryService;
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
public class TbCategoryServiceImpl implements TbCategoryService {
	@Autowired
	private TbCategoryMapper tbCategoryMapper;
	@Value("${QUERY_URL}")
	private String QUERY_URL;
	@Value("${TITLE_URL}")
	private String TITLE_URL;

	// 查询知识点导航

	public List<TreePojo> queryCategory(long parentid) {
		TbCategoryExample example = new TbCategoryExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("created desc");
		criteria.andParentidEqualTo(parentid);
		List<TbCategory> list = tbCategoryMapper.selectByExample(example);
		List<TreePojo> result = new ArrayList<TreePojo>();
		for (TbCategory tbCategory : list) {
			TreePojo tree = new TreePojo();
			tree.setId(tbCategory.getCategordId());
			tree.setText(tbCategory.getClassname());
			tree.setState(getChildList(tbCategory.getCategordId()).size() > 0 ? "closed" : "open");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("url", TITLE_URL + tbCategory.getCategordId());
			tree.setAttributes(map);
			result.add(tree);
		}
		return result;
	}
	//因为移动端需要返回DawnResult封装的数据,所以重新创建一个方法用于封装数据,
	public DawnResult getCategory(long parentid) {
		TbCategoryExample example = new TbCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(parentid);
		List<TbCategory> list = tbCategoryMapper.selectByExample(example);
		if(list!=null && list.size()>0){
			return DawnResult.build(200,null,list);
		}else{
			return DawnResult.build(400,"加载失败,请稍后重试");
		}

	}

	// 查询子节点

	public List<TbCategory> getChildList(long parentid) {
		TbCategoryExample example = new TbCategoryExample();
		example.setOrderByClause("created desc");
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(parentid);
		List<TbCategory> list = tbCategoryMapper.selectByExample(example);
		return list;
	}

	// 新增知识点类型

	public void saveCategory(TbCategory category) {
		// 补全数据
		Date date = new Date();
		category.setCreated(date);
		category.setUpdated(date);
		category.setTbDescIds("1");
		tbCategoryMapper.insert(category);
	}

	// 修改知识点

	public void updateCategory(TbCategory tbCategory) {
		tbCategory.setUpdated(new Date());
		tbCategoryMapper.updateByPrimaryKeySelective(tbCategory);

	}

	// 按照Id查询

	public TbCategory queryById(long categordId) {
		return tbCategoryMapper.selectByPrimaryKey(categordId);

	}

	// 删除知识点
//
	public void deleteCategory(long categordId) {
		tbCategoryMapper.deleteByPrimaryKey(categordId);

	}
//全查
	public Result queryCategory1(long parentId, int page, int rows) {
		PageHelper.startPage(page, rows);
		TbCategoryExample example = new TbCategoryExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("created desc");
		criteria.andParentidEqualTo(parentId);
		List<TbCategory> list = tbCategoryMapper.selectByExample(example);
        /*List<TreePojo> result = new ArrayList<TreePojo>();
		for (TbCategory tbCategory : list) {
			TreePojo tree = new TreePojo();
			tree.setId(tbCategory.getCategordId());
			tree.setText(tbCategory.getClassname());
			tree.setState(getChildList(tbCategory.getCategordId()).size() > 0 ? "closed" : "open");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("url", TITLE_URL + tbCategory.getCategordId());
			tree.setAttributes(map);
			result.add(tree);
		}*/
		PageInfo<TreePojo> pageInfo = new PageInfo(list);
		Result result1 = new Result();
		result1.setRows(list);

		result1.setTotal(pageInfo.getTotal());
		return result1;
	}
//查找一个知识点的回显
	public TbCategory findTbCategory(long id) {
		return tbCategoryMapper.selectByPrimaryKey(id);
	}

}
