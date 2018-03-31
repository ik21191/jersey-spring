package com.mypack.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int id;
	private String name;
	
	private EmpDetail empDetail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmpDetail getEmpDetail() {
		return empDetail;
	}

	public void setEmpDetail(EmpDetail empDetail) {
		this.empDetail = empDetail;
	}
	
	
}
