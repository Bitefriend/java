package org.joonzis.ex;

import java.util.Scanner;

/*
 * 필드
 *  - String name, dept, score1, score2
 *  - double average
 *  - boolean isPass
 *  
 *  메소드
 *  - 생성자(name, dept)
 *  - input(scanner) : 중간, 기말, 평균, 패스 유무 초기화
 *  - getAverage() : 평균 값 리턴
 *  - isPass() : 패스유무 리턴 (평균 80점 이상 통과)
 *  - output() : 이름, 학과, 평균, 합격 or 불합격 출력
 */
public class Ex02_student {
	private String name, dept, score1, score2;
	private double average;
	private boolean isPass;
	public Ex02_student() {}
	public Ex02_student(String name, String dept) {
		this.name = name;
		this.dept = dept;
	
	}
	
	public void input(Scanner sc) {
		System.out.println("중간 점수 >>");
		score1 = sc.next();
		System.out.println("기말 점수 >>");
		score2 = sc.next();
		average = getAverage();
		isPass = isPass();
		
	}
	private double getAverage() {
		return (Double.parseDouble(score1) +Double.parseDouble(score2)) /2;
	}
	private boolean isPass() {
		return (average >= 80) ? true : false;
	}
	public void output() {
		System.out.println("이름 : " + name);
		System.out.println("학과 : " + dept);
		System.out.println("평균 : " + average);
		System.out.println("합격유무 : " + (isPass ? "합격" : "불합격"));
		
		
	}

}
