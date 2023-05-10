package org.joozis.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02_iterator {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		//10, 20, 30, ....100까지 list에 저장하기
//		for (int i = 1; i <=10; i++) {
//			list.add(i*10);
//		}
		for (int i = 10; i <= 100; i=+10) {
			list.add(i);
		}
		
		
		//반복자 호출
		Iterator<Integer> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.hasNext());
		}
	}

}
