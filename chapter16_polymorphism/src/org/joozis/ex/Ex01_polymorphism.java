package org.joozis.ex;

class Product{
	public void info() {
		
		System.out.println("Product");
		
}
}
class Computer extends Product{
	@Override
	public void info() {
		
		System.out.println("Computer");
	}

}

class Notebook extends Computer{
	@Override
	public void info() {
		System.out.println("Notebook");
	}
	
}

public class Ex01_polymorphism {
	public static void main(String[] args) {
		//업개스팅
		// 부모(Product) <=자식(Computer, Notebook)
		Product[] product = new Computer[20];
		product[0] = new Computer();
		product[1] = new Computer();
		product[2] = new Notebook();
		
		product[0].info();
		product[1].info();
		product[2].info();
		
		
	}

}
