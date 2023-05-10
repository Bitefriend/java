package org.joozis.test;
//Q1. Test01.java
//Score 클래스 					필드 : int kor, eng, mat
//							메소드 : Constructor, toString(), equals()
//Score 인스턴스를 2개 생성하고, 동등 비교(세과목이 모두 같으면 동등) 결과 출력
//각 인스턴스 정보는 toString 메소드를 통해 출력

class Score{
	private int kor, eng, mat;
	public Score() {}
	public Score(int kor, int eng, int mat) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public String toString() {
		return "국어 : " + kor + "영어 : " + eng + "수학 : " + mat;
	
	}
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Score) {
			Score an = (Score)obj;
			return kor== an.kor && eng == an.eng && mat == an.mat;
		} else {
			return false;
		}
	}
	
}
public class Test01 {
	public static void main(String[] args) {
		
	Score co = new Score(20, 20, 20);
	Score co2 = new Score(20, 20, 20);
	
	System.out.println("-----참조 비교------");
	if(co == co2) {
		System.out.println("동등");
	}else {
		System.out.println("다름");
	}
	
	System.out.println("-----equals------");
	if(co.equals(co2)) {
		System.out.println("동등");
		
	}else {
		System.out.println("다름");
	}
	co.equals(co2);
	
}
}
