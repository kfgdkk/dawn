package com.dawn.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbTitle implements Serializable {
	private Long tbtitleId;

	private Date created;

	private Date updated;

	private Long clicknum;

	private Long categoryId;

	private String auditStatus;

	private Integer userid;

	private String cause;

	private Integer userType;

	private String title;

	public Long getTbtitleId() {
		return tbtitleId;
	}

	public void setTbtitleId(Long tbtitleId) {
		this.tbtitleId = tbtitleId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}
}