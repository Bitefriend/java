package org.joonzis.test;

public class Ex04_CoordinateMain {
	public static void main(String[] args) {
		
		Ex04_Coordinate coo = new Ex04_Coordinate(0,0);
		Ex04_Circle cir1 = new Ex04_Circle(coo, 10);
		Ex04_Circle cir2 = new Ex04_Circle(coo, 12);
		Ex04_Ring ring = new Ex04_Ring(cir1, cir2);
		ring.output();
	}

}
