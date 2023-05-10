package org.joonzis.test;

import java.util.Scanner;

public class Ex107_test {
	public static void main(String[] args) {
//		Test07.java
//		Q.두 정수를 입력 받아 두 정수 사이의 모든 정수의 합계 출력하기
//		    입력 순서와 무관하게 동일한 결과를 출력 
//		 	실행 예1)
//			첫 번째 정수 >> 1
//			두 번째 정수 >> 10
//			1부터 10까지 모든 정수의 합은 55입니다.
//			실행 예2)
//			첫 번째 정수 >> 10
//			두 번째 정수 >> 1
//			1부터 10까지 모든 정수의 합은 55입니다.
		
		// 값을 2개 입력 받고, 첫 번째 값이 두 번째 값보다 크면 둘이 교환
		//필요한 변수 : 변수 2개와 합계변수, 임시변수 총 4개
		Scanner sc = new Scanner(System.in);
		
		//1. 입력
		System.out.println("첫번째 정수 입력");
		int num = sc.nextInt(); // 시작값
		
		System.out.println("두번째 정수 입력");
		int num2 = sc.nextInt(); // 종료값
		
		int min = 0; // 값교환용
		int max = 0; // 값교환용
		int sum = 0; // 총합
		
		if(num > num2) {
			max = num;
			min = num2;
			
		}else {
			max = num2;
			min = num;
		}
			
		for (int i = min; i <=max; i++) {
			sum+=i;
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
