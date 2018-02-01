package com.dawn.util;

import java.util.List;

public class Result {
	private Long total;
	private List<?> rows;

	public Result() {
	}

	public Result(Long total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
