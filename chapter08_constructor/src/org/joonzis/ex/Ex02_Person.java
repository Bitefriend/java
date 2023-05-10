package org.joonzis.ex;
/*
 * 필드
 * - int age
 * - String name
 * - double height
 * - char gender
 * 
 * 메소드 
 * - 풀 생성자
 * - output() : 이름, 나이, 키, 성별 출력
 */

public class Ex02_Person {
	int age;
	String name;
	double height;
	char gender;
	
	public Ex02_Person() {}  // 기본생성자 입력 필수
	
	public Ex02_Person(int a, String n, double h, char c) {
		age = a;
		name = n;
		height = h;
		gender = c;
	}
	void output() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("성별 : " + gender);
		
	}
	

}
