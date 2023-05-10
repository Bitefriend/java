package org.joozis.ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex10_Date_SimpleDateFormat {
	public static void main(String[] args) {
		
		Date now = new Date(); // Data와 SimpleDateFormat은 짝꿍으로 쓰자
		System.out.println(now);
		
		//SimpleDateFormat
		// 년 : yy, yyyy
		// 월 : m, mm
		// 일 : d, dd
		// 요일 : E
		// 오전 오후 : a
		// 시 : hh(12시간제), HH(24시각제)
		// 분 : mm
		// 초 : ss
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		SimpleDateFormat format2 = new SimpleDateFormat("yy/MM/dd");
		SimpleDateFormat format3 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		SimpleDateFormat format4 = new SimpleDateFormat("M월 W번 째 d번째 날, F번 째 E요일");
				
		
		System.out.println(format1.format(now));
		System.out.println(format2.format(now));
		System.out.println(format3.format(now));
		System.out.println(format4.format(now));
		
	}

}
