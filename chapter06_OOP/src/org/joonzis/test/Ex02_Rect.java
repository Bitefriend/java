package org.joonzis.test;

import java.util.Scanner;

public class Ex02_Rect {
	//필드
	int width;
	int height;
	void init() {
		Scanner sc = new Scanner(System.in);
		System.out.println("너비 입력 >> ");
		width = sc.nextInt();
		System.out.println("높이 입력 >>");
		height = sc.nextInt();
	}
	void info() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		calcArea();
	}
	void calcArea() {
		System.out.println("크기 : " + (width * height));
	}

}
