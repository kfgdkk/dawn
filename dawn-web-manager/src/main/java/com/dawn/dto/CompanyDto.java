package com.dawn.dto;

import java.util.Date;

public class CompanyDto {

	private Long titleId;

	private Long tbtitleId;

	private String title;

	private Date created;

	private Date updated;

	private Long clicknum;

	private Long categoryId;

	private Long tbComTitId;

	private Long companyId;

	private String createtime;

	private String updatetime;

	private Long asknum;

	public Long getTbtitleId() {
		return tbtitleId;
	}

	public void setTbtitleId(Long tbtitleId) {
		this.tbtitleId = tbtitleId;
	}

	public Long getTitleId() {
		return titleId;
	}

	public void setTitleId(Long titleId) {
		this.titleId = titleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Long getClicknum() {
		return clicknum;
	}

	public void setClicknum(Long clicknum) {
		this.clicknum = clicknum;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

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

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public Long getAsknum() {
		return asknum;
	}

	public void setAsknum(Long asknum) {
		this.asknum = asknum;
	}

}
