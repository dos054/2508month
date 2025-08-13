package nested;

class B{}

public class A {
	B field1 = new B();
	void method() {
		B v1 =new B();
	}
	public class B{}
}
