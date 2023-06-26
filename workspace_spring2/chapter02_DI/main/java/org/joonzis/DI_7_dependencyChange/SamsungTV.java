package org.joonzis.DI_7_dependencyChange;

public class SamsungTV implements TV{	
	
		// SamsungTV 클래스의 볼륨 조절 기능을 SonySpeaker 클래스를 이용
		private Speaker Speaker;
		private String price;
		
		public SamsungTV() { 
		  System.out.println("--> SamSungTV(1) 객체 생성");
		  }
		public SamsungTV(Speaker speaker) { 
			System.out.println("--> SamSungTV(2) 객체 생성");
			this.Speaker = speaker;
		}
		public SamsungTV(Speaker speaker, String price) { 
			System.out.println("--> SamSungTV(3) 객체 생성");
			this.Speaker = speaker;
			this.price = price;
		}
	

		@Override	
		public void powerOn() {
		      System.out.println("--> SamSungTV 전원 키기(가격 : " + price + ")");
		   }
		@Override
		public void powerOff() {
		      System.out.println("--> SamSungTV 전원 끄기");
		   }
		@Override
		public void volumeUP() {
			Speaker.volumeUP();
		   }
		@Override
		public void volumeDown() {
			Speaker.volumeDown();
		   }
}
