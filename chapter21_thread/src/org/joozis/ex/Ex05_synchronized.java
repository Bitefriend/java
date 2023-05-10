package org.joozis.ex;
class AnimalSound{
	/*
	 * 1. synchronized(동기화)
	 *     1) 메소드에 붙여서 사용
	 *         (1) 여러개의 Thread들이 공유 객체의 메소드를 사용할 때
	 *             메소드에 synchronized가 붙어 있을 경우 먼저 호출한 메소드가 객체의
	 *             사용권(Monitoring Lock)을 얻는다.
	 *             락은 메소드가 종료되거나, wait()같은 메소드를 만나기 전까지 유지된다.
	 *         (2) 메소드가 길어지게 될 경우 대기 시간이 증가할 수 있다.
	 *     2) synchronized 블럭 사용
	 */
	public void dog() {
		for (int i = 0; i < 5; i++) {
			System.out.println("멍-멍");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void cat() {
		for (int i = 0; i < 5; i++) {
			System.out.println("냐옹");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void bird() {
		synchronized(this) {
		for (int i = 0; i < 5; i++) {
			System.out.println("쫵쫵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Animal implements Runnable{
	private int type;
	private AnimalSound sound;
	public Animal(int type, AnimalSound sound) {
		super();
		this.type = type;
		this.sound = sound;
	}
	@Override
	public void run() {
		switch(type) {
		case 1: sound.dog();
		break;
		case 2: sound.cat();
		break;
		case 3: sound.bird();
			break;
		}
	}
}
public static class Ex05_synchronized {
	public static void main(String[] args) {
		AnimalSound sound = new AnimalSound();
		
		Thread t1 = new Thread (new Animal(1, sound));
		Thread t2 = new Thread (new Animal(2, sound));
		Thread t3 = new Thread (new Animal(3, sound));
		
		t1.start();
		t2.start();
		t3.start();
	}
}
}
