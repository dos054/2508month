package sec01.exam011;

public class A {
	class B{}
	static class C{}
	void method() {
		class D {
			int field1;
			static int filed2;
		}
		D d1= new D();
		d1.field1=700;
//		D.field2=100;
	}
}
