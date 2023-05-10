package org.joozis.ex;
class Box{
	private Object obj;
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
class Ballpen{}
class Pencil{}
public class Ex01_Generic {
	public static void main(String[] args) {
		Box box = new Box();
		
		box.setObj(new Ballpen());
		Ballpen myPen = (Ballpen)box.getObj(); // 볼펜 가져오려면 캐스팅 필요
		System.out.println(myPen);
		
		box.setObj(new Pencil());
		Pencil myPencil = (Pencil)box.getObj();
		System.out.println(myPencil);
	}

}
