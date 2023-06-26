package org.joonzis.DI_7_dependencyChange;

public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("--> SonySpeaker 객체 생성");
	}
	public void volumeUP() {
		System.out.println("--> SonySpeaker 소리 올린다.");
	}
	public void volumeDown() {
		System.out.println("--> SonySpeaker 소리 내린다");
	}
}
