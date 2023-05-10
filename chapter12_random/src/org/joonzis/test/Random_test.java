package org.joonzis.test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Random_test {
	public static void main(String[] args) {
		Scanner r2 = new Scanner(System.in);
		Random r = new Random();
		
		int[] r1 = new int[6]; // 랜덤 값 배열
		int[] d = new int[6]; // 선택 값 배열
		int count = 0;
		
		
		// 1. 랜덤 데이터 r1 배열에 저장
		for (int i = 0; i < d.length; i++) {
			r1[i] = r.nextInt(45) + 1;
		}
		System.out.println("로또 번호" + Arrays.toString(r1));
		// 2. 입력 데이터 d 배열 저장
		for (int j = 0; j < d.length; j++) {
			System.out.println("임의 번호 입력");
			d[j] = r2.nextInt();
		}
		
		// 3. 각 배열 값 비교
		String resultStr = "";
		for (int i = 0; i < r1.length; i++) { 
			// System.out.println(Arrays.toString(r1));
		for (int j = 0; j < d.length; j++) {
			if(r1[i] == d[j]) {
				count++;
				resultStr += Integer.toString(r1[i]) + " ";
		 
		}	
		}
		}
		//1. 랜덤 데이터 배열저장
		for (int i = 0; i < d.length; i++) {
			d[i] = r.nextInt(45) + 1;
			for (int m = 0; m < i; m++) {
				if(d[i]==d[m]) {
					i--;
				}
			}
		}
		
		System.out.println("로또 번호 : " + Arrays.toString(r1));
		System.out.println("선택 번호 : " + Arrays.toString(d));
		System.out.println("맞은 개수 : " + count);
		System.out.println("내용 나열 : " + resultStr);
		
//		for (int i = 0; i < d.length; i++) {
//			for (int j = 0; j < r1.length; j++) {
//				if(r1[i] == d[j]) {
//					num[] =
//				}
//			}
//		}
//			 System.out.println(count);
//			 
//		
		
	}

}