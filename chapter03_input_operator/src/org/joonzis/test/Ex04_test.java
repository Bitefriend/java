package org.joonzis.test;

public class Ex04_test {
	public static void main(String[] args) {
		//Q. 성별을 의미하는 정수 값(1,3:남자, 2,4:여자)을 입력받아 "남자", "여자"출력하기
		//* 1~4 사이의 값으로 입력 받기 
		//* 홀수-남자 짝수-여자
		int a = 3;
		String gender = (a % 3 == 1) ? "남자" : "여자";
		System.out.println("성별 : " + gender);
	}

}
