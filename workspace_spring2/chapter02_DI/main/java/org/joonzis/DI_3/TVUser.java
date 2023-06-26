package org.joonzis.DI_3;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		//1. Spring 컨테이너 구동
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("applicationContext3.xml");
		
		//2. Spring 컨테이너로부터 필요한 객체 요청
		TV ltv = (LgTV)ctx.getBean("ltv");
		ltv.powerOn();
		ltv.powerOff();
		ltv.volumeUp();
		ltv.volumeDown();
		

		TV stv = (SamsungTV)ctx.getBean("stv");
		stv.powerOn();
		stv.powerOff();
		stv.volumeUp();
		stv.volumeDown();
	}
	
}
