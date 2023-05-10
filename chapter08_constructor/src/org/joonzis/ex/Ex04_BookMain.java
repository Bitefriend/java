package org.joonzis.ex;

public class Ex04_BookMain {
	public static void main(String[] args) {
		Ex04_Book r1 = new Ex04_Book();
		Ex04_Book r2 = new Ex04_Book("이름 없는 책", 100000);
		Ex04_Book r3 = new Ex04_Book("이름없는 책", 100000, "김아무개");
		
		r1.setSalesVoume(0);
		r2.setSalesVoume(100);
		r3.setSalesVoume(100000);
		
		r1.output();
		System.out.println("-------------------------------------------");
		r2.output();
		System.out.println("-------------------------------------------");
		r3.output();
		
	}

}
