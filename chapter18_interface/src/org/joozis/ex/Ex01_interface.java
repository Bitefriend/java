package org.joozis.ex;

interface Animal{
	void move();          // 자동으로 abstract public void move();로 처리
	void eat(String food);
	
	
}

class Dog implements Animal{

	@Override
	public void move() {
		System.out.println("개가 달린다.");
		
	}

	@Override
	public void eat(String food) {
		System.out.println(food + " 먹는다.");
		
	}
}

public class Ex01_interface {
	public static void main(String[] args) {
		Animal a = new Dog();
		a.eat("바나나");
		a.move();
		
		
	}

}
