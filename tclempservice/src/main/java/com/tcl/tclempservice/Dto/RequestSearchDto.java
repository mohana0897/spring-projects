package com.tcl.tclempservice.Dto;

public class RequestSearchDto {

	public String column;
	
	public String value;

	public String localOperators;
	
	public String joinTable;

	public RequestSearchDto(String column, String value, String localOperators, String joinTable) {
		super();
		this.column = column;
		this.value = value;
		this.localOperators = localOperators;
		this.joinTable = joinTable;
	}

	public RequestSearchDto() {
		super();
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

	public String getLocalOperators() {
		return localOperators;
	}

	public void setLocalOperators(String localOperators) {
		this.localOperators = localOperators;
	}

	public String getJoin_table() {
		return joinTable;
	}

	public void setJoin_table(String joinTable) {
		this.joinTable = joinTable;
	}

	@Override
	public String toString() {
		return "RequestSearchDto [column=" + column + ", value=" + value + ", localOperators=" + localOperators
				+ ", join_table=" + joinTable + "]";
	}
	
	
	
	


	

}
