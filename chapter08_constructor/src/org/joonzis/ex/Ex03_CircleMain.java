package org.joonzis.ex;

public class Ex03_CircleMain {
	public static void main(String[] args) {
		Ex03_Circle r1 = new Ex03_Circle();
		r1.output();
		System.out.println("-----------------------------------------");
		
		Ex03_Circle r2 = new Ex03_Circle(1.5);
		r2.output();
		System.out.println("-----------------------------------------");
		
		Ex03_Circle r3 = new Ex03_Circle(3, 3, 2.5);
		r3.output();
		System.out.println("-----------------------------------------");
	}

}
