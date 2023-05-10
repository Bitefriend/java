package org.joonzis.ex;

public class Ex04_Book {
	/*
	 * 필드 
	 * - String title          : 책제목
	 * - String writer         : 저자
	 * - int price             : 책 가격
	 * - int salesVloume       : 판매량
	 * - boolean isBestSeller  : 베스트 셀러 유무
	 * 
	 * 메소드 
	 * - 생성자()
	 * - 생성자() : 제목, 가격 초기화(저자는 "작자 미상"으로 기입)
	 * - 생성자() : 제목, 가격, 저자 초기화
	 * - setSalesVloume(int sales) : 판매량이 1000이상이면 베스트셀러
	 * - output() : 제목, 저자, 가격, 판매량, 베스트셀러 유무 출력
	 */
	
	
	String title;
	String writer;
	int price;
	int salesVolume;
	boolean isBestSeller;
	
	
	public Ex04_Book() {
		
	}
	public Ex04_Book(String a, int n) {
		title = a;
		price = n;
		writer = "작자 미상";
	}
	public Ex04_Book(String a, int n, String b) {
		title = a;
		price = n;
		writer = b;
	}
	void setSalesVoume(int sales) {
		//set은 저장
		//get은 return
		salesVolume = sales;
		if(salesVolume>=1000) {
			isBestSeller = true;
		}else {
			isBestSeller = false;
		}
	}
	
	void output() {
		System.out.println("책 제목 : " + title);
		System.out.println("저자 : " + writer);
		System.out.println("가격 : " + price);
		System.out.println("판매량 : " + salesVolume);
		System.out.println("베스트 셀러 유/무 : " + (isBestSeller ? "베스트셀러" : "일반서적"));
	}

}
