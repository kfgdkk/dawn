package com.dawn.util;

import java.util.HashMap;
import java.util.Map;

public class TreePojo {
	private long id;
	private String text;
	private String state;
	// attributes
	private Map<String, Object> attributes = new HashMap<String, Object>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

}
