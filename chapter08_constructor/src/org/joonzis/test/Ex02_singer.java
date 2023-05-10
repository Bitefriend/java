package org.joonzis.test;

public class Ex02_singer {
	String name; 
	Ex02_Song song;
	
	public Ex02_singer() {}
	
	public Ex02_singer(String n) {
		name = n;
		
		
	}
	void setSong(Ex02_Song r1) {
	     song = r1;
	}
	void output() {
		System.out.println("가수 : " + name);
		song.output();
	}

}
