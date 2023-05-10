package org.joonzis.ex;

public class Ex04_Triangle {
	int width;
	int height;
	
	void setFields (int w, int h) {
		width = w;
		height = h;
	}
	
	// 아래 두 calcArea메소드가 오버로딩 되지 않은 이유
	//->메소드 이름은 같으나, 매개 변수가 다르지 않다.
	int calcArea() {       //일부러 오류냄
		return width * height / 2;
	}
	int calcArea() {
		return width * height /2.0;
	}

}
