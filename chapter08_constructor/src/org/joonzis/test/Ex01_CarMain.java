package org.joonzis.test;

public class Ex01_CarMain {
	public static void main(String[] args) {
		
		Ex01_Car r = new Ex01_Car();
		Ex01_Car r1 = new Ex01_Car("포르쉐", "빨강");
		Ex01_Car r2 = new Ex01_Car("람보르", "빨강", 2022);
		
		r.output();
		System.out.println("---------------------------------------------");
		r1.output();
		System.out.println("---------------------------------------------");
		r2.output();
	}

}
