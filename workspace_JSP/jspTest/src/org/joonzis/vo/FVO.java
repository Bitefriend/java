package org.joonzis.vo;

import java.sql.Date;

public class FVO {
		private int f_idx, midx, fhit;
		private String fnickname, fpw, fcontent, filefree;
		private Date fjoin_date;
		
		public FVO() {}

		public FVO(int f_idx, int midx, int fhit, String fnickname, String fpw, String fcontent, String filefree,
				Date fjoin_date) {
			super();
			this.f_idx = f_idx;
			this.midx = midx;
			this.fhit = fhit;
			this.fnickname = fnickname;
			this.fpw = fpw;
			this.fcontent = fcontent;
			this.filefree = filefree;
			this.fjoin_date = fjoin_date;
		}

		public int getF_idx() {
			return f_idx;
		}

		public void setF_idx(int f_idx) {
			this.f_idx = f_idx;
		}

		public int getMidx() {
			return midx;
		}

		public void setMidx(int midx) {
			this.midx = midx;
		}

		public int getFhit() {
			return fhit;
		}

		public void setFhit(int fhit) {
			this.fhit = fhit;
		}

		public String getFnickname() {
			return fnickname;
		}

		public void setFnickname(String fnickname) {
			this.fnickname = fnickname;
		}

		public String getFpw() {
			return fpw;
		}

		public void setFpw(String fpw) {
			this.fpw = fpw;
		}

		public String getFcontent() {
			return fcontent;
		}

		public void setFcontent(String fcontent) {
			this.fcontent = fcontent;
		}

		public String getFilefree() {
			return filefree;
		}

		public void setFilefree(String filefree) {
			this.filefree = filefree;
		}

		public Date getFjoin_date() {
			return fjoin_date;
		}

		public void setFjoin_date(Date fjoin_date) {
			this.fjoin_date = fjoin_date;
		}
		
		

}
