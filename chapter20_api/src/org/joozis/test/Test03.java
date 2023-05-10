package org.joozis.test;



//Q3. Test03. java							
//
//Coordinate 클래스				필드 : int x, int y;
//							메소드 : Constructor, equals()							
//Circle 클래스					필드 : Coordinate center, double radius	
//							메소드 : Constructor, equals()	
//new Circle(0, 0, 1.5) // 중심 좌표[0,0], 반지름 : 1.5	

class Coordinate{
	private int x, y;
	public Coordinate() {}
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "[중심좌표] : " + x+","+y;
	}
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Coordinate) {
			Coordinate an = (Coordinate)obj;
			return x== an.x && y == an.y;
		}else {
			return false;
		}
	}
}
class Circle {
	private Coordinate center;
	private double radius;
	public Circle() {}
	public Circle(Coordinate center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	public String toString() {
		return "반지름 : " + radius;
	}
    public boolean equals(Object obj) {
		if(obj != null && obj instanceof Circle) {
			Circle ac = (Circle) obj;
			return center.equals(ac.center) && radius == ac.radius;
		}else {
			return false;
		}
	}
}
public class Test03 {
	public static void main(String[] args) {
		
		Circle co = new Circle(new Coordinate(0, 0), 1.5);
		Circle c2 = new Circle(new Coordinate(0, 0), 1.5);
		
		
		System.out.println("----참조-----");
		if(co == c2) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		System.out.println("----equals-----------");
		if(co.toString().equals(c2.toString())) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		System.out.println(co.toString());
		System.out.println(co.toString());
	}

}
