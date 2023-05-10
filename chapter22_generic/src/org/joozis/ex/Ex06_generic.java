package org.joozis.ex;
class Basket<T>{
	private T[] foods;
	@SuppressWarnings("unchecked") // 명확하지 않은 타입 체크이지만, 더 이상 경고하지마라
	public Basket(int length) {
		foods = (T[])(new Object[length]);
	}
	public void add(T food) { // setter
		// 순차적으로 순회하다가 빈자리가 발견되면 그 자리에 저장.
		// items 배열에 item 변수 저장
		for (int i = 0; i < foods.length; i++) {
			if(foods[i] == null) {
				foods[i] = food;
				break;
			}
		}
		}
	public T[] getFoods() {
		return foods;
	}
}
class Food{}
class Apple extends Food{}
class Banana extends Food{}
class Bread extends Food{}
class Computer{}

public class Ex06_generic {
	public static void main(String[] args) {
		Basket<Food> fo = new Basket<>(10);
		fo.add(new Apple());
		fo.add(new Banana());
		fo.add(new Bread());
		fo.add(new Food());
		
	}
	


}