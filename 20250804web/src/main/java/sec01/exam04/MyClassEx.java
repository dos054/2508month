package sec01.exam04;

public class MyClassEx {

	public static void main(String[] args) {
		System.out.println("1)----------------");
		
		MyClass myClass1 = new MyClass();		//
		myClass1.rc.turnOn();
		myClass1.rc.setVolume(5);
		
		System.out.println("2)----------------");
		MyClass myClass2 = new MyClass(new Audio());	//

		System.out.println("3)----------------");
		
		MyClass myClass3 = new MyClass();	//지역변수
		myClass3.methodA();
		
		System.out.println("4)----------------");
		
		MyClass myClass4 = new MyClass();	//매개변수의 다형성
		myClass4.methodB(new Television());
		
		
	}

}
