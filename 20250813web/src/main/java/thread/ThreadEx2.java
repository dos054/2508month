package thread;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ThreadEx2 {

	public static void main(String[] args) {		//메인스레드
		Thread th =new Thread(new BeepTask());
		th.start();	//새로운 스레드 시작
		th.run(); 	//새로운 스레드 시작
		
		
		
		for(int i= 0; i<5; i++) {
			System.out.println("삐");
			try {
				Thread.sleep(500);	//1초 지연 1000ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
