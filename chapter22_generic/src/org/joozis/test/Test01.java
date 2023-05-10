package org.joozis.test;

import java.util.Arrays;



//Q1. Test01.java
//문자/정수/실수 타입의 배열을 전달하고 데이터 타입을 체크하여
//해당 데이터 타입과 해당 배열의 데이터들을 출력
//class TypeCheckClass - 필드 : T[] arr
//   					  메소드 : String checkType(T[] arr), toString()
//                        -> 타입에 따라서 " 문자형 입니다.", "정수형 입니다" 등등 리턴
//                        , toString()
//                        -> 배열 데이터, 데이터 형태 출력
class TypeCheckClass<T>{
	private T[] arr;
	public String checkType(T[] arr) {
		this.arr = arr;
		
		if(arr instanceof String[]) {
			return "문자형 입니다";
		}else if(arr instanceof Integer[]) {
		    return" 정수형 입니다";
		}else {
			return "실수형 입니다.";
		}
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("배열 데이터 : ").append(Arrays.toString(arr)).append("\n");
		sb.append("배열 형태 : ").append(checkType(arr));
	   return sb.toString();	
	}
}
public class Test01 {
	public static void main(String[] args) {
		String[] arr1 = {"a","b","c"};
		Integer[] arr2 = {123,456,789};
		Double[] arr3 = {1.5,2.5,3.5};
		TypeCheckClass<String> ck1 = new TypeCheckClass<>();
		TypeCheckClass<Integer> ck2 = new TypeCheckClass<>();
		TypeCheckClass<Double> ck3 = new TypeCheckClass<>();
		ck1.checkType(arr1);
		ck2.checkType(arr2);
		ck3.checkType(arr3);
		
		System.out.println(ck1);
		System.out.println(ck2);
		System.out.println(ck3);
	}

}
