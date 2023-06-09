package org.joonzis.service;

public class LanguageServiceImap implements LanguageService{
	
	@Override
	public String executeEnglish() {
		return "Hello";
	}
	@Override
	public String executeHangeul() {
		return "안녕";
	}

}
