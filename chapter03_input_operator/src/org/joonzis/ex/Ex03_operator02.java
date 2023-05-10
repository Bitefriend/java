package org.joonzis.ex;

public class Ex03_operator02 {
	public static void main(String[] args) {
	
		
		
		//시프트
		int num = 8;
		System.out.println("왼쪽 시프트 : " + (num<<2));
		System.out.println("오른쪽 시프트 : " + (num>>1));
		
		//증감
		int num2 = 10;
		System.out.println(num2); // 변수 원본 출력
		System.out.println(num2++); // 출력 후 1증가
		System.out.println(++num2);// 1증가 후 출력
		
		
		
		
		
	}

}
