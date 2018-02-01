package com.dawn.service.impl;

import com.dawn.jedis.dao.JedisClient;
import com.dawn.mapper.TbDescMapper;
import com.dawn.mapper.TbTitleCustomMapper;
import com.dawn.mapper.TbTitleMapper;
import com.dawn.pojo.*;
import com.dawn.pojo.TbTitleExample.Criteria;
import com.dawn.service.TbTitleService;
import com.dawn.util.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List; 

@Service
public class TbTitleServiceImpl implements TbTitleService {
	@Autowired
	private TbTitleMapper titleMapper;
	@Autowired
	private TbDescMapper descMapper;
	@Autowired
	private TbTitleCustomMapper customMapper;
	@Autowired
	private JedisClient jedisClient;

	private static  final Logger LOGGER = LoggerFactory.getLogger(TbTitleServiceImpl.class);
	/**
	 * 
	 * <p>
	 * Title: getTitleList
	 * </p>
	 * <p>
	 * Description: 查询题目列表
	 * </p>
	 * 
	 * @param page
	 * @param rows
	 * @return
	 //* @see TbTitleService#getTitleList(int, int)
	 */
	// 根据题目类型获取题目列表
	public Result getTitleLists(Long categoryId, int page, int rows) {
		TbTitleExample example = new TbTitleExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("clicknum DESC");
		criteria.andCategoryIdEqualTo(categoryId);
		criteria.andAuditStatusEqualTo("2");
		PageHelper.startPage(page, rows);
		List<TbTitle> list = titleMapper.selectByExample(example);
		PageInfo<TbTitle> pageInfo = new PageInfo(list);
		Result result = new Result();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

// 根据题目类型获取题目列表
	public List<TbTitle> getTitleList(Long categoryId) {
		TbTitleExample example = new TbTitleExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("clicknum DESC");
		criteria.andCategoryIdEqualTo(categoryId);
		criteria.andAuditStatusEqualTo("2");
		List<TbTitle> list = titleMapper.selectByExample(example);
//		Result result = new Result();
//		result.setRows(list);
//		result.setTotal(pageInfo.getTotal());
//		System.out.println(list.get(0).getCreated()+""+list.get(0).getUpdated() );
		return list;
	}


	// 删除题目
	public DawnResult delTitle(long tbtitleId) {
		titleMapper.deleteByPrimaryKey(tbtitleId);
		return DawnResult.ok();
	}

	// 删除答案

	public DawnResult delDesc(long titleId) {
		TbDescExample example = new TbDescExample();
		TbDescExample.Criteria criteria = example.createCriteria();
		criteria.andTitleIdEqualTo(titleId);
		descMapper.deleteByExample(example);
		return DawnResult.ok();
	}

	/**
	 * 
	 * <p>
	 * Title: saveTitle
	 * </p>
	 * <p>
	 * Description: 添加题目
	 * </p>
	 * 
	 * @param title
	 * @return
	 * @throws Exception
	// * @see TbTitleService#saveTitle(TbTitle)
	 */

	public DawnResult saveTitle(TbTitle title, String titleDesc, Integer userType, Integer userId) throws Exception {
		long titleId = IDUtils.genTitleId();
		Date date = new Date();
		title.setTbtitleId(titleId);// 题目id
		title.setCreated(date);
		title.setUpdated(date);
		title.setClicknum((long) 0);
		// 新增列 审核状态为 0 未审核
		title.setAuditStatus("0");
		// 新增列 用户所属部门
		title.setUserType(userType);
		// 新增列，用户ID
		title.setUserid(userId);
		titleMapper.insertSelective(title);
		DawnResult result = saveDesc(titleId, titleDesc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		return DawnResult.ok();
	}

	// 修改题目

	public DawnResult updateTitle(TbTitle title, String titleDesc) throws Exception {
		Date date = new Date();
		title.setUpdated(date);
		title.setAuditStatus("0");
		titleMapper.updateByPrimaryKeySelective(title);// 修改指定的字段
		DawnResult result = updateDesc(title.getTbtitleId(), titleDesc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		return DawnResult.ok();
	}

	// 新增答案
	private DawnResult saveDesc(Long titleId, String titleDesc) {
		TbDesc tbdesc = new TbDesc();
		Date date = new Date();
		tbdesc.setCreated(date);
		tbdesc.setTitleDesc(titleDesc);
		tbdesc.setUpdated(date);
		tbdesc.setTitleId(titleId);
		descMapper.insert(tbdesc);
		return DawnResult.ok();
	}

	// 修改答案
	private DawnResult updateDesc(Long titleId, String titleDesc) {
		TbDescExample example = new TbDescExample();
		Date date = new Date();
		TbDescExample.Criteria criteria = example.createCriteria();
		criteria.andTitleIdEqualTo(titleId);
		List<TbDesc> list = descMapper.selectByExampleWithBLOBs(example);
		TbDesc desc = list.get(0);
		desc.setTitleDesc(titleDesc);
		desc.setUpdated(date);
		descMapper.updateByPrimaryKeyWithBLOBs(desc);
		return DawnResult.ok();
	}

	// 按照题目查询

	public Result getByName(String title, int page, int rows, int userType) {
		List<TbTitle> list = titleMapper.getByTitleNameList(title, userType);
		PageInfo<TbTitle> info = new PageInfo(list);
		Result result = new Result();
		result.setRows(list);
		result.setTotal(info.getTotal());
		return result;
	}

	/**
	 * 审核机制 根据用户id 查询题目的审核状态
	 */

	public List<TbTitle> getTitleAuditList(int userid) {
		TbTitleExample example = new TbTitleExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andAuditStatusNotEqualTo("2");
		List<TbTitle> list = titleMapper.selectByExample(example);
		return list;
	}

	/**
	 * 根据题目id获得题目名称
	 */

	public String selectTitleById(Long tbtitleId) {
		return titleMapper.selectByPrimaryKey(tbtitleId).getTitle();
	}

	// 查询待审核知识点

	public List<TbTitleCustom> getByAuditStatu(int id) {
		List<TbTitleCustom> list = customMapper.getByAuditStatuAndUserId(id);
		return list;
	}

	//分页查询待审核知识点   李先生
	public Result findPage(int pageNum, int pageSize,@Param(value = "id") int userid) {
		PageHelper.startPage(pageNum,pageSize);
		List<TbTitleCustom> list = customMapper.getByAuditStatuAndUserId(userid);
		Page<TbTitleCustom> pageInfo = (Page<TbTitleCustom>) list;
		return new Result(pageInfo.getTotal(),pageInfo.getResult());
	}

	// 通过，根据题目id修改审核状态码，并刷新当前页面。 李先生
	public void updateStatu(long id) {
		TbTitle title = titleMapper.selectByPrimaryKey(id);
		title.setAuditStatus("2");
		titleMapper.updateByPrimaryKey(title);
	}

	// 保存未通过原因字段  字符串也页面匹配，请勿胡乱修改  李先生
	public void updateTbtitle(long tbtitleId, String cause) {
		TbTitle title = titleMapper.selectByPrimaryKey(tbtitleId);
		if (cause.equals("2")) {
			title.setCause("知识点描述不清楚！");
		}
		if (cause.equals("1")) {
			title.setCause("书写不符合规范！");
		}
		title.setAuditStatus("1");
		titleMapper.updateByPrimaryKey(title);
	}

	// 根据题目id查询题目信息
	public TbTitle queryByTitleId(Long id) {
		return titleMapper.selectByPrimaryKey(id);
	}

	//查找 排行模块 HR20问
	public List<TbTitle> selectHRquestions() {
		LOGGER.debug("tbtitleServiceImpl selectHRquestions方法开始");
		String jsonData = jedisClient.get("TBTITLE_HR_QUESTIONS");
		if(StringUtils.isNotBlank(jsonData)){
			List<TbTitle> tbTitles = JsonUtils.jsonToList(jsonData, TbTitle.class);
			return  tbTitles;
		}
		//添加缓存逻辑 查询结果存入redis 并设置有效期24小时
		List<TbTitle> tbTitles = titleMapper.selectHRquestions();
		jedisClient.set("TBTITLE_HR_QUESTIONS", JsonUtils.objectToJson(tbTitles));
		jedisClient.expire("TBTITLE_HR_QUESTIONS",86400);
		return  tbTitles;
	}

	//最容易被面试官看穿的问题
	public Response seeThrough() {
		List<TbTitle> list = titleMapper.seeThrough();
		if (list!=null && list.size()>0){
			return Response.build().setData(list);
		}else {
			return null;
		}
	}

	//查询前15的常见问题
	public Response selecttopfifteen() {
		List<TbTitle> list =titleMapper.selecttopfifteen();
		if (list!=null && list.size()>0){
			return Response.build().setData(list);
		}
		return null;
	}

	//路遥酒后著
	public List<TbTitle> getTbTitleHF() {
		//得到七天前的时间
		//格式化日期的对象(转化成习惯的时间格式)
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//静态方法getInstance()使用默认时区和语言环境获得一个日历。
		Calendar calendar= Calendar.getInstance();
		String nowdate = sdFormat.format(calendar.getTime());
		//输出当前系统时间;
		//System.out.println("当前系统时间: "+sdFormat.format(calendar.getTime()));

		//add()增加日期，以天为单位（Calendar封装了很多静态的操作时间的单位）
		//增加10天，负数则为减少天数
		calendar.add(Calendar.DATE,-7);

		//输出增加10天后的时间;
		//System.out.println("减少7天后的时间: "+sdFormat.format(calendar.getTime()));
		String olddate7 = sdFormat.format(calendar.getTime());
		return titleMapper.getTbTitleHF(nowdate,olddate7);

	}
	//分页查题目-王陈
	public Result getTitleList1(Long categoryId, int page, int rows) {

		TbTitleExample example = new TbTitleExample();
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("clicknum DESC");
		criteria.andCategoryIdEqualTo(categoryId);
		criteria.andAuditStatusEqualTo("2");
		PageHelper.startPage(page, rows);
		List<TbTitle> list = titleMapper.selectByExample(example);
		PageInfo<TbTitle> pageInfo = new PageInfo(list);
		Result result = new Result();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
