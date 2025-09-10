package thread;

public class ThreadEx2{
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());
		
		Thread threadA = new ThreadA();
		System.out.println(threadA.getName());
		threadA.start();
		
		Thread threadB = new ThreadB();
		System.out.println(threadB.getName());
		threadB.start();
	}
}
