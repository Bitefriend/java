package org.joonzis.test;

public class DogMain {
	public static void main(String[] args) {
		Dog r1 = new Dog();
		r1.setDog("푸들", 15);
		r1.info();
		
		System.out.println("----------------------------------------");
		
		Dog r2 = new Dog();
		r2.setDog("푸들", 10, "치와와");
		r2.info();
	}

}
