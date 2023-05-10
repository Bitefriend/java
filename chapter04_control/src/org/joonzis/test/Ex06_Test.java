package org.joonzis.test;

import java.util.Scanner;

public class Ex06_Test {
	public static void main(String[] args) {
//		Test08.java (switch문)
//		Q. 권한을 출력하기
//			3 수준 : 실행, 쓰기, 읽기 / 2수준 : 쓰기, 읽기 / 1수준 : 읽기
//			실행 예)
//			수준입력 >> 3
//			출력 : 실행, 쓰기, 읽기
		
		Scanner sc = new Scanner(System.in);
		System.out.println("수준을 입력하세요.");
		int num = sc.nextInt();	

		switch (num) {
		case 1 :
			System.out.println("읽기");
			
		case 2 :
			System.out.println("쓰기");	
			
		case 3 :
			System.out.println("실행");
			break;
		}
			sc.close();
//			switch (num) {
//			case 1 :
//				System.out.println("읽기");
//				
//				break;
//				
//			case 2 :
//				System.out.println("쓰기, 읽기");
//				
//				break;
//				
//			case 3 :
//				System.out.println("실행, 쓰기, 읽기");
//				
//				break;
	//
//			}

	}

}
