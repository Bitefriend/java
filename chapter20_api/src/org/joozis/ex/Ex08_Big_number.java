package org.joozis.ex;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Ex08_Big_number {
	public static void main(String[] args) {
		
		//int 최대 값
		System.out.println(Integer.MAX_VALUE);
		//long형 최대 값
		System.out.println(Long.MAX_VALUE);
		
		
		//BigInteger 클래스를 활용해서 long 타입 이상/ 이사 사용가능
		//반드시 문자열 처리해서 적어주자
		BigInteger a = new BigInteger("12345678901234567890");
		BigInteger b = new BigInteger("12345678901234567894561234560");
		
		//BigInteger 필드 값
		System.out.println(BigInteger.ZERO);
		System.out.println(BigInteger.ONE);
		System.out.println(BigInteger.TEN);
		
		//사칙연산
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
		System.out.println(a.divide(b));
		
		//BigDecimal 클래스로 실수의 소수 자릿수를 제한없이 사용가능
		double d = 1.2345678899087587;
		System.out.println(d);
		BigDecimal e = new BigDecimal("1.1234567879890088645653642624246");
		System.out.println(e);
		
	}

}
