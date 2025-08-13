package sec03.exam02;

public class SoundableEx {
	
	private static void printSound(Soundable soundable) {	//매개변수 다형성
		System.out.println(soundable.sound());
	}

	public static void main(String[] args) {
		printSound(new Dog());
		printSound(new Cat());

	}

}
