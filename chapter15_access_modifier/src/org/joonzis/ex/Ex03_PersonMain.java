package org.joonzis.ex;

public class Ex03_PersonMain {
	public static void main(String[] args) {
		Ex03_Person pe = new Ex03_Person();
		
		// p1.name = "김씨"; private 처리가 되어서 모든 Field는 접근 불가
		// setter를 통한 데이터 입력
		pe.setName("김씨");
		System.out.println(pe.getName());
		pe.setAge(15);
		pe.setGender('쁑');
		pe.setHeight(301);
		System.out.println("이름 : " + pe.getName());
		System.out.println("나이 : " + pe.getAge());
		System.out.println("성별 : " + pe.getGender());
		System.out.println("키 : " + pe.getHeight());
	}

}
