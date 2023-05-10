package org.joonzis.test;

public class Test_OperMain {
	public static void main(String[] args) {
		Test_Oper r1 = new Test_Oper ();
	    r1.plusSet(5, 5);
	    r1.val1 = 50;
	    r1.val2 = 20;
	    
	    r1.minus();
	    r1.multi();
	    System.out.println(r1.div());
	    
	}

}
