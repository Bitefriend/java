package org.joozis.test;
//4. Test04.java
//
//Student 클래스	필드 : String no(학번), String name, int[] scores(국,영,수)
//double average, char grade, 상수 int COURSE_COUNT(과목수)
//메소드 : Student(String no, String name)
//setter{
//setScores(int kor, int eng, int mat) - 직접 입력
//setScores(int[] scores) - 랜덤 입력
//setAverage()
//setGrade()
//}
//toString() 학번, 성명, 평균, 학점 출력
// equals() 학번이 같으면 같은 학생으로 비교  

import java.util.Random;

class Student{
	private String no, name;
	private int[] scores;
	private double average ;
	private char grade;
	public static final int COURSE_COUNT = 3 ;
	
	public Student() {}
	public Student(String no, String name) {
		this.name = name;
		this.no = no;
		scores = new int[COURSE_COUNT];
	}
	public void setScores(int kor, int eng, int mat) {
		scores[0] = kor;
		scores[1] = eng;
		scores[2] = mat;
		setAverage();
		setGrade();
	}
	public void setScores(int[] scores) {
		for (int i = 0; i < COURSE_COUNT; i++) {
			this.scores[i] = scores[i];
		}
		setAverage();
		setGrade();
	}
	private void setAverage() {
		int total = 0;
	    for (int i = 0; i < COURSE_COUNT; i++) {
			total += scores[i];
		}
	    average =(double) total / COURSE_COUNT;
	}
	private void setGrade() {
		if(average >= 90) {
			grade = 'A';
		}else if (average >= 80) {
			grade = 'B';
		}else if(average >= 70) {
			grade = 'C';
		}else if(average >= 60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
	}
	@Override
	public String toString() {
		return "학번 : " + no + " 성명 : " + name + " 평균 : " + average + " 학점 : " + grade ;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Student) {
			Student an = (Student)obj;
			return no.equals(an.no) ;
		}else {
			return false;
		}
	}
}
public class Test04 {
	public static void main(String[] args) {
		Student st = new Student("1234", "아무개");
		
		st.setScores(50, 60, 70);
		
		
		Student st2 = new Student("1234", "아무개");
		
		
		int[] sco =new int[Student.COURSE_COUNT];
		Random ran = new Random();
		for (int i = 0; i < sco.length; i++) {
			sco[i] = ran.nextInt(100)+1;
		}
		st2.setScores(sco);
		
		if(st == st2) {
			System.out.println("같은 학생");
			
		}else {
			System.out.println("다른 학생");
		}
		System.out.println("-----------------");
		
		if(st.equals(st2)) {
			System.out.println("같은학생");
			
		}else {
			System.out.println("다른 학생");
		}
		System.out.println(st.toString());
		System.out.println(st2.toString());
	}

}
