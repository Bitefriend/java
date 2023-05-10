package org.joonzis.test;

public class Ex01_RectMethod {
	int width; // 너비
	int height; // 높이
	boolean isSquare; //정사각형 유무 -직사각형 : false, 정사각형 : true
	
	//메소드
	// 필드 초기화 메소드
	void setFields(int w, int h) {
		width =w;
		height =h;
		isSquare = (w==h) ? true : false;
	}
	void setFields(int side) {
		width = side;
		height = side;
		isSquare = true;
	}
	//2. 사각형 크기 계산 메소드
	int calcArea() {
		return width * height;
	}
	//3. 정보 출력 메소드
	void output() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + width);
		System.out.println(isSquare ? "정사각형" : "직사각형");
		System.out.println("크기 : " + calcArea() );
	}

}
