package com.dawn.pojo;

import java.util.Date;

public class TbCategoryTitle {
	private Long tbComTitId;

	private Long companyId;

	private Long titleId;

	private Date createtime;

	private Date updatetime;

	private Long asknum;

	public Long getTbComTitId() {
		return tbComTitId;
	}

	public void setTbComTitId(Long tbComTitId) {
		this.tbComTitId = tbComTitId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getTitleId() {
		return titleId;
	}

	public void setTitleId(Long titleId) {
		this.titleId = titleId;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Long getAsknum() {
		return asknum;
	}

	public void setAsknum(Long asknum) {
		this.asknum = asknum;
	}
}