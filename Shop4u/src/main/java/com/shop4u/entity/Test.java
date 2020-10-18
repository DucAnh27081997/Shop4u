package com.shop4u.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreate;

	private String linkMP4;

	private String name;

	public Test(){
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getLinkMP4() {
		return this.linkMP4;
	}

	public void setLinkMP4(String linkMP4) {
		this.linkMP4 = linkMP4;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}