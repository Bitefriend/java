package org.joonzis.test;

import java.util.Random;
import java.util.Scanner;



//Test02.java		
//사용자로부터 10이상의 정수를 입력 받아 난수 (0 ~ 9)로 나눈결과를 출력하시오.
//위과정을 100번 반복하여 출력하며, 나눌 수없는 경우에는 나눈 결과를 0으로 대신출력한다.


public class Test01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random num1 = new Random();
		
		for (int i = 0; i <100; i++) {
			System.out.println("10이상의 정수입력");
			int num = sc.nextInt();
			int num2 = num1.nextInt(10);
			
			if(num < 10) {
				// 입력 값이 10보다 작을 때
				i--;
				continue;
			}else {
				try {
				System.out.println((i+1) + "번째 나누기 결과 : " + (num / num2));
				
			} catch (ArithmeticException e) {
				System.out.println((i+1) + 
				"번째 나누기 결과 " + 0);
			}
			
			}
		}
	
	}

}
