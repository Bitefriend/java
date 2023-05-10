package org.joonzis.ex;

public class Ex01_ReatMain {
	public static void main(String[] args) {
		Ex01_Rect r1 = new Ex01_Rect();
		r1.output();
		System.out.println("------------------------------------------");
		
		Ex01_Rect r2 = new Ex01_Rect(5);
		r2.output();
		System.out.println("------------------------------------------");
		
		Ex01_Rect r3 = new Ex01_Rect(6, 7);
		r3.output();
	}

}
