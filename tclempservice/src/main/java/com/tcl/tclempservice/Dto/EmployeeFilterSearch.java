package com.tcl.tclempservice.Dto;

import java.util.List;

public class EmployeeFilterSearch {
	
	public List<RequestSearchDto> empFilterSearchList;
	
	public String globalOperators;
	
	
	
	public EmployeeFilterSearch() {
		super();
	
	}



	public EmployeeFilterSearch(List<RequestSearchDto> empFilterSearchList, String globalOperators) {
		super();
		this.empFilterSearchList = empFilterSearchList;
		this.globalOperators = globalOperators;
	}



	public List<RequestSearchDto> getEmpFilterSearchList() {
		return empFilterSearchList;
	}



	public void setEmpFilterSearchList(List<RequestSearchDto> empFilterSearchList) {
		this.empFilterSearchList = empFilterSearchList;
	}



	public String getGlobalOperators() {
		return globalOperators;
	}



	public void setGlobalOperators(String globalOperators) {
		this.globalOperators = globalOperators;
	}



	@Override
	public String toString() {
		return "EmployeeFilterSearch [empFilterSearchList=" + empFilterSearchList + ", globalOperators="
				+ globalOperators + "]";
	}
	
	
	
	

}
