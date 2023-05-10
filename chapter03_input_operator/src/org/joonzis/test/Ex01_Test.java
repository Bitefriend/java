package org.joonzis.test;
// Q. 두 정수를 입력받아 a, b에 저장한 뒤 두 변수의 값을 교환하는 프로그램 구현
// * 임시 변수 필요
public class Ex01_Test {
	public static void main(String[] args) {
		int a = 15;
		int b = 19;
		
		
		int tmp = a; // 임시변수
		//tmp == 7
		
		a = b;
		// a == 11
		b = tmp;
		// b ==7
		System.out.println("a : " + a + ", b : " + b);
		
		
		
		
	}

}
