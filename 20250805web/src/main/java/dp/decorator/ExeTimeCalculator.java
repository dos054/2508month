package dp.decorator;

public class ExeTimeCalculator implements Calculator{
	
	private Calculator delegate;	//인터페이스 타입
	
	
	public ExeTimeCalculator(Calculator delegate) {	//매개변수의 다형성
		super();
		this.delegate = delegate;
	}

	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		
		long result = delegate.factorial(num);
		
		long stop = System.nanoTime();
		System.out.println(stop-start + "나노초");
		return result;
	}

}
