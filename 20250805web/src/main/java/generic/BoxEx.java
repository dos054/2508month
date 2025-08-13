package generic;

class Apple{}

public class BoxEx {

	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		box.set("홍길동");
		String name = (String) box.get();
		System.out.println(name);

		Box<Apple> box2 = new Box();
		box2.set(new Apple());
		Apple apple =box2.get();
		
		
	}

}
