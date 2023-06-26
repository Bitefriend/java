package org.joonzis.DI_1;

public class TVUser {
	public static void main(String[] args) {
		LgTV ltv = new LgTV();
		ltv.powerOn();
		ltv.powerOff();
		ltv.volumeUp();
		ltv.volumeUff();
		
		System.out.println("-----------------------------");
		
		SamsungTV stc = new SamsungTV();
		
		stc.powerOn();
		stc.powerOff();
		stc.volumeUp();
		stc.volumeUff();
		
								
		
	}
}
