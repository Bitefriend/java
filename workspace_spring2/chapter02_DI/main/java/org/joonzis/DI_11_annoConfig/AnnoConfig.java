package org.joonzis.DI_11_annoConfig;

import java.util.ArrayList;


import org.springframework.context.annotation.Bean;

public class AnnoConfig {
	@Bean
	public Person human11() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("여행");
		hobbies.add("영화");
		hobbies.add("드라마");
		
		Person per = new Person();
		per.setName("김");
		per.setHeight(188);
		per.setHobbies(hobbies);
		
		return per;
		
		
	}

}
