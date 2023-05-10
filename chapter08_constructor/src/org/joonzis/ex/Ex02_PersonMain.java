package org.joonzis.ex;

public class Ex02_PersonMain {
	public static void main(String[] args) {
		Ex02_Person r2 = new Ex02_Person() ;
				r2.output();
				
				/*
				 * 개발자가 생성자를 하나도!! 구현하지 않았다면>> 자바가 디폴트 생성자를 만들어서 호출
				 * 개발자가 생성자를 하나라도 !! 구현했다면 >> Person(){} 형태의 생성자가 없을 때 오류 발생
				 * 즉! 개발자가 생성자를 만들면, 개발자가 원하는 모습으로만 객체를 생성할 수 있다.
				 */
				
				Ex02_Person r1 = new Ex02_Person(25, "김씨", 170, '여') ;
				r1.output();
	}

}
