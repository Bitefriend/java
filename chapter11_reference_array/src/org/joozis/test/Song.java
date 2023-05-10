package org.joozis.test;

public class Song {
	 String title;
	 String country;
	 
	 public Song() {}

	 public Song(String title, String country ) {
		 this.title = title;
		 this.country =country;
	 }
	 
	 void output() {
		 System.out.println("노래 제목 : " + title);
		 System.out.println("국가 : " + country);
	 }

}
