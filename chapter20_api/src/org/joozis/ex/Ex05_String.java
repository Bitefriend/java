package org.joozis.ex;

public class Ex05_String {
  public static void main(String[] args) {
	
	// 인스턴스는 다르지만 내부 데이터 동일하므로 객체 1개만 저장
		String a = "apple";
		String b = "apple";
		System.out.println(a == b ? "apple 1개" : "apple 2개");
		
		
		String c = new String ("banana");
		String d = new String ("banana");
		System.out.println(c == d ? " banana 1개" : "banana 2개");
		
		//.split()
		String sn = "000000-1234567";
		String [] snArr = sn.split("-"); // 하이픈(-)으로 분리하여 각각 배열에 저장
		for (String s:snArr) {
			System.out.println(s);
		}
		
		String today = "1980.10.21";
		String[] ymd = today.split("\\.");
		// 몇몇 특수문자는 사용 시 앞에 역슬래쉬 2개 (\\)를 붙여줘야함
		// | ? * ( ) { } [ ] \
		for(String n:ymd) {
			System.out.println(n);
		}
		
		//.join()
		String today2 = String.join("-", ymd); // 배열 요소 사이에 하이픈(-) 넣어서 합치기
		System.out.println(today2);
		
		//.valueOf
		// 정수 -> 문자열 : String.valueOf(10) == "10"
		// 실수 -> 문자열 : String.valueOf(1.5) + "1.5"
		
		//.substring()
		//.substring(시작인덱스) : 시작부터 끝까지 출력
		//.substring(시작인덱스, 종료인덱스) : 시작 인덱스 포함, 종료 인덱스 불포함(종료인덱스 전까지)

		String phone = "010-1234-5678";
		String p1 = phone.substring(0,3);
		String p2 = phone.substring(4,8);
		String p3 = phone.substring(9);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
//		String[] ph = phone.split("-");
//		for (String s:ph) {
//			System.out.println(s);
		
		
		
		
	}

}
