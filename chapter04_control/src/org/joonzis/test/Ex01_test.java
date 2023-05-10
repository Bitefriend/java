package org.joonzis.test;

import java.util.Scanner;

public class Ex01_test {
	public static void main(String[] args) {
//		Test01.java
//		Q. 정수를 입력 받아 "짝수", "홀수" 구분해서 출력하기
//		   3의 배수는 "3의 배수"로 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요");
		int num = sc.nextInt();
		
		// 1. 방법 1- 그룹 
		
		
		if(num % 3 == 0) {
			System.out.println("3의 배수");
			
		} else if(num % 1 == 0) {
			System.out.println("홀수");
			
		} else{
			System.out.println("짝수");
			
		}
		
		//2. 방법 2 - 짝 or 홀 + 3의 배수
		
		 if(num % 1 == 0) {
				System.out.println("홀수");
				
			} else {
				System.out.println("짝수");
			} 
		 if(num % 3 == 0) {
				System.out.println("3의 배수");
		 }
				
				sc.close();
	}

}
