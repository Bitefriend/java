package org.joonzis.ex;

/*
 * 필드
 *  - width, height, isSquare
 *  
 *  메소드
 *   - 생성자 ()        : 가로 세로 1 고정
 *   - 생성자(int side) : 가로 세로 같은 값으로 저장
 *   - 생성자(w, h)     : 가로, 세로 값 전달 받아 저장
 *   - int calcArea() : 사각형 크기 리턴
 *   - output()       : 너비, 높이, 크기, 형태 (정사각형 or 직사각형 출력)
 */

public class Ex01_Rect {
	private int widht ;
	private int height;
	private boolean isSquare;
	
	public Ex01_Rect() {
		widht = 1;
		height = 1;
	}
	public Ex01_Rect(int side) {
		widht = side;
		height = side;
	}
	public Ex01_Rect( int w, int h) {
		widht = w;
		height = h;
		isSquare = widht == height ? true : false;
	}
	private int calcArea() {
		
		return widht * height ;
	}
	public void output() {
		System.out.println("너비 : " + widht);
		System.out.println("높이 : " + height);
		System.out.println("크기 : " + calcArea());
		System.out.println("형태 : " + (isSquare ? "정사각형" : "직사각형"));
		
	}


}
