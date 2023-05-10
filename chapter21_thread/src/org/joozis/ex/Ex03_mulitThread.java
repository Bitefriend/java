package org.joozis.ex;
		
		
class MyThread2 implements Runnable{
	private String str;
	public MyThread2(String str) {
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
public class Ex03_mulitThread {
	public static void main(String[] args) {
System.out.println("Main Thread Start");
		
		MyThread2 mt1 = new MyThread2("*");
		MyThread2 mt2 = new MyThread2("-");
		
		//start() 메소드를 사용하기 위해 Thread 클래스 객체를 생성한다.
		
		Thread t1 = new Thread(mt1);
		Thread t2 = new Thread(mt2);

		t1.start();
		t2.start();
		
		System.out.println("Main Thread End");
	}

}
