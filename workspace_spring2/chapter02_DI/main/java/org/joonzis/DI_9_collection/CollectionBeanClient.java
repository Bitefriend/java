package org.joonzis.DI_9_collection;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("applicationContext9.xml");
		//List 객체 가져오기
		CollectionBean bean1 = ctx.getBean("cBean1", CollectionBean.class);
		List<String> list = bean1.getAddressList();
		for(String address : list) {
			System.out.println(address);
		}
		System.out.println("---------------------------------------");
		
		//set 객체 가져오기
		CollectionBean bean2 = ctx.getBean("cBean2", CollectionBean.class);
		Set<String> set = bean2.getAddressSet();
		Iterator<String> itr = set.iterator();
		
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
			
		System.out.println("---------------------------------------");
		
		//Map 객체 가져오기
		CollectionBean bean3 = ctx.getBean("cBean3", CollectionBean.class);
		Map<String, String> map = bean3.getAddressMap();
		set = map.keySet(); // 키뭉치
		itr = set.iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			String value = map.get(key);
			System.out.println("key : " + key + ", value : " + value);
		}
		
		ctx.close();
		
		
	}
	
}
