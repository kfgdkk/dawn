package com.dawn.service.impl;

import com.dawn.mapper.TbCategoryTitleMapper;
import com.dawn.mapper.TbDescMapper;
import com.dawn.mapper.TbTitleMapper;
import com.dawn.pojo.ActiveUser;
import com.dawn.pojo.TbCategoryTitle;
import com.dawn.pojo.TbDesc;
import com.dawn.pojo.TbTitle;
import com.dawn.service.TbtitleHandleService;
import com.dawn.util.DawnResult;
import com.dawn.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TbtitleHandleServiceImpl implements TbtitleHandleService {
	@Autowired
	private TbTitleMapper titleMapper;
	@Autowired
	private TbDescMapper descMapper;
	@Autowired
	private TbCategoryTitleMapper catemapper;



	/**
	 *
	 * <p>
	 * Title: saveTitle
	 * </p>
	 * <p>
	 * Description:给公司添加题目和答案
	 * </p>
	 *
	 * @param title
	 * @param titleDesc
	 * @param companyId
	 * @return
	 * @throws Exception
	//* @see TbtitleHandleService#saveTitle(TbTitle,
	 *      String, Long)
	 */
	public DawnResult saveTitle(String title, String titleDesc, Long companyId,ActiveUser activeUser) throws Exception {
		TbTitle tbTitle = new TbTitle();
		tbTitle.setTitle(title);
		long titleId = IDUtils.genTitleId();
		Date date = new Date();
		tbTitle.setTbtitleId(titleId);
		tbTitle.setCreated(date);
		tbTitle.setUpdated(date);
		tbTitle.setClicknum((long) 1);
		//新增列  审核状态为 0 未审核
		tbTitle.setAuditStatus("0");
		//新增列 用户所属部门
		tbTitle.setUserType(activeUser.getUser_type());
		//新增列，用户ID
		tbTitle.setUserid(activeUser.getUserid());
		titleMapper.insert(tbTitle);

		DawnResult result = saveDesc(titleId, titleDesc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		DawnResult result2 = saveCompanyId(companyId, titleId);
		if (result2.getStatus() != 200) {
			throw new Exception();
		}
		return DawnResult.ok();
	}
	public DawnResult saveTitle(TbTitle title, String titleDesc, Long companyId,ActiveUser activeUser) throws Exception {
		long titleId = IDUtils.genTitleId();
		Date date = new Date();
		title.setTbtitleId(titleId);
		title.setCreated(date);
		title.setUpdated(date);
		title.setClicknum((long) 1);
		//新增列  审核状态为 0 未审核
		title.setAuditStatus("0");
		//新增列 用户所属部门
		title.setUserType(activeUser.getUser_type());
		//新增列，用户ID
		title.setUserid(activeUser.getUserid());
		titleMapper.insert(title);

		DawnResult result = saveDesc(titleId, titleDesc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		DawnResult result2 = saveCompanyId(companyId, titleId);
		if (result2.getStatus() != 200) {
			throw new Exception();
		}
		return DawnResult.ok();
	}

	// 保存答案
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

	// 题目答案同步到公司里
	private DawnResult saveCompanyId(Long companyId, Long titleId) {
		TbCategoryTitle tbcate = new TbCategoryTitle();
		Date date = new Date();
		tbcate.setCreatetime(date);
		tbcate.setUpdatetime(date);
		tbcate.setCompanyId(companyId);
		tbcate.setTitleId(titleId);
		catemapper.insert(tbcate);
		return DawnResult.ok();
	}
}
