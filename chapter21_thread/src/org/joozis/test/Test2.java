package org.joozis.test;
//Q2. Test02.java
//멀티 스레드를 이용하여 구구단을 출력(동기화 X)
//class GugudanPlay	메소드 : play(int dan)
//class Gugudan		필드 : int dan, GugudanPlay gugudan
//					메소드 : 생성자 , run()
//class Main
// - 참조 배열 이용

class GugudanPlay{
	public synchronized void play(int dan) {
		for (int i = 1; i<=9; i++) {
			System.out.println(dan +  "x" +  i + "=" + dan*i);
		}
	}
	
}
class  Gugudan extends Thread{
	private int dan;
	private GugudanPlay gugudan;
	
	public Gugudan(int dan, GugudanPlay gugudan) {
		this.dan = dan;
		this.gugudan = gugudan;
	}
	@Override
	public void run() {
		gugudan.play(dan);			
		}
}
public class Test2 {
	public static void main(String[] args) {
		Gugudan[] arr = new Gugudan[8];
		GugudanPlay play = new GugudanPlay();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Gugudan((i+2), play);
			arr[i].start();
		}
		}
}
