package thread;

public class ThreadB extends Thread{
	public ThreadB() {
		this.setName("스레드B");
	}

	@Override
	public void run() {
		for (int i=0; i<2; i++) {
			System.out.println(this.getName());
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
