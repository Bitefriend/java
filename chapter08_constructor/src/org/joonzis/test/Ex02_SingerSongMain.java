package org.joonzis.test;

public class Ex02_SingerSongMain {
	public static void main(String[] args) {
		Ex02_Song r1 = new Ex02_Song("타이틀","나라");
		
		Ex02_singer r2 = new Ex02_singer("가수");
		r2.setSong(r1);
		r2.output();


	}

}
