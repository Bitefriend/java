package org.joozis.ex;

public class Ex02_Book {
	String title, writer;
	int price, salesVolume;
	boolean isBestSeller;
	
	public Ex02_Book() {}
	public Ex02_Book(String title, int price) {
		this(title, "작자미상", price);
		this.title = title;
		this.writer = "작자미상";
		this.price = price;
	}
	public Ex02_Book(String title,String writer, int price) {
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

}
