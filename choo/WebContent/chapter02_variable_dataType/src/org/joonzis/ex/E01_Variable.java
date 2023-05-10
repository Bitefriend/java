package org.joonzis.ex;

public class E01_Variable { 
	public static void main(String[] args) {
		
		//1. 변수 선언(선언과 초기화 동시 진행)
		int num = 0;
		float num2 = 0f;
		double num3 = 30;
		char ch = 0;
		char ch2 = 'a';
		int ch3 = 'a';
		
		// 참조타입
				String str1 = null; // null : 0번지 (주소의 초기화를 0으로 하겠다)
				String str2 = ""; // " : 빈 문자열
		
				//2.  다른 값 대입
		num = 100;
		num2 = 1.5f;
		num3 = 1.5;
		ch = '한';
		str1 = "Hello";
		str2 = "java";
		
		System.out.println(num);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(ch);
		System.out.println(ch2);
		System.out.println(ch3);
		/*
		 * 1.
		 * 변수 num2에 데이터 1.5 저장
		 * 변수 num3에 데이터 1.5 저장
		 * 변수 ch 에 데이터 한 저장
		 * 변수 str1에 데이터 hello 저장
		 * 변수 str2에 데이터 java 저장
		 * 2. 1에서 저장된 변수 들 출력
		 */
		
		// 3. 스코프(범위)
		//1) 지역 변수 : 코드블록{} 내에서만 접근 가능, 벗어나면 소멸 
		//2) 전역 변수 : 모든 지역에서 사용 가능
		
		{
			int a = 10;
			System.out.println("코드 블록 내의 a = " + a);
		}
		
		System.out.println("코드 블록 밖의 a = " + a);
	
		
		
		
	
		
		
		
	}

}
