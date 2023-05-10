package org.joozis.test;

interface Computable {
	public void connectInternet();

	void receiveCall();
}

class Phone {
	String owner;

	public Phone() {
	}

	public Phone(String owner) {
		super();
		this.owner = owner;
	}

	public void sendCall() {

	}

	public void receiveCall() {

	}
}

class SmartPhone extends Phone implements Computable {

	@Override
	public void connectInternet() {

	}

	@Override
	public void receiveCall() {

	}

}

public class Test01 {
	public static void main(String[] args) {

	}

}
