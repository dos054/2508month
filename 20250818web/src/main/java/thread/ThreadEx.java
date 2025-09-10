package thread;

class Task2 extends Thread{

	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Task1 implements Runnable{
	
	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println("삐");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadEx{

	public static void main(String[] args) {
//		Thread th = new Thread(new Task1());
//		Thread th = new Task2();
		Thread th = new Thread(
				
				new Runnable() {
					@Override
					public void run() {
						for (int i=0; i<5; i++) {
							System.out.println("삐");
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
		
		
		
		th.start();
		
		for (int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
