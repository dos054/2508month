package sec01.exam04;

public class RemoteControlEx {
	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
//		rc = new Audio();
//		rc = new Video();		//익명이 아닌 구현 객체
//		rc = new RemoteControl() {};  //익명의 구현 객체 생성
			

		
			
		
		
		rc.turnOn();
		rc.setVolume(3);
		rc.turnOff();
	}

}
