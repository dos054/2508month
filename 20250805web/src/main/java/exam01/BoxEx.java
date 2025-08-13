package exam01;

class Apple{}

public class BoxEx {

	public static void main(String[] args) {
		Box box = new Box();
		box.set("홍길동");
		String name = (String) box.get();
		System.out.println(name);

//		Box2 box2 = new Box();
//		box2.set(new Apple());
//		Apple apple =(Apple) box2.get();
		
		
	}

}
