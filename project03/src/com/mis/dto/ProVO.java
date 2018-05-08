package com.mis.dto;

public class ProVO {
	private String pro_name;
	private Integer pro_no, pro_price, pro_stock;

	public Integer getPro_no() {
		return pro_no;
	}

	public void setPro_no(Integer pro_no) {
		this.pro_no = pro_no;
	}

	public String getPro_name() {
		return pro_name;
	}

	public Integer getPro_price() {
		return pro_price;
	}

	public Integer getPro_stock() {
		return pro_stock;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public void setPro_price(Integer pro_price) {
		this.pro_price = pro_price;
	}

	public void setPro_stock(Integer pro_stock) {
		this.pro_stock = pro_stock;
	}

	@Override
	public String toString() {
		return "ProductVO [pro_name=" + pro_name + ", pro_price=" + pro_price + ", pro_stock=" + pro_stock + "]";
	}

}
