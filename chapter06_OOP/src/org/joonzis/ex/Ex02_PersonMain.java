package org.joonzis.ex;
class Person{
	//필드
	char gender;
	int age;
	double height;
	String name;
	
	//메소드
	void info() {
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("이름 : " + name);
		
	}
	
}
public class Ex02_PersonMain {
	public static void main(String[] args) {
		Person women = new Person();
		
		
		women.gender = '여';
		women.age = 82;
		women.height = 150.3;
		women.name = "김옥분";
		
		women.info();
		
		System.out.println("-----------------------------------------------------");
		
		
		Person man = new Person();
		man.gender = '남';
		man.age = 95;
		man.height = 183.5;
		man.name = "곽두팔";
		
		man.info();
	
		
	}

}