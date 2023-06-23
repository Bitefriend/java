package org.joonzis.vo;

public class SVO {
	private int ss_idx, midx, sub1, sub2, sub3, sub4, avg;
	String subName;
	
	public SVO() {}

	public SVO(String subName, int ss_idx, int midx, int sub1, int sub2, int sub3, int sub4, int avg) {
		super();
		this.ss_idx = ss_idx;
		this.midx = midx;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.sub4 = sub4;
		this.avg = avg;
		this.subName = subName;
	}
	
	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getSs_idx() {
		return ss_idx;
	}

	public void setSs_idx(int ss_idx) {
		this.ss_idx = ss_idx;
	}

	public int getMidx() {
		return midx;
	}

	public void setMidx(int midx) {
		this.midx = midx;
	}

	public int getSub1() {
		return sub1;
	}

	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}

	public int getSub2() {
		return sub2;
	}

	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}

	public int getSub3() {
		return sub3;
	}

	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}

	public int getSub4() {
		return sub4;
	}

	public void setSub4(int sub4) {
		this.sub4 = sub4;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}
	
	
}
