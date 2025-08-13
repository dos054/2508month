package thread;

public class BeepTask implements Runnable{

	@Override
	public void run() {
		for(int i= 0; i<5; i++) {		//스레드
			System.out.println("띵");
			try {
				Thread.sleep(500);	//1초 지연 1000ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
