package sec01.exam01;

public class MyException extends Exception{
	public static void check(int weight) throws MyException {
		if(weight >100) {
			throw new MyException("과체 중 입니다.");
		}
	}
	
	public MyException(String msg) {
		try {
			check(101);
		} catch (MyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
