package org.joonzis.test;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//Q5. Test05.java		
//Up-Down 게임
//1 ~ 100 사이의 난수를 발생시켜 해당 값을 맞출때까지 게임을 진행하시오.
//다음의 경우 예외를 발생시키시오.
//1) 사용자가 1 ~ 100 이외의 값을 입력한 경우 NumberOutOfBoundsException 클래스를 이용하여 예외 처리
//2) 정수대신 다른 데이터 (예: 실수, 문자) 등을 입력한 경우
class NumnerOutOfBoundsException extends Exception{
	public NumnerOutOfBoundsException(String msg) {
		super(msg);
	}
	
}
class Updown{
	private int answer;
	private int count;
	private Scanner sc = new Scanner(System.in);
	public Updown() {
		Random ran = new Random();
		answer = ran.nextInt(100)+1;
	}
	public int challenge() throws NumnerOutOfBoundsException, InputMismatchException{
		count++;
		System.out.println("1~100사이 정수 값 입력");
		int num = sc.nextInt();
		
		if(num < 1 || num > 100 ) {
			throw new NumnerOutOfBoundsException("1~에서 100사이를 입력해");
		}
		return num;
	}
	public void play() {
		while(true) {
			try {
				int num = challenge();
				if(num > answer) {
					System.out.println("Down");
				} else if(num < answer) {
					System.out.println("UP");
				} else {
				    System.out.println("정답 : " + answer + "(" + count + "회만에 성공!)");
				    break;
				}
			} catch (NumnerOutOfBoundsException e) {
				System.out.println(e.getMessage());
			} catch(InputMismatchException e) {
				System.out.println("정수 입력하라고");
				sc.next();
			}
		}
		
	}
	
}
public class Test04 {
	public static void main(String[] args) {
		Updown game = new Updown();
		game.play();
		
	}

}
