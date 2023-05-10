package org.joozis.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

//Q1. Test01.java
//nationalAnthem 데이터 파일을 읽어들여 화면에 출력하고,
//nationalAnthem2.txt 파일명으로 복사하는 프로그램 작성
public class Test01 {
	public static void main(String[] args) throws IOException {
		
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		file = new File("nationalAnthem.txt");
		fr = new FileReader(file);
		br = new BufferedReader(fr);
			
		BufferedInputStream bis = 
				new BufferedInputStream((new FileInputStream(file)));
		BufferedOutputStream bos = 
				new BufferedOutputStream((new FileOutputStream("nationalAnthem2.txt")));
			
		System.out.println("파일명 : " + file.getName());
		System.out.println("파일경로 : " + file.getAbsolutePath());			
		System.out.println("파일경로2 : " + file.getPath()); 
			
		String line = "";
		while (true) {
			line = br.readLine();
			if(line != null) {
				System.out.println(line);
			}else {
				break;
			}
		}
		
		
		br.close();
		fr.close();
		bos.close();
		bis.close();
	}
}
