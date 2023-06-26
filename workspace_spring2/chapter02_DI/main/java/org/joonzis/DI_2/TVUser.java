package org.joonzis.DI_2;

public class TVUser {
	public static void main(String[] args) {
		LgTV ltv = new LgTV();
		ltv.powerOn();
		ltv.powerOff();
		ltv.volumeUp();
		ltv.volumeDown();
		
		
		SamsungTV stv = new SamsungTV();
		stv.powerOn();
		stv.powerOff();
		stv.volumeUp();
		stv.volumeDown();
	}
	
}
