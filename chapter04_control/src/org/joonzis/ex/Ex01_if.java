package org.joonzis.ex;

public class Ex01_if {
	public static void main(String[] args) {
		
		
		int num = 0;
		// num 변수의 값이 양수인지 음수인지 0인지 판단하여 출력
		if(num>0) {
			System.out.println("양수");
			
		} else if(num<0) {
			System.out.println("음수");
		} else {
			System.out.println("0");
		}
		
		
		double avg = 70.4; // 평균 점수
		// 평균점수가 90 이상이면 A,
		// 80이상이면 B
		// 70이상이면 c
		// 60이상이면 D
		// 60미만이면 F 출력
		
		if (avg>= 90.0){
			System.out.println("A");
			
		} else if(avg>=80.0) {
			System.out.println("B");
			
		} else if(avg>=70.0) {
			System.out.println("C");
			
		} else if (avg>=60.0) {
			System.out.println("D");
			
		} else {
			System.out.println("F");
		}
		
		
		
		
		
		
	}

}
