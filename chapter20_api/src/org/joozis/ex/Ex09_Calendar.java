package org.joozis.ex;

import java.util.Calendar;

public class Ex09_Calendar {
	public static void main(String[] args) {
		// Calendar는 추상 클래스라서 객체를 생성할 수 없다.
		// Calendar 클래스를 구현한 클래스의 getInstanse()를 사용하여 반환
		Calendar cal = Calendar.getInstance(); // 현재시간으로 자동 세팅
		
		// 특정 날짜 셋팅
		//cal.set(1980, 9, 21, 11, 34, 10);
		
		System.out.println("년 : " + cal.get(Calendar.YEAR));
		// 월 : 0~11이므로 +1을 하자
		System.out.println("월 : " + (cal.get(Calendar.MONTH)+1));
		System.out.println("일 : " + cal.get(Calendar.DATE));
		System.out.println("시간 : " + cal.get(Calendar.HOUR));
		
		//요일 번호 : 일(1), 월(2) ... 토(7)
		System.out.println("요일 번호 : "+ cal.get(Calendar.DAY_OF_WEEK));
		
		// 시, 분, 초
		System.out.println("오전/오후 : " + cal.get(Calendar.AM_PM)); // 오전 0, 오후 : 1
		System.out.println("시 : " + cal.get(Calendar.HOUR));       // 12시간제(0~11)
		System.out.println("시 : " + cal.get(Calendar.HOUR_OF_DAY));// 24시간제(0~24)
		System.out.println("분 : " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		System.out.println("밀리초 : " + cal.get(Calendar.MILLISECOND));// 1000분의 1초
		System.out.println("밀리초 -> : " + 
		           (cal.get(Calendar.MILLISECOND) / 1000.0) + "초");
		
		//현재 날짜를 밀리조로 반환
		System.out.println(cal.getTimeInMillis());
		
		
		
	}

}
