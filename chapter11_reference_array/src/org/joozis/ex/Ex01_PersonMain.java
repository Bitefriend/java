package org.joozis.ex;

public class Ex01_PersonMain {
	public static void main(String[] args) {
		Ex01_Person r = new Ex01_Person("김씨",20,130,'남');
		Ex01_Person r2 = new Ex01_Person("이씨",30,150,'남');
		Ex01_Person r3 = new Ex01_Person("박씨",40,140,'남');
		
		r.output();
		r2.output();
		r3.output();
		
		System.out.println("------------------------------");
		
		// 크기 3의 참조 배열 people을 선언 후 값 입력
		// 각 배열 내 데이터 출력
		Ex01_Person[] people = new Ex01_Person[3];
		people[0] = new Ex01_Person("박씨",40,140,'남');
		people[1] = new Ex01_Person();
		
		for (int i = 0; i < people.length; i++) {
			people[i] =new Ex01_Person();
		}
		
		people[0].output();
		
	}

}
