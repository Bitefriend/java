package org.joonzis.vo;

import java.sql.Date;

public class CVO {
	private int c_idx, f_idx;
	private String writer, content, pw;
	private Date reg_date;
	
	public CVO() {}

	public CVO(int c_idx, int f_idx, String writer, String content, String pw, Date reg_date) {
		super();
		this.c_idx = c_idx;
		this.f_idx = f_idx;
		this.writer = writer;
		this.content = content;
		this.pw = pw;
		this.reg_date = reg_date;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public int getF_idx() {
		return f_idx;
	}

	public void setF_idx(int f_idx) {
		this.f_idx = f_idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
