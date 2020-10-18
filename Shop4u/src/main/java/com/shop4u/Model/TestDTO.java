package com.shop4u.Model;

import java.util.Date;

public class TestDTO {
	private int id;
	private String name , linkMP4;
	private Date dateCreate;
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
	public String getLinkMP4() {
		return linkMP4;
	}
	public void setLinkMP4(String linkMP4) {
		this.linkMP4 = linkMP4;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	public TestDTO(int id, String name, String linkMP4, Date dateCreate) {
		this.id = id;
		this.name = name;
		this.linkMP4 = linkMP4;
		this.dateCreate = dateCreate;
	}
	public TestDTO() {
		
	}
}
