package org.joonzis.ex;

public class Ex02_switch {
	public static void main(String[] args) {
		
		
		
		
		//성인과 미성년자를 구분하는 값
		int age = 25;
		if(age >= 20) {
		//성인
		}else {
			//미성년자
			
			
		}
		
		
		int ckAge = age/20;
		switch (ckAge) {
		case 2 : System.out.println("성인");
			break;
		case 1 : System.out.println("미성년자");  
		    break;

		}
		
		String gender = "남자";
		switch (gender) {
		case "남자":
			
			break;

		case "여자":
			
			break;
		}
		if(gender.equals("남자")) {
			
			
		}else if (gender.equals("여자")) {
			
			
		}
		
	}

}
