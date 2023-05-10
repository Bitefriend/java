package org.joonzis.ex;
/*
 * 필드
 * - width, height
 * 
 * 메소드
 * - 생성자
 * 1. 기본 생성자 - 너비, 높이 1로 고정 값 대입
 * 2. 풀 생성자 - 넙, 높이 값 전달 받아 값 대입
 * - calcArea() : 계산 후 값 리턴
 * - output() : 너비, 높이, 크기 출력
 */
public class Ex00_Triangle {
	//필드
	int width, height;
	
	
	//메소드
     public Ex00_Triangle() {
		width = 1;
		height = 1;
	}
     public Ex00_Triangle(int w, int h) {
    	width = w;
    	height = h;
    	
    	 
     }
     double calcArea() {
    	 
    	 return width * height / 2.0;
     }
     void output() {
    	 System.out.println("너비 : " + width);
    	 System.out.println("높이 : " + height);
    	 System.out.println("크기 : " + calcArea());
     }
	
}
