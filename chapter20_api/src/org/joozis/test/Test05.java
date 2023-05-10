package org.joozis.test;
//Q5.Test05.java
//성(lastName), 이름(firstName)을 각각 입력 받아
//하나의 이름(fullName)을 완성하시오. StringBuffer 클래스를 이용하시오.
//위의 방식으로 두 이름을 입력 받아 두 이름(fullName)의 동등 비교를 진행하시오.

import java.util.Scanner;

public class Test05 {
	
	public static void main(String[] args) {
		
		String name;
		String name2;
		
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하시오>>");
		name = sc.next();
		System.out.println("성을 입력하시오 >>");
		name2 = sc.next();
		
		sb.append(name);
		sb.append(name2);
		System.out.println(sb.toString());
		
		String na;
		String na2;
	
		
		System.out.println("이름 또 입력하시오");
		na = sc.next();
		System.out.println("성 또 입력하시오");
		na2 = sc.next();
		
		sb2.append(na);
		sb2.append(na2);
		System.out.println(sb2.toString());
		
		
		if(sb == sb2) {
			System.out.println("같당");
		}else {
			System.out.println("다르당");
		}
		System.out.println("---------------------");
		if(sb.toString().equals(sb2.toString())) {
			System.out.println("같당");
		}else {
			System.out.println("다르당");
		}
		sc.close();
	}

}
