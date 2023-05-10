package org.joonzis.test;

public class Ex04_Ring {
	Ex04_Circle inner, outer;

	public Ex04_Ring() {
		
	}
	
	public Ex04_Ring(Ex04_Circle inner, Ex04_Circle outer) {
		this.inner = inner;
		this.outer = outer;
	}
	void output () {
		System.out.println("안쪽 원의 정보");
		inner.output();
		System.out.println("바깥쪽 원의 정보");
		outer.output();
	}

}
