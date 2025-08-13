package sec01.exam04;

public class Video implements RemoteControl{
private int volume;
	
	@Override
	public void turnOn() {
		System.out.println("Video를 켭니다.");
		
	}

	@Override
	public void turnOff() {
		System.out.println("Video 를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume=volume;
		}
		System.out.println("현재 Video  볼륨 : " +this.volume);
	}
}
