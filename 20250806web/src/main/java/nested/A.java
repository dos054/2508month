package nested;

public class A {
	class B{}
	
	static class C{}
	
	void method() {
		class D{}
		D d1= new D();		//메소드 내부의 클래스 객체 선언
		
	}
	
	
	public static void main(String[] arg) {
//		A a1 = new A();
//		B b1 = a1.new B();
		B b1 = new A().new B();		//클래스 내부의 클래스 객체 생성
		
		A.C c1 =new A.C();		//클래스 내부의 정적 클래스 객체 생성
		
		
	}
}
