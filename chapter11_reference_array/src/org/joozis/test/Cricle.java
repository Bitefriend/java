package org.joozis.test;

public class Cricle {
	double radius;
	
	public Cricle() {}
	
	public Cricle(double radius) {
		this.radius = radius;
	}
	double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	void output() {
		System.out.println("반지름 : " + radius);
		System.out.println("크기 : " + calcArea());
	}
	

}
