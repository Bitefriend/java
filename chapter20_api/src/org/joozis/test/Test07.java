package org.joozis.test;

import java.util.Calendar;

//Q7.Test07.java
//현재 날짜를 StringBuffer, Calendar 클래스를 이용하여
//"2019년 10월 21일 월요일 오후 1시 10분" 과 같은 형식으로 완성하고 출력하시오.
//StringBuffer.append() 이용
//String[] weeks = {"","일","월","화","수","목","금","토"};
public class Test07 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		String[] weeks = {"","일","월","화","수","목","금","토"};
		String[] ap = {"오전", "오후"};
		
		sb.append(cal.get(Calendar.YEAR) + "년 ");
		sb.append(cal.get(Calendar.MONTH)+1 + "월 ");
		sb.append(cal.get(Calendar.DATE)+1 + "일 ");
		sb.append(weeks[cal.get(Calendar.DAY_OF_WEEK)] + "요일 ");
		sb.append(ap[cal.get(Calendar.AM_PM)] + " ");	
		//sb.append(cal.get(Calendar.AM_PM) == 0 ? "오전" : "오후" + " ");	
		sb.append(cal.get(Calendar.HOUR) + "시 ");
		sb.append(cal.get(Calendar.MINUTE) + "분 ");

		System.out.println(sb);
	}

}
