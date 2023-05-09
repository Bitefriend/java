package org.joonzis.ex;

public class Ex06_casting { 
	public static void main(String[] args) {
		//1. 자동 형 변환
		System.out.println(1 + 1.5);
		//java 스스로 1.0 + 1.5로 변환 후 연산
		
		double a = 10;
		System.out.println(a);
		// java 스스로 double a = 10.0 으로 변환 후 처리
		
		//2. 강제로 형 변환
		int b = (int)20.9;
		System.out.println(b);
		
		int c = 1;
		int d = 2;
		double e = (double)c/d; // -> int 계산 후 double에서 0.0 삽입되어 결과 값 0.0  
		                        // -> 강제 형 변환(c) + 자동 형 변환(b)
		System.out.println((double)c/d); 
		
		int kor = 7;
		int mat = 4;
		int eng = 9;
		
	}

}
