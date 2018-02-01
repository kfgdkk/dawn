package com.dawn.dto;

public class TitleDescDto {

	private Long descId;

	private Long titleId;

	private String created;

	private String updated;

	private String titleDesc;

	private Long tbtitleId;

	private String title;

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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public Long getTbtitleId() {
		return tbtitleId;
	}

	public void setTbtitleId(Long tbtitleId) {
		this.tbtitleId = tbtitleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	private Long clicknum;

	private Long categoryId;
}
