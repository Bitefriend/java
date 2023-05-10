package org.joonzis.test;

import java.util.Calendar;

//Q1.
//Car.java				필드 -String model, String color, int year, booleans isNewCar
//						메소드 - Constructor, output
//CarMain.java
//★
//생성자(모델, 색상, 연식) / 생성자(모델, 색상)
//Calendar calendar = Calendar.getInstance();
//calendar.get(Calendar.YEAR);

public class Ex01_Car {
	String model;
	String color;
	int year;
	boolean isNewCar;
	
	public Ex01_Car() {
		
	}
	
	public Ex01_Car(String m, String c, int y) {
		model = m;
		color = c;
		year = y;
	}
	public Ex01_Car(String m, String c) {
		model = m;
		color = c;
		
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
	}
	void Constructor() {
		if(year == 2022) {
			isNewCar = true;
		}else {
			isNewCar = false;
		}
	}
	void output() {
		System.out.println("모델 : " + model);
		System.out.println("색상 : " + color);
		System.out.println("출시 년도 : " + year);
		System.out.println("연식 : " + (isNewCar ? "신형" : "구형"));
	}

}
