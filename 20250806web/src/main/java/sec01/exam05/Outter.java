package sec01.exam05;

public class Outter {
	String field = "Outer-field";
	void method() {
		System.out.println("Outter-method");
	}
	
	class Nested {
		String field = "Nested-field";
		void method() {
			System.out.println("Nested-method");
		}
		void print() {
			System.out.println(Outter.this.field);
			Outter.this.method();
		}
		
	}
	public static void main(String[] ar) {
		Outter.Nested nested = new Outter().new Nested();
		nested.print();
	}
}
