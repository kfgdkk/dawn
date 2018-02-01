package com.dawn.service;

import com.dawn.pojo.TbTitle;
import com.dawn.pojo.TbTitleCustom;
import com.dawn.util.DawnResult;
import com.dawn.util.Response;
import com.dawn.util.Result;

import java.util.List;

public interface TbTitleService {

	DawnResult saveTitle(TbTitle title, String titleDesc, Integer userType, Integer userId) throws Exception;

	DawnResult delTitle(long tbtitleId);

	DawnResult delDesc(long titleId);

	DawnResult updateTitle(TbTitle title, String titleDesc) throws Exception;

	Result getByName(String title, int page, int rows, int userType);

	List<TbTitle> getTitleAuditList(int userid);

	String selectTitleById(Long tbtitleId);

	// 根据查询状态码查询待审核知识点
	List<TbTitleCustom> getByAuditStatu(int id); 

	// 通过，根据题目id修改审核状态码，并刷新当前页面。 李先生
	void updateStatu(long id);

	// 保存未通过原因 李先生
	void updateTbtitle(long tbtitleId, String cause);

	List<TbTitle> getTitleList(Long categoryId);
	Result getTitleLists(Long categoryId, int page, int rows);
	// 根据题目ID查询题目
	TbTitle queryByTitleId(Long id);
	//分页  李先生
	Result findPage(int pageNum,int pageSize,int userid);
	//从tb_title 表查找 hr提出的问题
	List<TbTitle> selectHRquestions();

	//最容易被面试官看穿的问题
	Response seeThrough();

	//查询前15的常见问题
	Response selecttopfifteen();
	//一周高频面试题
	List<TbTitle> getTbTitleHF();

//王成--详情
	Result getTitleList1(Long categordId, int page, int rows);
}
