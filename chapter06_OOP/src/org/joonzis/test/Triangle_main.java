package org.joonzis.test;

import java.util.Scanner;

class Triangle{
	int width;
	int height;
	
	void init(Scanner sc) {
		
		System.out.println("너비 입력 >> ");
		width = sc.nextInt();
		System.out.println("높이 입력 >>");
		height = sc.nextInt();
	}
	void info() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("크기 : " + calcArea());
		
	}
	double calcArea() {
		return width * height / 2.0;
		
	}

}


	


public class Triangle_main {
	public static void main(String[] args) {
		Triangle r1 =new Triangle();
		Scanner sc = new Scanner(System.in);
		
		r1.init(sc);
		r1.info();
		sc.close();
	}

}
