package org.joonzis.vo;

import java.sql.Date;

public class VVO {
	private int v_idx, hit;
	private String vtitle1, content1, vtitle2, content2, vtitle3, content3, tip, filefree;
	private Date vreg_date;
	
	public VVO() {}

	public VVO(int hit, int v_idx,String filefree, String vtitle1, String content1, String vtitle2, String content2, String vtitle3,
			String content3, String tip, Date vreg_date) {
		super();
		this.v_idx = v_idx;
		this.vtitle1 = vtitle1;
		this.content1 = content1;
		this.vtitle2 = vtitle2;
		this.content2 = content2;
		this.vtitle3 = vtitle3;
		this.content3 = content3;
		this.tip = tip;
		this.vreg_date = vreg_date;
		this.hit = hit;
		this.filefree = filefree;
	}
	
	
	public String getFilefree() {
		return filefree;
	}

	public void setFilefree(String filefree) {
		this.filefree = filefree;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getV_idx() {
		return v_idx;
	}

	public void setV_idx(int v_idx) {
		this.v_idx = v_idx;
	}

	public String getVtitle1() {
		return vtitle1;
	}

	public void setVtitle1(String vtitle1) {
		this.vtitle1 = vtitle1;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getVtitle2() {
		return vtitle2;
	}

	public void setVtitle2(String vtitle2) {
		this.vtitle2 = vtitle2;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getVtitle3() {
		return vtitle3;
	}

	public void setVtitle3(String vtitle3) {
		this.vtitle3 = vtitle3;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Date getVreg_date() {
		return vreg_date;
	}

	public void setVreg_date(Date vreg_date) {
		this.vreg_date = vreg_date;
	}
	
	
}
