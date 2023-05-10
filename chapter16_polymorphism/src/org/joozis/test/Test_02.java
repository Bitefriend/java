package org.joozis.test;
class Product{
	private String model; 
	private int price;
	public Product() {}
	public Product(String model, int price) {
		this.model = model;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public int getPrice() {
		return price;
	}
}
class Tv extends Product{
	public Tv() {}
	public Tv(String model, int price) {
		super(model, price);
	}
}
class Computer extends Product{
	public Computer() {}
	public Computer(String model, int price) {
		super(model, price);
	}	
}
class Customer{//체크카드, 초기 금액,    객체 생성 시 선언
	 private int money, startMoney, numOfProduct;
	 private Product[] cart = new Product[10];
	 public Customer() {}
	 public Customer(int money) {	
		this.money = money;
		this.startMoney = money;
	}
	public void buy(Product product){
		//현재 내 금액보다 구매 금액이 더 크면 메소드 탈출
		if(money < product.getPrice()) {
			System.out.println("소지금액이 부족합니다.");
			return;
		}
		money = money - product.getPrice(); // 소지금액에서 물건 금액 차감
		cart[numOfProduct] = product; // 물건 리스트를 배열에 저장
		numOfProduct++;
	}
	public void output() {
		for (int i = 0; i < cart.length; i++) {
			if(cart[i] != null ) {	
			System.out.println("구매 상품 : " + cart[i].getModel() + "," + cart[i].getPrice());
			}
		}
		System.out.println("처음 소지 금액 : " + startMoney);
		System.out.println("총 구매 금액 : " + (startMoney - money));
		System.out.println("남은 금액 : " + money);
		
	}
	 
}

public class Test_02 {
	public static void main(String[] args) {
		Customer customer1 = new Customer(1000);
		
		customer1.buy(new Tv("삼성 Tv", 500));
		customer1.buy(new Tv("삼성 Computer", 150));
		customer1.output();
	}

}
