package org.joonzis.ex;

import java.util.Arrays;

public class Ex01_premitive_array {
	public static void main(String[] args) {
		//초기화와 선언은 별개
		// Ex) int = a; (선언) a = 3; (초기화) int a = 3(선언 및 초기화)
		
		
		//정수형 arr1이라는 배열명, 크기는 3으로 선언
		
		int[] arr1 = new int[3]; // 인덱스 0,1,2
		
		// 정수형 arr2 배열명, 값은 10, 20, 30으로 초기화
		int[] arr2  = {10, 20, 30};
		arr1[2] = 2;
		System.out.println(arr2);
		
		// 배열 내 데이터 확인
		// 1. Arrays.toString() 메소드 사용
		//    값만 확인 용도
		System.out.println(Arrays.toString(arr1));
		
		// 2. 모든 인덱스 접근 ★★★ (반복문)
		//    값을 저장하거나 , 가져오기 가능
	
		
		for (int i = 0; i <arr1.length; i++) {
			arr1[i] = 1;
			System.out.println(arr1[i]);  
		}
		// 인덱스 범위를 벗어난 요소(예외 발생)
		System.out.println(arr1[3]);
		
		
	}

}
