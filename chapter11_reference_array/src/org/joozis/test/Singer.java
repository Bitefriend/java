package org.joozis.test;

public class Singer {
	String name;
	Song[] songList;
	int idx;
	
	Song[] arr;
	
	public Singer() {}
	
	public Singer(String name, int songCount) {
		this.name = name;
		songList = new Song[songCount];
		
	}
	
	void setSong(Song song) {
		songList[idx] = song;
		idx++;
		}
	void output() {
		System.out.println("가수 이름 : " + name);
		System.out.println("노래 모음 ----------");
		for (int i = 0; i <idx; i++) {
			songList[i].output();
		}
		
	}
	

}
