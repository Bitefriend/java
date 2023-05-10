package org.joozis.test;

class Human1 {
	String name;
	int age;
	
	public Human1() {}
	public Human1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	void output() {
		System.out.println("이름은 : " + name + " 나이는 : " + age);
	}
	
	}
class Student1 extends Human1 {
	String school;
	public Student1() {}
	public Student1(String school) {
		super();
		this.school = school;
	}
	public Student1(String name, int age, String school) {
		super(name, age);
		this.school = school;
	}
	void output() {
		super.output();
		System.out.println( "학교는 : " + school);
	}
	
}
class Worker1 extends Human1{
	String job;
	public Worker1() {}
	public Worker1(String name, int age, String job) {
		super(name, age);
		this.job = job;
	}
	void output() {
		super.output();
		System.out.println( "직업은 : " + job);
	}
	
}




public class Ex01_Main {
	public static void main(String[] args) {
		Student1 st = new Student1("김아무개",155,"s대");
		st.output();
		
		System.out.println("-------------------");
		
		Worker1 wo = new Worker1("이아무개", 153, "개발자");
		wo.output();
	}

}
