package thread;

public class BeepTask2 extends Thread{

	@Override
	public void run() {
		for(int i= 0; i<5; i++) {
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
