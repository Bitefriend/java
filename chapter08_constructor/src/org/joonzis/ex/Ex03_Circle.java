package org.joonzis.ex;

/*
 * 필드
 *  - int x, y : 좌표
 *  - double radius : 반지름
 *  
 *  메소드 
 *  - 생성자() : 좌표0,0 r값 1로 고정
 *  - 생성자 (r) : 좌표 0,0
 *  풀 생성자
 *  calcArea() : 원의 크기 계산 후 리턴 (PI *r * r)
 *  calcCircum() : 원의 둘레 계산 후 리턴 (2 * PI * r)
 *  output() : 원의 중심 좌표, 반지름, 크기, 둘레 출력
 *  
 *  *************PI 구하기 >> Math.PI********************
 */

public class Ex03_Circle {
//	Math.PI >> 파이 값 (3.14) 계산 값에 넣으면 됌
	 int x, y;
	 double radius;
	
	public Ex03_Circle() {
		x = 0; 
		y = 0;
		radius = 1;
	}
	public Ex03_Circle(double r) {
		x = 0; 
		y = 0;
		radius = r;
	}
	public Ex03_Circle(int a, int b, double r) {
		x = a;
		y = b;
		radius = r;
	}
	double calcArea() {
		return Math.PI * radius * radius;
	}
	double calcCircum() {
		return 2*Math.PI * radius;
	}
	void output() {
		System.out.println("원의 중심좌표는 : " + x + "," + y);
		System.out.println("반지름 : " + radius);
		System.out.println("크기 : " + calcArea());
		System.out.println("둘레 : " + calcCircum());
	}

}
