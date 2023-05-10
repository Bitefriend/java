package org.joozis.test;
//Q2. Test02.java
//User 클래스 					필드 : String id, password
//							메소드 : Constructor, toString(), equals()
//User 인스턴스를 2개 생성하고, 동등 비교(id, password 모두 같으면 동등) 결과 출력
//각 인스턴스 정보는 toString 메소드를 통해 출력	
class User{
	String id, password;
	public User() {}
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	@Override
	public String toString() {
		return "아이디 : " + id + "비밀번호 : " + password;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof User) {
			User an = (User)obj;
			return id.equals(an.id) && password == an.password;
		}else {
			return false;
		}
		
	}
}
public class Test02 {
	public static void main(String[] args) {
		User co = new User("뿌잉", "123456");
		User co2 = new User("뿌잉", "123456");
		
		System.out.println("----참조-----");
		
		if(co==co2) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
		System.out.println("----equals-----");
		
		if(co.equals(co2)) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
	}

}
