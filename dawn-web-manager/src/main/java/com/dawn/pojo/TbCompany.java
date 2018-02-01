package com.dawn.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbCompany implements Serializable {
	private Long companyId;

	private String corporate;

	private Date createTime;

	private Date updateTime;

	private Long parentid;

	private String auditStatus;

	private Integer userid;

	private String cause;

	private Integer userType;

	private String companyinfo;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCorporate() {
		return corporate;
	}

	public void setCorporate(String corporate) {
		this.corporate = corporate == null ? null : corporate.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus == null ? null : auditStatus.trim();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause == null ? null : cause.trim();
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getCompanyinfo() {
		return companyinfo;
	}

	public void setCompanyinfo(String companyinfo) {
		this.companyinfo = companyinfo == null ? null : companyinfo.trim();
	}
}