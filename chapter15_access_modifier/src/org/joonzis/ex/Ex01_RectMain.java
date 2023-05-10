package org.joonzis.ex;

public class Ex01_RectMain {
	public static void main(String[] args) {
		Ex01_Rect re = new Ex01_Rect(5,5);
		re.output();
		System.out.println("---------------------------");
		Ex01_Rect r1 = new Ex01_Rect(5,6);
		r1.output();
		System.out.println("---------------------------");
		Ex01_Rect r2 = new Ex01_Rect();
		r2.output();
	}

}
