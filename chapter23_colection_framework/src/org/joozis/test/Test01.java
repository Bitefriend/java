package org.joozis.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
//Q1. Test01.java
//
//게시물을 저장하는 Board 클래스를 정의하고, ArrayList를 이용하여 3개의 게시물을 저장하시오.
//1~3번 게시물번호 중 하나를 입력 받아 해당 게시물을 삭제하시오.
//
//class Board			필드 : String title, String content, Date register
//							register -> 현재 날짜 자동 삽입
//					메소드 : 생성자, toString()

class Board{
	Calendar cal = Calendar.getInstance();
	private String title, content;
	private Date register = cal.getTime();
	
	SimpleDateFormat sdf = new SimpleDateFormat("a hh시 mm분 ss초");
	String today = sdf.format(register);
	
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
		this.register = new Date();
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("제목 : ").append(title).append("\n");
		sb.append("내용 : ").append(content).append("\n");
		sb.append("등록일 : ").append(new SimpleDateFormat("yyyy년 MM월 dd일 E요일").format(register));
		return sb.toString() ;
	}
}
public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Board> list = new ArrayList<Board>();
		
		list.add(new Board("1. 공지사항", "모든 회원 필독"));
		list.add(new Board("2. 알림", "관리자만 필독"));
		list.add(new Board("3. 요청", "모든 회원 필독"));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			System.out.println("");
		}
		System.out.println("삭제 할 인덱스 입력하시여");
		int num = sc.nextInt();
		list.remove(num-1);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			System.out.println("");
		}
		sc.close();
	}
}
