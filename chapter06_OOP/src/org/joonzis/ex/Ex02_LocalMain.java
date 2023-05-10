package org.joonzis.ex;

public class Ex02_LocalMain {
	public static void main(String[] args) {
		Ex02_Local r1 =new Ex02_Local();
		r1.setLocalInfo(20, "999999-1999999" , "이름");
		r1.output();
		
		System.out.println("----------------------------------------------");
		
		Ex02_Local r2 =new Ex02_Local();
		r2.setLocalInfo(23, "이씨");
		r2.output();
	}

}
