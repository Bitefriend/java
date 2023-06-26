package org.joonzis.DI_10_annoConfig;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// sts 버전3 에서 사용시 해당 프로젝트에 CGLIB 라이브러리 추가

@Configuration // applicationContext와 같은 역할을 하는 자바 클래스
public class AnnoConfig {
	@Bean // Bean을 만드는 어노테이션
	public Person human1() { // <bean id ="human1" class = "org.joonjis.DI_10_annoConfig.Person">
		Set<String> hobbies = new HashSet<String>();
		hobbies.add("여행");
		hobbies.add("잠자기");
		hobbies.add("청소");
		
		Person person = new Person();
		person.setName("김씨");
		person.setAge(10);
		person.setHobbies(hobbies);
		
		return person;
	}
	@Bean(name = "human2")
	public Person abc() {
		Set<String> hobbies = new HashSet<String>();
		hobbies.add("밥먹기");
		hobbies.add("음악듣기");
		hobbies.add("돌아다니기");
		
		Person person = new Person();
		person.setName("박씨");
		person.setAge(30);
		person.setHobbies(hobbies);
		
		return person;
	}
	@Bean
	public PersonInfo pInfo() {
		Set<String> hobbies = new HashSet<String>();
		hobbies.add("게임");
		hobbies.add("곤충 채집");
		hobbies.add("물고기 키우기");
		
		PersonInfo info = new PersonInfo();
		info.setPerson(new Person("최씨", 50, hobbies));
		
		return info;
	}
}
