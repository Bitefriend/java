package org.joozis.ex;
class Person{
	public void eat(String food) {
		System.out.println(food + "먹는다");
	}
	public void sleep() {
		System.out.println("잔다");
	}
}
class Student extends Person{
	public void study() {
		System.out.println("공부한다.");
	}
}
class Worker extends Person{
	public void work() {
		System.out.println("일한다.");
	}
}
public class Ex04_polymorphism {
	public static void main(String[] args) {
		
		
		Person pe = new Student(); // 업캐스팅
		// 학생은 급식먹고 잠 자고 공부하고
		pe.eat("급식 ");
		pe.sleep();
		//Student stu = (Student)pe; // 다운 캐스팅
		//stu.study(); // 다운 캐스팅
		if(pe instanceof Worker) {
		((Student)pe).study();
		}
		
		System.out.println("-----------------------------------------");
		
		
		Person pe1 = new Worker(); // 업캐스팅
		// 직장인은 술 먹고 잠 자고 일하고
		pe1.eat("술 ");
		pe1.sleep();
		// 다운 캐스팅 : Person -> Student 강제 변환
		if(pe1 instanceof Worker) {
			Worker wo = (Worker) pe1;
			wo.work();
		}	
	}

}
