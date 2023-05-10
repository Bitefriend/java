package org.joonzis.test;

import java.util.Scanner;

class Studentsub{
	String name;
	String dept;
	String score1;
	String score2;
	double average;
	boolean isPass;
	
	void init(Scanner sc) {
		
		System.out.println("이름을 입력하시오");
		name = sc.next();
		System.out.println("부서입력");
		dept = sc.next();
		System.out.println("점수를 입력하시오");
		score1 = sc.next();
		System.out.println("점수2을 입력하시오");
		score2 = sc.next();
		int result = Integer.parseInt(score1);
		int result1 = Integer.parseInt(score2);
		average = (result + result1) / 2.0;
	}
	void info() {
		isPass = average < 80 == average > 80 ? true : false;
		System.out.println("평균 점수는 : " + average);
		System.out.println("합격유무는 : " + isPass);
	}

	
}

public class Student {
	public static void main(String[] args) {
		Studentsub r1 =new Studentsub();
		Scanner sc = new Scanner(System.in);
		
		r1.init(sc);
		r1.info();
		
		sc.close();
	}

}
