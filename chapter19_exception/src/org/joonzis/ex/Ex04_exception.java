package org.joonzis.ex;
/*
 * NullPointerException
 * 객체 참조가 없는 상태, 즉 null 값을 갖는 객체를 사용하는 경우 예외 발생
 */

public class Ex04_exception {
	public static void main(String[] args) {
		
		try {
			//String name = null; // 예외발생
			String name = "김씨";
			
			System.out.println("이름 : " + name.toString());
		} catch (Exception e) {
			System.out.println("예외발생");
			System.out.println(e.getMessage());
			System.out.println("--------");
			e.printStackTrace();
		}
	}

}
