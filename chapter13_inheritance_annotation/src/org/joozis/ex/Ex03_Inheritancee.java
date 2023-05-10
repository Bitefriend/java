package org.joozis.ex;

class Car{
	void move() {
		System.out.println("움직인다");
		
		}
	}
	

class Ev extends Car{
	void charging() {
		System.out.println("전기를 충전한다.");
}
}

public class Ex03_Inheritancee {
	public static void main(String[] args) {
		Ev ev = new Ev();
		
		ev.charging();
		ev.move();
		
	}


}
