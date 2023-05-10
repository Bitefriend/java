package org.joonzis.test;

import java.util.Scanner;

public class Ex106_test {
	public static void main(String[] args) {
//		Test06.java
//		Q. 1부터 입력 받은 양수 사이의 모든 정수의 합계 출력하기
//		      입력 받은 수가 2이상이 아니면 다시 입력 받도록 처리
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0;      // 2이상의 값을 입력 하는 변수
		int sum = 0;      // 합계 변수
		
		while (true) {
			System.out.println("2이상의 양수 입력");
			num = sc.nextInt();
			//int sum = 0;
			
			if(num>=2) {
				break;
//				sum+=num;
//				System.out.println(num);
//				num++;
				
			}
			
			for (int i = 1; i <=num; i++) {
				sum+= i;
			}
			System.out.println("1부터 " + num + "까지의 합은 : " + sum);
		}
	
		
		sc.close();
	}

}
