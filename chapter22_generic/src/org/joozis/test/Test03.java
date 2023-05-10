package org.joozis.test;
//Q3. Test03.java
//1. 메인클래스를 보고 알맞은 클래스들을 구현하시오.
//2. Product 클래스를 구현하시오.
//	필드 : T1 category, T2 model
//	적절한 메소드 구현하기
//	
//public static void main(String[] args) {
//
//	Product<Elec, Tv> product1 = new Product<>();
//	Product<Life, Cup> product2 = new Product<>();
//
//	product1.setCategory(new Elec());
//	product1.setModel(new Tv("LG"));
//	
//	System.out.println(product1);			// 출력 예시) 전자제품, LG TV
//}
class Product<T1,T2>{
	private T1 category;
	private T2 model;
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(category).append(model);
		return sb.toString();
}
	public void setCategory(T1 category) {
		this.category = category;
	}
	public void setModel(T2 model) {
		this.model = model;
	}
}
class Elec{
	@Override
	public String toString(){
		return "전자제품";
	}
}
class Tv{
	private String model;
	public Tv(String model) {
		this.model=model;
	}
	@Override
	public String toString(){
		
		return " TV";
	}
}
class Life{
	private String model;
	public Life(String model) {
		this.model=model;
	}
	@Override
	public String toString(){
		
		return "실생활 ";

	}
}
class Cup{
	@Override
	public String toString(){
		return "머그컵";
	}
}
public class Test03 {
	public static void main(String[] args) {
		Product<Elec, Tv> product1 = new Product<>();
	    Product<Life, Cup> product2 = new Product<>();
	
	    product1.setCategory(new Elec());
		product1.setModel(new Tv("Lg"));
		product2.setCategory(new Life("다이소"));
		product2.setModel(new Cup());
		
		System.out.println(product1);
		System.out.println("---------------");
		System.out.println(product2);
	}

}
