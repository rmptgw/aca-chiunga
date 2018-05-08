package com.mis.dto;

import java.sql.Timestamp;

public class OrdVO {
	int ord_no, cus_no, emp_no, pro_no,pro_price, ord_qtt, pro_qtt;
	String cus_name, cus_phone, cus_email, emp_name;
	
	public int getPro_price() {
		return pro_price;
	}
	public int getPro_qtt() {
		return pro_qtt;
	}
	@Override
	public String toString() {
		return "OrdVO [ord_no=" + ord_no + ", cus_no=" + cus_no + ", emp_no=" + emp_no + ", pro_no=" + pro_no
				+ ", pro_price=" + pro_price + ", ord_qtt=" + ord_qtt + ", pro_qtt=" + pro_qtt + ", cus_name="
				+ cus_name + ", cus_phone=" + cus_phone + ", cus_email=" + cus_email + ", emp_name=" + emp_name
				+ ", ord_date=" + ord_date + "]";
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public void setPro_qtt(int pro_qtt) {
		this.pro_qtt = pro_qtt;
	}
	public int getPro_no() {
		return pro_no;
	}
	public int getOrd_qtt() {
		return ord_qtt;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	public void setOrd_qtt(int ord_qtt) {
		this.ord_qtt = ord_qtt;
	}
	public String getCus_name() {
		return cus_name;
	}
	public String getCus_phone() {
		return cus_phone;
	}
	public String getCus_email() {
		return cus_email;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public void setCus_phone(String cus_phone) {
		this.cus_phone = cus_phone;
	}
	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	Timestamp ord_date;
	
	public int getOrd_no() {
		return ord_no;
	}
	public void setOrd_no(int ord_no) {
		this.ord_no = ord_no;
	}
	public int getOrc_no() {
		return ord_no;
	}
	public int getCus_no() {
		return cus_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public Timestamp getOrd_date() {
		return ord_date;
	}
	public void setOrc_no(int orc_no) {
		this.ord_no = orc_no;
	}
	public void setCus_no(int cus_no) {
		this.cus_no = cus_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public void setOrd_date(Timestamp ord_date) {
		this.ord_date = ord_date;
	}
	
}
