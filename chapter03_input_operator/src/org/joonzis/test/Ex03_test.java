package org.joonzis.test;

import java.util.Scanner;

//Test03.java
//Q. 매출액과 등급("VIP", "일반")을 입력받아 등급이 "VIP"이면 매출액에서 20%를 할인하고
//"일반"이면 매출액에서 5%를 할인하는 프로그램 구현 
public class Ex03_test {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("매출액 입력 >>");
		int money = sc.nextInt();
		sc.nextLine(); // nextInt()의 개행 삭제 용도
		System.out.println("등급 입력 >>");
		String grade = sc.nextLine();
		
		
		int result = (int)(grade.equalsIgnoreCase("VIP") ? money * 0.8 : money * 0.95);
		//equalsIgnoreCase 대소문자 구분안함

		
		
		System.out.println("할인 : " + result );
		
		sc.close();
		
		
		
		
	}

}
