package org.joonzis.ex;

import java.util.Scanner;

public class Ex06_break {
	public static void main(String[] args) {
		
		
		// id를 입력 받아서 id가 "admin이면 "Id일치" 추력 후 반복문 종료
		// 일치하지않으면 " 다시 입력하세요 " 출력
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디를 입력하세요. >>");
			String id = sc.nextLine();
			
			//System.out.println((id=="admin") ? "ID일치" : "다시입력하세요");
			
			
			if(id.equals("admin")) {
				System.out.println("ID일치");
				break;
				
			}else {
				System.out.println("다시 입력하세요!!");
			}
			
		}
		
		
	
	}

}
