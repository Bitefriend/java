package org.joozis.ex;
class Computer{
	private String model;
	private int price;
	public Computer(String model, int price) {
		this.model = model;
		this.price = price;
	}
	@Override
	public String toString() {
		return "모델 : " + model + ", 가격 : " + price;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Computer) {
			Computer another = (Computer)obj;
			return model.equals(another.model) && price == another.price;
		}else {
			return false;
		}
	}
}
public class Ex02_object_equals {
	public static void main(String[] args) {
		
		Computer co = new Computer("맥북", 129);
		Computer co2 = new Computer("한성", 150);
		
		//1. == : 참조 비교(주소 비교)
		if(co == co2) {
			System.out.println("같은 종류의 컴퓨터");
		}else {
			System.out.println("다른 종류의 컴퓨터");
		}
		
		//2. equals()
		//  1)Object의 equals 메소드 : 객체 비교 불가
		//  2)Computer 클래스에서 equals 메소드 오버라이드
		if(co.equals(co2)) {
			System.out.println("같은 종류의 컴퓨터");
			
		}else {
			System.out.println("다른 종류의 컴퓨터");
		}
		co.equals(co2);
		
	}

}
