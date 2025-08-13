package thread;

public class ThreadEx {

	public static void main(String[] args) {
		for(int i= 0; i<5; i++) {
			System.out.println("삐");
			try {
				Thread.sleep(500);	//0.5초 지연 500ms
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
