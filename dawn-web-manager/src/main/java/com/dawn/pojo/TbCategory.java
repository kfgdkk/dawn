package com.dawn.pojo;

import java.util.Date;

public class TbCategory {
	private Long categordId;

	private String classname;

	private Long parentid;

	private Date created;

	private Date updated;

	private String tbDescIds;

	public Long getCategordId() {
		return categordId;
	}

	public void setCategordId(Long categordId) {
		this.categordId = categordId;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname == null ? null : classname.trim();
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getTbDescIds() {
		return tbDescIds;
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

	public void setTbDescIds(String tbDescIds) {
		this.tbDescIds = tbDescIds == null ? null : tbDescIds.trim();
	}
}