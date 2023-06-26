package org.joonzis.DI_8_set;

public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("--> HomePod");
	}
	@Override
	public void volumeUP() {
		System.out.println("--> Apple volumeUP");
	}
	@Override
	public void volumeDown() {
		System.out.println("--> Apple volumeDown");
	}
}
