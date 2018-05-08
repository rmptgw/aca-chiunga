package com.mis.dto;

public class EmpVO {
	private int emp_no;
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	private String emp_name;
	private String emp_id;
	private String emp_pass;
	private String emp_dept;
	private String emp_phone;
	private String emp_email;
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_pass() {
		return emp_pass;
	}
	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}
	public String getEmp_dept() {
		return emp_dept;
	}
	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	public String getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	
	@Override
	public String toString() {
		return "EmpVO [emp_no=" + emp_no + ", emp_name=" + emp_name + ", emp_id=" + emp_id + ", emp_pass=" + emp_pass
				+ ", emp_dept=" + emp_dept + ", emp_phone=" + emp_phone + ", emp_email=" + emp_email + "]";
	}
	
	
	
}