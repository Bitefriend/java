package org.joozis.ex;
class Shape{
	//의미 없는 메소드(자식들이 사용하기 위해 만들어놓음)
	public double calcArea() {
		return 0;
	}
}
class Rect extends Shape{
	private int widht, height;
	public Rect() {}
	public Rect(int widht, int height) {
		this.widht = widht;
		this.height = height;
	}
	@Override
	public double calcArea() {
		return widht * height;
	}
}
class Triangle extends Shape{
	private int widht, height;
	public Triangle() {}
	public Triangle(int widht, int height) {
		this.widht = widht;
		this.height = height;
	}
	@Override
	public double calcArea() {
		return widht * height / 2.0;
	}
}
class Circle extends Shape{
	private double radius;
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}
public class Ex02_polymorphism {
	public static void main(String[] args) {
		// 길이 3짜리 부모 배열을 선언하여
		// 각각 인덱스에 사각형, 삼각형, 원형 클래스 객체 대입
		// 각 객체별 크기 출력
		
		Shape[] shape = new Shape[3];
		
		shape[0] = new Rect(3,5);
		shape[1] = new Triangle(5,5);
		shape[2] = new Circle(8);
		
		shape[0].calcArea();
		shape[1].calcArea();
		shape[2].calcArea();
		
		System.out.println("크기 1 : " + shape[0].calcArea());
		System.out.println("크기 2 : " + shape[1].calcArea());
		System.out.println("크기 3 : " + shape[2].calcArea());
		
		System.out.println("---------------------------------");
		
		for (int i = 0; i < shape.length; i++) {
			System.out.println(shape[i].calcArea());
		}
		
		

	}
	

}
