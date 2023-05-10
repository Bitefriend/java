package org.joozis.test;
//Q4. Test04.java
//interface Car					메소드 : info();
//class Bus implements Car
//class CityTourBus extends Bus
//class SeoulBus extends Bus
//class Taxi implements Car
//Class Bicycle
//Class Test04					메소드 : static <T extends Car> void onlyCar(T car) 
// - CityTourBus, SeoulBus, Taxi 정보 출력
interface Car{
	public void info();
}
class Bus implements Car{
	@Override
	public void info() {
		System.out.println("버스");
	}
}
class CityTourBus extends Bus{
	@Override
	public void info() {
		System.out.println("시티투어 버스");

	}
}
class SeoulBus extends Bus{
	@Override
	public void info() {
		System.out.println("서울 버스");

	}
}
class Taxi implements Car{
	@Override
	public void info() {
		System.out.println("택시");
	}
	
}
class Bicycle{}

public class Test04 {
	static <T extends Car> void onlyCar(T car) {
		car.info();
	}
	public static void main(String[] args) {
		Car bus1 = new CityTourBus();
		Car bus2 = new SeoulBus();
		Car taxi = new Taxi();
		
		onlyCar(bus1);
		onlyCar(bus2);
		onlyCar(taxi);
	}
}
