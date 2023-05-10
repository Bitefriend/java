package org.joozis.test;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

//Q2. Test02.java
//로또 & 빙고 (빙고가 어려우면 로또부터 해보기)
//Set을 이용하여 5 X 5 Bingo 배열을 생성하시오. (1 ~ 25)
//Set에 랜덤 생성 -> Bingo 2차원 배열에 저장 
public class Test02_1 {
	public static void main(String[] args) {
		//2. 빙고
		
		/*
		 * Hashset으로 빙고 이용시 숫자 오름차순 정렬 증상
		 * - set의 특성상 입력 순서가 출력 순서와 같은 것은 아님
		 * - 적은 데이터가 일률적으로 들어갈 시 오름차순 정렬 증상 발생
		 * - 로또의 경우 45개의 데이터 중 6개만을 입력하여 문제 x
		 * - 빙고의 경우 25개의 데이터 중 25개를 그대로 사용하여 증상 발생
		 */
		
		System.out.println("<BINGO>");
		
		Random ran = new Random();
		Set<Integer> set = new LinkedHashSet<Integer>();
		
		while(set.size() < 25) {
			set.add(ran.nextInt(25)+1);
		}
		int[][] bingo = new int[5][5];
		
		Iterator<Integer> itr = set.iterator();
		
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				bingo[i][j] = itr.next();
				System.out.print(bingo[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
