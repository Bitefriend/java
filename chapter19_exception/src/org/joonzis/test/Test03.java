package org.joonzis.test;
//Q4. Test04.java									   
//주민등록 번호 (하이픈 포함)를 입력 받아 출력하시오.
//주민등록번호가 14글자가 아니면 PerIDException 클래스를 이용하여 예외를 처리하시오.
//주민등록번호를 입력받기 위해 String getPerID() 메소드를 이용하시오.

import java.util.Scanner;

class PerIDException extends Exception{
	public PerIDException(String msg) {
		super(msg);
	}
}
public class Test03 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static String getPerID() throws PerIDException {
		System.out.println("주민번호를 -포함 입력");
		String num = sc.next();
		
		if(num.length() != 14) {
			throw new PerIDException("똑바로 입력하세요");
		}
		return num;
	}
	
	public static void main(String[] args) {
		try {
			String num = getPerID();
			System.out.println("입력한 주민번호 : " + num);
			
		} catch (PerIDException e) {
			System.out.println(e.getMessage());
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
		
	}

}
