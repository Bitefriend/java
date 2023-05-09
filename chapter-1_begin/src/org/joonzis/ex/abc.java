package org.joonzis.ex;

public class abc {
	public static void main(String[] args) {
		System.out.println("hello");
		
		// 이미 블록 범위 안에 있는 변수가 소멸 되었기 때문에 접근 불가
		//  System.out.println("코드 블록 밖의 a = " + a);
	}
}
