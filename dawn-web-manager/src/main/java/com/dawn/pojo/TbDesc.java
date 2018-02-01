package com.dawn.pojo;

import java.util.Date;

public class TbDesc {
	private Long descId;

	private Long titleId;

	private Date created;

	private Date updated;

	private String titleDesc;

	public Long getDescId() {
		return descId;
	}

	public void setDescId(Long descId) {
		this.descId = descId;
	}

	public Long getTitleId() {
		return titleId;
	}

	public void setTitleId(Long titleId) {
		this.titleId = titleId;
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

	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

}