package org.joozis.ex;

class Person{
	void sleep() {
		System.out.println("잔다");
	}
	void eat(String food) {
		System.out.println(food + "먹는다");
	}
}
class Student extends Person{
	void study() {
		System.out.println("공부한다.");
	}
}

public class Ex02_Inheritance {
	public static void main(String[] args) {
		
		// 밥먹는다
		//공부한다
		//잔다
		Student student = new Student();
		
		student.sleep();
		student.eat("맛난걸 ");
		student.study();
		
	}

}
