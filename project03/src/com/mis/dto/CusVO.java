package com.mis.dto;

public class CusVO {
	/*
	 * CREATE TABLE "MIS"."CUSTOMER" 
	   (	"CUS_NO" NUMBER NOT NULL ENABLE, 
		"CUS_NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
		"CUS_ADR" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
		"CUS_PHONE" VARCHAR2(11 BYTE) NOT NULL ENABLE, 
		"CUS_EMAIL" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
		"CUS_POST" VARCHAR2(5 BYTE) NOT NULL ENABLE, 
		CONSTRAINT "CUSTOMER_PK" PRIMARY KEY ("CUS_NO")
		);
		 */
	private int cno;
	private String cname;
	private String cpost; 
	private String caddr;
	private String cphone;
	private String cemail;

	// getter and setter
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpost() {
		return cpost;
	}
	public void setCpost(String cpost) {
		this.cpost = cpost;
	}
	public String getCaddr() {
		return caddr;
	}
	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	
}
