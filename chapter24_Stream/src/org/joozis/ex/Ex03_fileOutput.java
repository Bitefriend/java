package org.joozis.ex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex03_fileOutput {
	public static void main(String[] args) {
		String msg = "가나다라마바사아자차카타파하"; // scanner를 이용하여 받은 내용 저장가능
		
		//문자기반 스트림(파일 작성 시 주로 사용)
		File file = null;
		FileWriter fw = null;  // OutputStreamWriter 상속
		BufferedWriter bw = null; // Writer 클래스 상속
		// 저용량의 파일 시 FileWriter만 사용해도 무방
		
		try {
			file = new File("hangeul.txt");
			fw = new FileWriter(file, false);   
			// true : 이어쓰기, false : 덮어쓰기
			bw = new BufferedWriter(fw);
			bw.write(msg);
			bw.flush();
			System.out.println("hangeul.txt 파일을 생성했습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) {bw.close();}
				if(fw != null) {fw.close();}
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
