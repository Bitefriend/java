package org.joonzis.ex;

import java.util.Scanner;

public class Ex02_Student_Main {
	public static void main(String[] args) {
		Ex02_student st = new Ex02_student("김아무개", "구트");
		st.input(new Scanner(System.in));
		st.output();
	}

}
