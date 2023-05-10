package org.joonzis.ex;
/*
 *  - int width, height
 *  - boolean isSquare
 *  
 *  메소드
 *  - 생성자()  : 값 1고정
 *  - 생성자 (side)
 *  - 생성자(w,h)
 *  - calcArea() : 크기 계산 후 리턴
 *  - output() : 너비, 높이, 크기, 형태(정사각형 or 직사각형) 출력
 */


public class Ex01_Rect {
	//필드
	int width, height;
	boolean isSquare;
	//메소드
	 public Ex01_Rect() {
		 width = 1;
		 height = 1;
		 isSquare = true;
	}
	 public Ex01_Rect(int side) {
		width = side;
		height = side;
		isSquare = true;
	 }
	 public Ex01_Rect(int w, int h) {
		 width = w;
		 height = h;
		 isSquare =(w == h) ? true : false;
	 }
	 double calcArea() {
		 return width * height / 2.0;
	 }
	 
	 void output() {
		 System.out.println("너비 : " + width);
		 System.out.println("높이 : " + height);
		 System.out.println("크기 : " + calcArea());
		 System.out.println("형태 : " + (isSquare ? "정사각형" : "직사각형"));
		 
	 }

}
