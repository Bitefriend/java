package org.joonzis.test;

import java.util.Scanner;

public class Ex05_test {
	public static void main(String[] args) {
		//Q. 하이픈 없이 주민등록번호를 입력받아 (정수, 문자열) "남자","여자" 출력하기
		//* String의 메소드 이용하기
		//* ex) charAt(), substring() 등
		
		Scanner sc = new Scanner(System.in);
		
	
		long sn1 = 9999991111111L;
		System.out.println(sn1 / 1000000);
		System.out.println(sn1 / 1000000 % 10);
		
		//1. 문자열 자르기
		// String gender = (sn1.charAt(6) =='2'||charSn=='4')? "여자" : "남자";
		// 문자열은 equals로 비교하기 !!
		//String gender = sn1.substring(6,7).equals("2") ? "여자" : "남자";
		//substring은 (6,7)괄호의 마지막 숫자 전까지 표시해줌
		
		
		
		
		//System.out.println("성별 : " + gender);
		
		
		
			
		
	}

}
