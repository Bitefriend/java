package org.joozis.test;

class Computer{
	String model;
	int price, battery;
	public Computer() {}
	public Computer(String model, int price, int battery) {
		this.model = model;
		this.price = price;
		this.battery = battery;
	}
	void output() {	
	}
}
class Notebook extends Computer{
	public Notebook() {}
	public Notebook(String model, int price, int battery) {
		super(model, price, battery);
		
	}
	void output() {
		System.out.println("모델은 : " + model + " 가격은 : " + price + " 배터리는 : " + battery);
	}
	
}
class Tablet extends Computer{
	String pen;
	public Tablet() {}
	public Tablet(String model, int price, int battery, String pen) {
		super(model, price, battery);
		this.pen = pen;
	}
	void output() {
		System.out.println("모델은 : " + model + " 가격은 : " + price + " 배터리는 : " + battery + " 펜유무는 : " + pen);
	}
}

public class Ex02_Main {
	public static void main(String[] args) {
		Notebook no = new Notebook("갤럭시 북", 15000000, 160);
		no.output();
		
		System.out.println("-------------------------------");
		
		Tablet ta = new Tablet("갤럭시 탭", 900000, 50, "있음");
		ta.output();
	}

}
