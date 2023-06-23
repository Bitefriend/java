package org.joonzis.vo;

import java.sql.Date;

public class StudentVO {
	private int s_idx, hit, student_num;
	private String sname, stitle, content, spw , filename;
	private Date join_date;
	public StudentVO() {}
	public StudentVO(int s_idx, int hit, int student_num, String sname, String stitle, String content, String spw,
			String filename, Date join_date) {
		super();
		this.s_idx = s_idx;
		this.hit = hit;
		this.student_num = student_num;
		this.sname = sname;
		this.stitle = stitle;
		this.content = content;
		this.spw = spw;
		this.filename = filename;
		this.join_date = join_date;
	}
	public int getS_idx() {
		return s_idx;
	}
	public void setS_idx(int s_idx) {
		this.s_idx = s_idx;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getStudent_num() {
		return student_num;
	}
	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSpw() {
		return spw;
	}
	public void setSpw(String spw) {
		this.spw = spw;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	
}
