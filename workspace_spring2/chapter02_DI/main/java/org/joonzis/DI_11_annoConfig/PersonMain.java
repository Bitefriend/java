package org.joonzis.DI_11_annoConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		//1. AnnoConfig.java를 이용하여 Bean 객체 출력
		//2. applicationContext.xml 파일을 이용해서 Bean 객체 출력
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AnnoConfig.class);
		
		Person person1 = ctx.getBean("human11", Person.class);
		System.out.println("이름 : " + person1.getName());
		System.out.println("키 : " + person1.getHeight());
		System.out.println("취미 : " + person1.getHobbies());
		
		System.out.println("========================================");
		
		AbstractApplicationContext ctx2 = 
				new GenericXmlApplicationContext("applicationContext10.xml");
		
		Person person2 = ctx2.getBean("cBean2", Person.class);
		System.out.println("이름 : " + person2.getName());
		System.out.println("키 : " + person2.getHeight());
		System.out.println("취미 : " + person2.getHobbies());
		
	}
}
