package org.joonzis.test;

public class Ex01_Circle {
	
	double radius;
	final double PI = 3.14;
	String name;

	
	void info() {
		System.out.println("반지름" + radius);
		System.out.println("이름" + name);
		System.out.println("크기" + (PI * radius * radius));
		System.out.println("둘레" + (PI * 2 * radius));
		
		
	}
	
	

}
