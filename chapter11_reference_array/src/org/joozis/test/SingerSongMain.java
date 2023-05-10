package org.joozis.test;

public class SingerSongMain {
	public static void main(String[] args) {
		
		// 1. 싱어 객체 생성 -> 가수 이름, 배열 크기 전달
		// 2. song 객체 생성 -> 객체에 전달
		// 3. Singer 객체를 이용하여 정보 출력
		
		Singer r = new Singer("아무개", 2);
		//1.
		Song r1 = new Song("After like", "대한민국");
		r.setSong(r1);
		
		//2.
		r.setSong(new Song("After like", "대한민국"));
		
		r.output();
		
		
	}

}
