package org.joonzis.test;

public class Ex03_Student {
	 String name;
	 String dept ;
	 Ex03_Grade grade;
	 public Ex03_Student() {}
	 public Ex03_Student(String n, String d, Ex03_Grade s) {
		  name = n;
		  dept = d;
		  grade = s;
	 }
	 void output() {
		 System.out.println("학생 이름 : " + name);
		 System.out.println("학과 : " + dept);
		 System.out.println("평균 : " + grade.getAverage());
		 System.out.println("학점 : " + grade.getGrade());
	 }

}
