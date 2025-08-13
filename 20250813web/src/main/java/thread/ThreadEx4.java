package thread;

import java.util.stream.IntStream;

public class ThreadEx4 {

	public static void main(String[] args) {
		Thread th =new Thread(new Runnable() {
			
			@Override
			public void run() {
				IntStream.rangeClosed(1,5).forEach((i)-> {
					System.out.println("띵"+i);
					try {
						Thread.sleep(500);	//1초 지연 1000ms
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
			}
		});
		th.start();
		
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
