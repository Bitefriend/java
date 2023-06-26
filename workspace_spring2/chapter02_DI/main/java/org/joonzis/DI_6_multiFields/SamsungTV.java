package org.joonzis.DI_6_multiFields;

public class SamsungTV implements TV{	
	
		// SamsungTV 클래스의 볼륨 조절 기능을 SonySpeaker 클래스를 이용
		private SonySpeaker sonySpeaker;
		private String price;
		
		public SamsungTV() { 
		  System.out.println("--> SamSungTV(1) 객체 생성");
		  }
		public SamsungTV(SonySpeaker speaker) { 
			System.out.println("--> SamSungTV(2) 객체 생성");
			this.sonySpeaker = speaker;
		}
		public SamsungTV(SonySpeaker speaker, String price) { 
			System.out.println("--> SamSungTV(3) 객체 생성");
			this.sonySpeaker = speaker;
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
		public void volumeUp() {

			sonySpeaker.volumUp();
		   }
		@Override
		public void volumeDown() {

			sonySpeaker.volumDown();
		   }
}
