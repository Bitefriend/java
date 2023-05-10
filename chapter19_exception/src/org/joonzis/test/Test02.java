package org.joonzis.test;
//Q3. Test03.java	
//나이를 입력 받아 출력하시오. 
//나이가 0 ~ 150 사이의 범위를벗어나면 AgeException 클래스를 이용하여 예외를 처리하시오.
//나이를 입력 받기 위해 getAge() 메소드를 이용하시오.

import java.util.Scanner;

class AgeException extends Exception{
	public AgeException(String message) {
		super(message);
	}
}

public class Test02 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int getAge() throws AgeException{
		System.out.println("나이를 입력하세요. >>");
		int age=sc.nextInt();
		if(age<=0 || age>=150) {
			throw new AgeException("입력가능한 나이는 0~150");
		}
		return age;
		
	}
	public static void main(String[] args) {
	try {
		int age = getAge();
		System.out.println("나이는 : " + age + "살");
		
	} catch (AgeException e) {
		
		System.out.println(e.getMessage());

	}finally {
		if(sc != null) {
			sc.close();
		}
	}
	}
	

}
