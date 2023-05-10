package org.joonzis.ex;

public class Ex02_Local {
	//필드        // 초기화 상태 (field 값은 초기화 되어 있다.) 
	String name;// null
	int age ; // 0
	String sn; // null // 주민등록번호
	boolean isKorean; // false // 한국인 : true, 외국인 : false
	
	// 메소드
	void setLocalInfo(int a, String s, String n ) {
		//이름, 나이, 주민등록번호를 전달받아 초기화
		// 주민등록번호 뒷자리의 첫 번째 값이 1~4 일 경우 한국인
		age =a;
		name = n;
		sn  = s;
		//1. charAt()
		isKorean = sn.charAt(7) <='4' ? true : false;
		
		//2.substring()
		//int tmp = Integer.parseInt((sn.substring(7,8));
		//isKorean = tmp <= 4 ? true : false;
	}
    void setLocalInfo(int a, String n) {
		// 이름, 나이를 전달받아 초기화
    	age = a;
		name = n;
	
	}
    void output() {
    	// 이름, 나이, 주민등록 번호, 한국인or 외국인 출력
    	// 주민들록 번호가 없으면 "없음"으로 출력
    	System.out.println("나이 : " + age);
		System.out.println("이름 : " + name);
		System.out.println("주민등록번호 : " + sn == null ? "없음" : sn);
		System.out.println(isKorean ? "한국인" : "외국인");

    }
}
