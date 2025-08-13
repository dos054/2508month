package sec01.exame01;

class Parent{
	void method1() {}
}
class chiled extends Parent {}
public class A {
	
	Parent field = new Parent() {
		int childField;
		void childMethod() {}
		@Override
		void method1() {
			// TODO Auto-generated method stub
			super.method1();
		}
		
	};
	

}
