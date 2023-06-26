package org.joonzis.DI_5_constructor;

public class SamsungTV implements TV{	
	
		// SamsungTV 클래스의 볼륨 조절 기능을 SonySpeaker 클래스를 이용
		private SonySpeaker sonySpeaker;
		
		public SamsungTV() { 
		  System.out.println("--> SamSungTV(1) 객체 생성");
		  }
		public SamsungTV(SonySpeaker speaker) { 
			System.out.println("--> SamSungTV(2) 객체 생성");
			this.sonySpeaker = speaker;
		}
		
		
		
		@Override	
		public void powerOn() {
		      System.out.println("--> SamSungTV 전원 키기");
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
