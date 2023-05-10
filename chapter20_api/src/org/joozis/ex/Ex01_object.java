package org.joozis.ex;
class Sample{
	@Override
	public String toString() {
		return "SAMPLE";
	}
}

public class Ex01_object {
	public static void main(String[] args) {
		
		Object object = new Object();
		System.out.println(object);
		
		object = 10;
		System.out.println(object);
		
		object = "Helo";
		System.out.println(object);
		
		//Object object = new Sample(); // 업캐스팅
		object = new Sample();
		//객체만 출력 하더라도 자동으로 toString()이 반환
		System.out.println(object.toString());
		System.out.println(object);
	}
}
