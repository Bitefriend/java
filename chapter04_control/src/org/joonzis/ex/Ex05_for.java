package org.joonzis.ex;

public class Ex05_for {
	public static void main(String[] args) {
		//0~9까지 화면에 출력
		for(int i=0;i<10;i++) {
			System.out.println(i);
			
			
		}
		
		
		//i가 소멸되는 지점 (for문을 벗어나면 i 는 사용 불가)
		// System.out.ptinl
			
		
	
	// for 문 마다 동일한 변수를 선언해도 ㅂ\ㅜ
	for(int i=0;i<10;i++) {
		System.out.println(i);
	
		
		
	}
	for(int i=0;i<5;i++) {
		for(int j=0;j<5;j++) {
			System.out.print("*");
		}
		System.out.println();
	}

	}
	
	
}
