package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}
public class ExceptionTest {
	public static int inputNumber() throws InputMismatchException, MyException{ 
		Scanner sc = new Scanner(System.in);
		System.out.println("입력>");
		int num = sc.nextInt();
		if (num <0) throw new MyException("입력값은 0보다 커야 합니다.");
		return num;
	}

	public static void main(String[] args) {
		try {
			int num = inputNumber();
			System.out.println(num);
		}catch (InputMismatchException e) {
			System.out.println("입력 오류입니다, 정수를 입력해 주세요");
		}catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}

}
