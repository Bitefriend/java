package org.joonzis.test;

public class Ex03_test {
	public static void main(String[] args) {
//		Test03.java
//		Q. Test02.java 의 값들을 모두 더하고, 총점과 평균을 출력
		
		int num = 0;
		int[] arr = {10, 20, 50, 60, 13, 25, 97};
		
		
    	for (int  i= 0; i < arr.length; i++) {
			num += arr[i];
			
    	}
    	System.out.println(num);
    	
    	// 평균구하기
    	double avg = (double) num / arr.length;
    	System.out.println("평균" + avg);
	}

}
