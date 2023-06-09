package org.joonzis.ex;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Ex02_json {
	public static void main(String[] args) {
		
		// 자바 스크립트 객체 배열
		// [{....}, {....}]
		
		// 예시
		// [{"name":"김", "age":20,}, {"name":"박", "age":50}]
		
		String jsonMsg = "[{\"name\":\"김\", \"age\":20,}, {\"name\":\"박\", \"age\":50}]";
		
		JSONParser parser = new JSONParser();
		JSONArray list = null;
		
		try {
			list = (JSONArray)parser.parse(jsonMsg); // 복수 JSON 객체 변환
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//JSON 배열로 변환된 list는 자바의 List를 구현한 상태
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}
}
