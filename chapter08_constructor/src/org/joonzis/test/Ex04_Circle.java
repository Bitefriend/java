package org.joonzis.test;

public class Ex04_Circle {
	
	Ex04_Coordinate center;
	double radius;
	
	public Ex04_Circle() {}
	public Ex04_Circle(Ex04_Coordinate c, double r) {
		center = c;
		radius = r;
	}
	
	void output() {
		System.out.println("반지름 : " + radius);
		center.output();
	}

}
