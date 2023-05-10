package org.joozis.ex;

//부모클래스
class Parent{
	int number;
	void doParent() {
		System.out.println("doParent() 호출");
	}
	
}

//자식 클래스
class Child extends Parent{
	void doChild() {
	System.out.println("doParent() 호출");
	}
}

public class Ex01_Inheritance {
	public static void main(String[] args) {
		
		Child child = new Child();
		
		child.number = 10;
		System.out.println(child.number);
		
		child.doParent();
		child.doChild();
		
	}

}
