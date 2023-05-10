package org.joonzis.test;

import java.util.Scanner;

public class EX102_test {
	public static void main(String[] args) {
//		Test02.java
//		Q. 입력받은 구구단만 출력하기
//		ex) 4X1=4
//			4X2=8
//			4X3=12
//			4X4=16
//			...
		
		Scanner sc = new Scanner(System.in);
		System.out.println("구구단을 입력하시오");
		
		int gugu = sc.nextInt();
		
//		for (int i = 1; i < 10; i++) {
//			System.out.println(gugu + "x" + i + "=" + (gugu*i));
//			
//		}
		int num = 1;
	
		while (gugu<=9) {
			System.out.println(gugu + "x" + num + "=" + (gugu*num));
			num++;
		}
		sc.close();
	}

}
