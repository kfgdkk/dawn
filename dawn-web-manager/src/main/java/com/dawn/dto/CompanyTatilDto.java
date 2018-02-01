package com.dawn.dto;

public class CompanyTatilDto {
	private Long tbComTitId;

	private Long companyId;

	private Long titleId;

	private String createtime;

	private String updatetime;

	private Long asknum;

	private String corporate;

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

	public String getCorporate() {
		return corporate;
	}

	public void setCorporate(String corporate) {
		this.corporate = corporate;
	}

}
