package org.joonzis.DI_2;

public class SamsungTV implements TV{
	
	 		
		public SamsungTV() { 
		  System.out.println("--> SamSungTV 객체 생성");
		  }


		   public void powerOn() {
		      System.out.println("--> SamSungTV 전원 키기");
		   }

		   public void powerOff() {
		      System.out.println("--> SamSungTV 전원 끄기");
		   }

		   public void volumeUp() {
		      System.out.println("--> SamSungTV 볼륨 올리기");
		   }

		   public void volumeDown() {
		      System.out.println("--> SamSungTV 볼륨 내리기");
		   }
}
