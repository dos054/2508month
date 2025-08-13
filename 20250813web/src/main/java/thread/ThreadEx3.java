package thread;

public class ThreadEx3 {

	public static void main(String[] args) {
		Thread th = new BeepTask2();
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
