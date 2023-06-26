package org.joonzis.DI_3;

public class LgTV implements TV{
	
	  public LgTV() { 
		  System.out.println("--> LgTV 객체 생성"); 
		  }
	 
	   public void powerOn() {
	      System.out.println("--> LgTV 전원 키기");
	   }

	   public void powerOff() {
	      System.out.println("--> LgTV 전원 끄기");
	   }

	   public void volumeUp() {
	      System.out.println("--> LgTV 볼륨 올리기");
	   }

	   public void volumeDown() {
	      System.out.println("--> LgTV 볼륨 내리기");
	   }
}
