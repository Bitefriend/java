package org.joozis.ex;

public class Ex03_TeamMain {
	public static void main(String[] args) {
		Ex03_Team r = new Ex03_Team("아무개");
		r.output();
		Ex03_Team r2 = new Ex03_Team("아무개");
		r2.output();
		Ex03_Team r3 = new Ex03_Team("아무개");
		r3.output();
		
		System.out.println("전체 팀원 : " + Ex03_Team.count + "명");
	
	}

}
