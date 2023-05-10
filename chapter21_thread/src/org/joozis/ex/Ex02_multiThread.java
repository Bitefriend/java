package org.joozis.ex;


class MyThread extends Thread{
	/*
	 * 1. 스레드 클래스를 상속받아 정의
	 * run() 메소드를 재정의 하여 스레드가 실행할 코드를 작성한다.
	 */
	
	private String str;
	public MyThread(String str) {
		this.str = str;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				//0,5초간 일시 정지
				Thread.sleep(500); // 필수로 예외처리 해야함
				System.out.println("Main Thread " + (i+1) + " 번째 출력");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Other Thread End");
	}
	
}
public class Ex02_multiThread {
	public static void main(String[] args) {
		/*
		 *  run()을 호출하면 단순히 클래스에 속한 메소드를 호출하는 것 뿐.
		 *  start()는 스레드 작업을 실행하는 데에 필요한 호출 스택을 생성한 다음 run()을 호출
		 */
		System.out.println("Main Thread Start");
		
		MyThread mt1 = new MyThread("*");
		MyThread mt2 = new MyThread("-");
		
		mt1.start();
		mt2.start();

		
		System.out.println("Main Thread End");
		
	}

}
