package org.joozis.ex;
class Animal{
	public void move() { // 의미 없는 메소드
		
	}
}
class Dog extends Animal{
	@Override
     public void move() { 
		System.out.println("강아지 달린다.");
	}
}
class Dolphin extends Animal{
	@Override
    public void move() { 
		System.out.println("돌고래 헤엄친다.");

	}
}
class Eagle extends Animal{
	@Override
    public void move() { 
		System.out.println("독수리 움직인다.");

	}
	public void fly() {
		System.out.println("난다.");
		
	}
}
public class Ex03_polymorphism {
	public static void main(String[] args) {
		Animal[] ani = new Animal[3];
		
		ani[0] = new Dog();
		ani[1] = new Dolphin();
		ani[2] = new Eagle();
		
		ani[0].move();
		ani[1].move();
		ani[2].move();
		
		for (int i = 0; i < ani.length; i++) {
			ani[i].move();
			System.out.println(ani[i]);
		}
		// ani[2].fly(); // 부모 클래스는 fly()메소드가 없기 때문에 호출 불가.
		
		
		if(ani[2] instanceof Eagle) {
			// 다운 캐스팅
			// 1. Eagle 객체 생성
			Eagle eagle = (Eagle)ani[2];
			eagle.fly();
			
			//2. Eagle 객체 생성 없이 자원 사용
			((Eagle)ani[2]).fly();
		}
	}


}
