package sec01.exam04;

public class MyClass {
	RemoteControl rc = new Television();

	MyClass(){
		
	}
	
	public MyClass(RemoteControl rc) {
		this.rc =rc;
		rc.turnOn();
		rc.setVolume(5);
	}

	void methodA() {		//지역변수
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
	}
	
	void methodB(RemoteControl rc) {	//매개변수의 다형성
		rc.turnOn();
		rc.setVolume(5);
	}
}
