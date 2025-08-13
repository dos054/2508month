package nested;

public class A1 {
	int field1;
	void method1() {}
	
	static class B{
		void method() {

		}
	}
	
	class C{}
	public static void main(String[] arg) {
		A1.B b1 =new A1.B();	//중첩된 클래스가 static일때
		A1.C c1 = new A1().new C();		//중첩된 클래스가 기본일때
	}
}
