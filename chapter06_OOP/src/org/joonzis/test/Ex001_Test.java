package org.joonzis.test;

import java.util.Calendar;

public class Ex001_Test {
//	Q1. 
//	클래스 Car 를 정의하시오.
//	- 필드 : String model,String color, int year
//	- 메소드 : setFields(model, color) : 올해를 year로 처리, 
//			 setFields(model, color, year),
//			 output()
//	클래스 CarMain을 정의 하시오.
//	★
//	Calendar calendar = Calendar.getInstance();
//	calendar.get(Calendar.YEAR);	 // 현재 년도
	String model;
	String color;
	int year ;

	void setFields(String _model,String _color) {
		model = _model;
		color = _color;
		
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
	}
	void setFields(String _model,String _color,int _year) {
		model = _model;
		color = _color;
	    year = _year;
	}
	void output() {
		System.out.println("Car의 모델명은 : " + model);
		System.out.println("Car의 색상은 : " + color);
		System.out.println("Car의 출시일은 : " + year);
	}
}
