package org.joonzis.test;
//Q3.
//Grade.java				필드 - int kor, int eng, int mat, double average, char grade
//						메소드 - Constructor, getAverage(평균을 리턴), getGrade(학점을 리턴)
//Student.java			필드 - String name, String dept, Grade grade
//						메소드 - Constructor, output
//StudentGradeMain.java			

public class Ex03_Grade {
	int kor; 
	int eng; 
	int mat;
	double average;
	char grade;
	
	public Ex03_Grade() {}
	
	public Ex03_Grade(int k, int e, int m) {
		kor = k; 
		eng = e;
		mat = m;
		
		
	}
	double getAverage() {
		
		return (kor + eng + mat) / 3.0;
	}
	char getGrade() {
		
		if(getAverage()>= 90) {
			return 'A';
		}else if (getAverage() >= 80) {
			return 'B';
		}else if (getAverage() >= 70) {
			return 'C';
		}else if (getAverage() >= 60) {
			return 'D';
		}else if (getAverage() < 60) {
			return 'F';
		}
		 return grade;

	}
	
	

}
