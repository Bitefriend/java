package org.joozis.ex;

import java.util.Scanner;

public class Ex03_StudentManager {
	int idx; //외부(전역)에서 접근 가능한 인덱스
	Ex03_Strudent[] arr;
	Scanner sc = new Scanner(System.in);
	
	// 생성자 - 몇 명의 학생을 관리할지 - 배열 선언
	public Ex03_StudentManager() {}
	public Ex03_StudentManager(int numOfStudents) {
		arr = new Ex03_Strudent[numOfStudents];
	}
	
	// 학생 정보를 저장한 뒤 학생 객체 리턴
	Ex03_Strudent input() {
		System.out.println("학생 이름 >>");
		String name = sc.nextLine();
		System.out.println("학생 학과 >>");
		String dept = sc.nextLine();
		System.out.println("중간 점수 >>");
		String score1 = sc.nextLine();
		System.out.println("기말 점수 >>");
		String score2 = sc.nextLine();
		return new Ex03_Strudent(name, dept, score1, score2);
	}
	//input() 메소드에서 받아온 학생 객체를 배열에 저장
	void addNewStudent(Ex03_Strudent student) {
		arr[idx] = student;
		idx++;
	}
	
	//전체 학생 정보 출력 
	void outputAllStudents() {
		for (int i = 0; i<idx; i++) {
			System.out.println((i+1) + "번 학생 정보 -------");
			arr[i].output();
		}
		
	}
	void outputAverage() {
		double total = 0;
		for (int i = 0; i < idx; i++) {
			total =+ arr[i].getAverage();
		}
		System.out.println("****** 전체 평균 : " + (total / arr.length) );
	}
	//학생 찾는 메소드
	Ex03_Strudent findStudent() {
		System.out.println("착을 학생의 이름 입력 >>");
		String name = sc.next();
		for (int i = 0; i <idx; i++) {
			if(name.equals(arr[i].name)) {
				return arr[i];
			}
		}
		return null; // 찾는 학생이 없을 때
	}
	void outputi(Ex03_Strudent student) {
		if(student != null) {
			student.output();
		}else {
			System.out.println("찾는 학생이 없습니다.");
		}
	}
}
