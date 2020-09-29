package com.shop4u.Model;

public class ProductDTO {
	private int id;
	private String name;
	private double cost;
	private String img;
	private String detail;

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

	public double getCost() {
		return cost;
	}

	public void setCost(double d) {
		this.cost = d;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public ProductDTO() {
	};

	public ProductDTO(int id, String name, float cost, String img, String detail) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.img = img;
		this.detail = detail;
	}

}
