package org.joonzis.test;

public class Ex01_Main {
	public static void main(String[] args) {
		
		//1. 객체 생성
		Ex01_RectMethod r1 = new Ex01_RectMethod ();//생성자
		r1.setFields(10, 20);
		r1.output();
		
		System.out.println("--------------------------------------------");
		
		Ex01_RectMethod r2 = new Ex01_RectMethod ();
		r2.setFields(15); // 메소드 오버로딩
		r2.output();
		
	}

}
