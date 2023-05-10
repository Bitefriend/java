package org.joozis.ex;

interface Eatable{
	void eat(); // public abstract void eat();
	
}
class Pig{
	public void piggy() {
		System.out.println("다 먹는다!");
	}
}
class Apple extends Pig implements Eatable{
	@Override
	public void eat() {
		System.out.println("사과는 맛있어");
		
	}
}
class Banana extends Pig implements Eatable{
	@Override
	public void eat() {
		System.out.println("맛있으면 바나나");
		
	}
}
class Computer extends Pig{
	
}

public class Ex03_interface {
	public static void main(String[] args) {
		Pig[] p = new Pig[3];
		p[0] = new Apple();
		p[1] = new Banana();
		p[2] = new Computer();
				
		for (int i = 0; i < p.length; i++) {
			p[i].piggy();
			
			if((p[i]) instanceof Apple) {
				((Eatable)p[i]).eat();
			
			}else {
				System.out.println(" 못 먹어");
			}
			
			// 사과는 맛있어
			// 맛있으면 바나나
			// 출력
			//출력하지 못하는 클래스는 " 못 먹는다..." 출력
		}
	}
}
