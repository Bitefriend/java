package org.joonzis.test;

public class Ex105_test {
	public static void main(String[] args) {
//		Test05.java
//		Q. 1 ~ 100 사이의 모든 정수 합계 출력하기
//		int sum = 0;
//	
//
//		for (int i = 1; i < 101 ; i++) {
//			
//			sum += i;
//			
//		}
//		System.out.println(sum);
//		//-----------------------------------------------------------
//		
//		int start = 1;
//		int end = 100;
//		int num = 0;
//		for (num = start; num <= end; num++) {
//			
//		}
//		System.out.println(num);
		//-------------------------
		//1부터 100사이의 모든 정수 중 "짝수"의 합과 "홀수"의 합을 각각 구하여 출력하시오.
		int sumOdd = 0; //홀수 합   변수
		int sumEven = 0; // 짝수 합 변수
		
		
		for (int i = 1; i <100; i++) {
			if(i%2==0) {
				//짝수 
				sumEven +=i;
			}else {
			   //짝수
				sumOdd +=i;
			}
			System.out.println("짝수의 합 : " + sumEven);
			System.out.println("홀수의 합 : " + sumOdd);
			
		}
		
	}

}
