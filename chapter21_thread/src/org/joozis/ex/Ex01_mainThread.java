package org.joozis.ex;

public class Ex01_mainThread {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			try {
				//0,5초간 일시 정지
				Thread.sleep(500); // 필수로 예외처리 해야함
				System.out.println("Main Thread " + (i+1) + " 번째 출력");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
