package org.joozis.ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05_FileCopy {
	public static void main(String[] args) throws IOException  {
		
		//FileInputStream fis = new FileInputStream("alphabet.txt");
		//BufferedInputStream bis = new BufferedInputStream(fis);
		
		// 위와 동일
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("alphabet.txt"));
		
//		FileOutputStream bos = new FileOutputStream("alphabet.txt");
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		//위와 동일
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("alphabet.txt"));
		
		int data;
		while((data = bis.read()) != -1) {
			bos.write(data);
		}
		bis.close();
		bos.close();
	}
}
