package org.joonzis.ex;

public class Ex08_parsing {
	public static void main(String[] args) {
		/*
		 * 문자열 변환은 형 변환(casting)이 아니고, 구문 분석(pasing)이다.
		 * 
		 * 1. 문자열 > 정수 (String > int)
		 * Integer.parseInt("10") > Integer 는 int의 참조 자료형
		 * 
		 * 2/ 문자열 > 실수 (String > double )
		 * Double.parseDouble("3.14") > 3.14
		 * 
		 * 3. 정수 / 실수 > 문자열 (int / double  > string)
		 * String.valueOf(10) > "10"
		 * String/valueOf(3.14) > 3.14"
		 */
		
		
		String strAge = "20";
		String strHeight = "180.5";
		
		int age = Integer.parseInt(strAge);
		double height = Double.parseDouble(strHeight);
		
		System.out.println("나이 : " + age + " , 키 : " + height + "cm");
		
		// 문자열의 비교는 "=="로 진행하지 않는다.
		// equals() 메소드를 이용하여 비교한다.
		
		String s1 = "aaa";
		String s2 = s1;
		String s3 = new String("aaa");
		
		 if(s1 == s2) {  // true
			 System.out.println("같다");
		 }else {
			 System.out.println("다르다");
		 }
		 if(s1 == s3) { //false
			 System.out.println("같다");
		 }else {
			 System.out.println("다르다");
			 
		 } if(s1.equals(s3)) { // true
			 System.out.println("같다");
		 }else {
			 System.out.println("다르다");
		 }
		 
		 
		 /*
		  *  ==연산자의 경우 객체의 주소 값을 비교
		  *  .equals() 메소드의 경우 대상의 값 자체를 비교
		  *  
		  *  CBV(Call By Value) - 원시 데이터 타입(주소 값을 가지지 않는다.)
		  *  CBR(Call By Reference) - 참조 객체 (클래스 등)
		  */
		
	}

}
