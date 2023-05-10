package org.joozis.test;
//Q2. Test02.java
//로또 & 빙고 (빙고가 어려우면 로또부터 해보기)
//Set을 이용하여 5 X 5 Bingo 배열을 생성하시오. (1 ~ 25)
//Set에 랜덤 생성 -> Bingo 2차원 배열에 저장 

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Test02 {
	public static void main(String[] args) {
		// 1. 로또
		System.out.println("<LOTTO>");
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();
		
		int count = 0;
		String resultStr = "";
		Iterator<Integer> itr = set.iterator();
		int[] num = new int[6];
		while (set.size() < 6) {
			set.add(ran.nextInt(45));
		}
		for (int j = 0; j < num.length; j++) {
			System.out.println((j+1)+"번 번호 입력 >>");
			num[j] = sc.nextInt();
		}
		
	    while(itr.hasNext()) {
	    	int tmp = itr.next();
	    	for (int j = 0; j < num.length; j++) {
				if(tmp == num[j]) {
					count++;
					resultStr += num[j] + "";
				}
			}
	    }
		System.out.println("로또 번호 : " + set);
		System.out.println("선택 번호 : " + Arrays.toString(num));
		System.out.println("맞은 개수 : " + count);
		
	sc.close();	
	}
}
