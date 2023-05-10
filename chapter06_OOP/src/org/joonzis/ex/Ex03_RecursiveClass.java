package org.joonzis.ex;

public class Ex03_RecursiveClass {
	
	static int count = 0;
	
	static void recursive() {
		System.out.println("recursive() call");
		count++;
		if(count ==5) {
			return;  // recursive() 메소드 종료
		}
		recursive(); //재귀 호출
	}
	
	public static void main(String[] args) {
		recursive();
	}

}
