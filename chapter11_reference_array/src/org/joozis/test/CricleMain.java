package org.joozis.test;

import java.util.Scanner;

public class CricleMain {
	public static void main(String[] args) {
		
		// 객체를 담을 배열
		Cricle[] r = new Cricle[3];
		
		//circles 배열에 객체 저장
		// 1. 개별로 담는 방법
		// circles[0] = new Circle(3);
		// circles[1] = new Circle(4);
		// circles[2] = new Circle(5);
		
		//circles[0].output();
		//circles[1].output();
		//circles[2].output();
		
		//2. 반복문 이용
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < r.length; i++) {
			System.out.println("반지름 >> ");
			double radius = sc.nextDouble();
			
			r[i] = new Cricle(radius);
			
		}
		for (int i = 0; i < r.length; i++) {
			r[i].output();
			System.out.println((i +1) + "Circle");
			
		}
		
		//가장 큰 원... 가장 큰 원의 크기, 인덱스 번호
		double max = r[0].calcArea();
		int idx = 0; //인덱스 변수
		for (int i = 0; i < r.length; i++) {
			if(max < r[i].calcArea()) {
				max = r[i].calcArea();
				idx = i; // 가장 큰 원의 인덱스 번호 저장
			}
		}
		System.out.println("가장 큰 원의 인덱스 번호 : " + idx);
		System.out.println("가장 큰 원의 크기 : " + max);
		System.out.println("가장 큰 원의 정보 : ");
		r[idx].output();
		
		
		sc.close();
	}

}
