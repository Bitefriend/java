package org.joonzis.test;

import java.util.Scanner;

public class Ex02_test {
	public static void main(String[] args) {
//		Test02.java
//		Q. 필기와 실기 점수를 입력 받아 합격 유무 출력하기
//			합격기준: 필기와 실기 점수 모두 70점 이상이거나, 평균이 80 이상시 "합격" 아니면 "불합격"

//		double w = 70;
//		double s = 70;
//		double avg = 80;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("필기 점수를 입력하세요");
		double w = sc.nextDouble();
		
		System.out.println("실기 점수를 입력하세요");
		double s = sc.nextDouble();
		
		if(w>=70 & s>=70) {
			System.out.println("합격입니다.");
			
		}else if((w + s /2)>= 80) {
			System.out.println("합격");
			
		}else {
			System.out.println("불합격 입니다.");
			
		}
		
		
		sc.close();
	}

}
