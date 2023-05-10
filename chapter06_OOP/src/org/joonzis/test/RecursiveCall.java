package org.joonzis.test;

public class RecursiveCall {
//	Q3.
//	클래스 RecursiveCall 을 정의하시오.
//	- 필드  : X
//	- 메소드 : recursive(n) -> n번 "Hello" 출력하기
//			 main
//	★
//	if-else 사용 - else 일 때 재귀 호출
	
	static int count = 0;
	
	static void recursive() {
		if (count == 5) {
			return;
			
		}
		System.out.println("Hello");
		
		recursive(count -1);
	}
	
	public static void main(String[] args) {
		recursive(5);
	}
}
