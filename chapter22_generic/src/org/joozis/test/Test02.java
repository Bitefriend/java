package org.joozis.test;
//Q2. Test02.java
//
//정수/실수 타입의 배열을 전달하면 해당 배열에 저장된 모든 요소의 합을 리턴하는 sum() 메소드를 구현하시오.
//예) int 5개 전달하면 5개의 합 출력
//★
// - static <T extends Number> double sum(T[] arr)  형식 작성
// 	-> Number 형태의 데이터만 가능하다는 의미(int, long, float, double, byte, short)
// - 배열의 값을 가져올때 배열.doubleValue()사용
// 	-> 배열인덱스.doubleValue()
public class Test02 {
	
	static <T extends Number> double sum(T[] arr) {
		
		double total = 0;
		for (int i = 0; i < arr.length; i++) {
			total+= arr[i].doubleValue();
		}
		return total;
	}
	
	public static void main(String[] args) {
		Integer[] arr1 = {123,456,789};
		Double[] arr2 = {1.5,2.5};
		String[] arr3 = {"hello", "java"};
		
		System.out.println(sum(arr1));
		System.out.println(sum(arr2));
		//System.out.println(sum(arr3));  //상속받은 얘들만 가능함
	}

}
