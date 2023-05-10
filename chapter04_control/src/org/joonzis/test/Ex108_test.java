package org.joonzis.test;

import java.util.Scanner;

public class Ex108_test {
	public static void main(String[] args) {

//Test08.java
//Q.Up-Down 게임
//	1 ~ 100 사이에서 임의의 숫자를 하나 결정한 뒤
//	해당 숫자를 맞추는 게임
//	입력 받은 숫자의 크기에 따라 "Up!", "Down!", "Answer!" 로 나눠서 출력하고
//	맞출때까지 몇 번 진행했는지 횟수도 함께 출력
//	실행 예)
//	입력 >> 30
//	Up!
//	입력 >> 40
//	Down!
//	입력 >> 35
//	Down!
//	입력 >> 33
//	Answer!
//	총 4회만에 성공!
		Scanner sc = new Scanner(System.in);
		
		int ans = 0; // 입력변수
		int count = 0; // 횟수
		int result = 77; // 정답
		
		while (true) {
			System.out.println("1~100 사이 정수 입력.");
			ans = sc.nextInt();
			
			count ++;
			
			if(ans > result) {
				System.out.println("Down!");
			}else if(ans < result) {
				System.out.println("Up!");
			}else {
				System.out.println("Answer!");
				System.out.println(count + "회만에 성공!");
				break;
			}
			
		}
		
		sc.close();
	}

}
