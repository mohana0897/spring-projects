package com.tcl.tclempservice.Dto;


public class FilterSearch {
	
	
	private String column;
	private String value;
	
	
	public FilterSearch() {
		super();
	}


	public FilterSearch(String column, String value) {
		super();
		this.column = column;
		this.value = value;
	}


	public String getColumn() {
		return column;
	}


	public void setColumn(String column) {
		this.column = column;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "FilterSearch [column=" + column + ", value=" + value + "]";
	}
	
	
	
	
	
	
	
}
