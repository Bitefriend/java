package org.joozis.ex;

interface Shape{
	double PI = Math.PI;
	double calcArea();
	void output();
}
class Rect implements Shape{
	private int a;
	private int b;
	public Rect() {}

	public Rect(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public double calcArea() {
		return a*b;
	}
	@Override
	public void output() {
		System.out.println("너비 : " + a);
		System.out.println("높이 : " + b);
		System.out.println("크기 : " + calcArea());
	}
}
class Circle implements Shape{
	private int r;
	
	public Circle() {}
	
	public Circle(int r) {
		super();
		this.r = r;
	}
	
	@Override
	public double calcArea() {
		
		return PI*r*r;
	}

	@Override
	public void output() {
		System.out.println("반지름 : " + r);
		System.out.println("넓이 : " + calcArea());
	}
}

public class Ex02_interface {
	public static void main(String[] args) {
		// 도형 객체를 생성하여 사각형의 원형 객체를 저장.
		// 각 도형의 정보 출력
		// 1. 사각형 : 너비, 높이, 크기 (너비*높이)
		// 2. 원형 : 반지름, 넓이(PI*radius*radius)
		Shape[] s = new Shape[2];
		
		s[0] = new Rect(2, 3);
		s[1] = new Circle(5);
		
		s[0].output();
		System.out.println("--------------------");
		s[1].output();
		
	
	}

}
