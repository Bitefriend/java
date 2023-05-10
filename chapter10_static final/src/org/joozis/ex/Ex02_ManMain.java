package org.joozis.ex;

public class Ex02_ManMain {
	public static void main(String[] args) {
		Ex02_Man r = new Ex02_Man("김", 15);
		r.output();
		
		System.out.println("---------------------------------------------");
		
		System.out.println(r.name);
		System.out.println(r.age);
		System.out.println(r.GENDER); // 인스턴스를 통한 접근 -> 비추천
		System.out.println(Ex02_Man.GENDER); // 클래스를 통한 접근 -> 추천
	}


}
