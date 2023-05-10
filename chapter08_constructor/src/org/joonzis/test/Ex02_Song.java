package org.joonzis.test;
//Q2.
//Song.java				필드 - String title, String country
//						메소드 - Constructor, output
//Singer.java				필드 - String name, Song song 
//						메소드 - Constructor, setSong(s), output
//SingerSongMain.java		
public class Ex02_Song {
	String title;
	String country;
	
	public Ex02_Song() {}
	

	public Ex02_Song(String t, String c) {
		title = t;
		country = c;
	}

	
	void output() {
		System.out.println("노래 타이틀 : " + title );
		System.out.println("국가: " + country );
		
	}

}
