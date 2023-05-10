package org.joonzis.test;

import java.util.Scanner;

public class Ex07_test {
	public static void main(String[] args) {
//		Test09.java (switch문)
//		Q. 월을 입력 받아 일을 출력하기
//			실행 예)
//			월 입력 >> 10
//			출력 : 10월은 31일 까지 있습니다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요.");
		int num = sc.nextInt();
		
		switch (num) {
		case 1:
			System.out.println("1월은 31일까지 있습니다.");
			break;
        case 2:
        	System.out.println("2월은 28일까지 있습니다.");
			break;
        case 3:
        	System.out.println("3월은 31일까지 있습니다.");
			break;
        case 4:
        	System.out.println("4월은 30일까지 있습니다.");
        	break;
        case 5:
        	System.out.println("5월은 31일까지 있습니다.");
        	break;
        case 6:
        	System.out.println("6월은 30일까지 있습니다.");
        	break;
        case 7:
        	System.out.println("7월은 31일까지 있습니다.");
        	break;
        case 8:
        	System.out.println("8월은 31일까지 있습니다.");
        	break;
        case 9:
        	System.out.println("9월은 30일까지 있습니다.");
        	break;
        case 10:
        	System.out.println("10월은 31일까지 있습니다.");
        	break;
        case 11:
        	System.out.println("11월은 30일까지 있습니다.");
        	break;
        case 12:
        	System.out.println("12월은 31일까지 있습니다.");
        	break;
        	
        	
		}
		sc.close();
	}

}
