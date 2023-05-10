package org.joozis.ex;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex02_FileInput {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			fis = new FileInputStream("alphabet.txt");
			bis = new BufferedInputStream(fis);
			
			int ch = 0; // char ch; 가 아님을 주의 ! 읽을때는 int
			
			while(true) {
				ch = bis.read(); // read()의 리턴이 int 타입
				if(ch == -1) {   // read()의 파일이 끝나면 -1을 리턴
					break;
					
				}
				System.out.println((char)ch);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(bis != null) {
					bis.close();
				}
				if(fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
