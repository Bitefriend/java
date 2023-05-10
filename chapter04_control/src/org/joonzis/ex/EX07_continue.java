package org.joonzis.ex;

import java.net.MulticastSocket;

public class EX07_continue {
	public static void main(String[] args) {
		
		//1. 1~10 출력(while) (3의 배수는 제외)
		
		int num = 0;
		
		while(num<10 ) {
			num++;
			
			if(num % 3 != 0) {
				
			}
			
			System.out.println(num);
			
			
		}
		
		//2. 1~10 출력 (for) (3의 배수 제외)
		
		for (int i = 1; i<=10; i++) {
			if(i%3==0) {
				continue;
			}
			System.out.println(i);
			
		}
		
		
		
	}

}
