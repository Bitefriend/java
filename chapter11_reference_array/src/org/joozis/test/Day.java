package org.joozis.test;

public class Day {
	String schedule;
	public Day() {}

	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	void output() {
		if(schedule == null) {
			System.out.println("없음");
		}else {
			System.out.println(schedule);
		}
		System.out.println(schedule);
	}

}
