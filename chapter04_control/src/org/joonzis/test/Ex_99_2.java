package org.joonzis.test;

public class Ex_99_2 {
	public static void main(String[] args) {
//		Q2. 국어 99점, 영어 80점, 수학 96점의 평균 값을 실수형과 정수형으로 출력
		int sub1 = 99;
		int sub2 = 80;
		int sub3 = 96;
		
		System.out.println("평균 점수는 " + ((sub1 + sub2 + sub3)/3) + "입니다.");
		System.out.println("평균 점수는 " + ((double)(sub1 + sub2 + sub3)/3) + "입니다.");
		

}
}