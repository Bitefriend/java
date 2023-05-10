package org.joonzis.ex;

public class Ex04_operatior03 {
	public static void main(String[] args) {
		int a = 10;
		System.out.println(a==10 && a < 100); // true
		System.out.println(a != 10 || a == 10); // true
		System.out.println(!(a==10)); // false
		
		int b = 10;
		boolean result = (a==100) && (++b > 10);
		System.out.println("result : " + result + ", b " + b);
		
		
		int age = 21;
		boolean isAdult = (age >= 20) ? true : false;
		//String isAdultstr = (age >= 20 ) ? "성인" : "미성년자";
		int fee = isAdult ? 4000 : 2000;
		System.out.println("요금 : " + fee);
		
		System.out.println(age >= 20 ? 4000 : 2000);
		
		
		String id = "admin";
		// id가 admin 이면 "인증성공", 아니면 "인증실패" 출력
		
		
		System.out.println(id.equals("admin") ? "인증성공" : "인증실패");
	}

}
