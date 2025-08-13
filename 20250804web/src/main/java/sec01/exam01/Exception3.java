package sec01.exam01;

public class Exception3 {
	public static void method() throws ClassNotFoundException{
		Class.forName("ajhwpgrlp");
	}

	public static void main(String[] args) {
		try {
			method();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
