package org.joozis.test;


interface Proveidable{
	void sightseeing();
	void leisure();
	void food();
}

class KoreaTour implements Proveidable{
	@Override
	public void sightseeing() {
		System.out.println("한강");
	}
	@Override
	public void leisure() {
		System.out.println("쀼");
	}
	@Override
	public void food() {
		System.out.println("김치");
	}
	
}
class GuamTour implements Proveidable{

	@Override
	public void sightseeing() {
		System.out.println("안가봄");
	}

	@Override
	public void leisure() {
		System.out.println("안가");
	}

	@Override
	public void food() {
		System.out.println("봄");
	}
	
}

class TourGuide{
	Proveidable tour ;
	
	public TourGuide() {}
	public TourGuide(Proveidable tour) {
		this.tour = tour;
	}
	void sightseeing() {
		tour.sightseeing();
	}
	void leisure() {
		tour.leisure();
	}
	void food() {
		tour.food();
	}
	}


public class Test02 {
	public static void main(String[] args) {
		Proveidable pr = new KoreaTour();
		System.out.println("한국 여행 갈 곳");
		
		
		pr.sightseeing();
		pr.food();
		pr.leisure();
		
		System.out.println("=================================");
		
		System.out.println("괌 여행 갈 곳");
		
		Proveidable pr2 = new GuamTour();
		
		pr2.sightseeing();
		pr2.food();
		pr2.leisure();
		
		TourGuide tour1 = new TourGuide(new KoreaTour());
		
		tour1.sightseeing();
		tour1.food();
		tour1.leisure();
		
	}

}
