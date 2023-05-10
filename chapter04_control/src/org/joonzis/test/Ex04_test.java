package org.joonzis.test;

import java.util.Scanner;

public class Ex04_test {
	public static void main(String[] args) {
//		Test05.java
//		Q. 문자를 하나 입력 받아 "대문자", "소문자", "아라비아 숫자", "일반 문자" 구분해서 출력하기
//		     아스키 코드표 참고
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자 하나를 입력하세요");
		char ch = sc. next().charAt(0);
		
		if (ch >= 'A' && ch <='Z') {  //문자로서 보이지만 비교가능
		
		System.out.println("대문자");
		}else if (ch >= '0' && ch <= '9') {
			System.out.println("아라비아 숫자");
			
		}else if (ch >= 'a' && ch <='z') {
		     System.out.println("소문자");
	    }else {
			System.out.println("일반 문자");
		}
		//if(on == ) {
			
			sc.close();
		//}
	}

}
