package org.joonzis.test;

import java.util.Scanner;

public class Ex06_test {
	public static void main(String[] args) {
		//Q. 섭씨 화씨 변환기
	    //  섭씨를 입력하면 변환된 화씨, 화씨를 입력하면 변환된 섭씨 출력하기
	    //★화씨 = 섭씨 * 1.8 +32
	   //  섭씨 = (화씨 -32) / 1.8
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("섭씨 입력 >>");
		double inputDate = sc.nextDouble();
		double outputDate = inputDate * 1.8 + 32;
		System.out.println("변화된 화씨 : " + outputDate);
		
		
		
		
		System.out.println("화씨 입력 >>");
		inputDate = sc.nextDouble();
		
				
		
		
		
		sc.close();
	}

}
