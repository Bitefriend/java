package org.joonzis.test;

public class CarMain {
	public static void main(String[] args) {
		Ex001_Test r1 = new Ex001_Test();
		r1.setFields("페라리", "Black");
		r1.output();
		
		System.out.println("----------------------------------------");
		
		Ex001_Test r2 = new Ex001_Test();
		r2.setFields("페라리", "Purple", 2022 );
		r2.output();
	}

}
