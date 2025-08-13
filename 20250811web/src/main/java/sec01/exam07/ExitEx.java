package sec01.exam07;

public class ExitEx {

	public static void main(String[] args) {
		int x = 100;
		Integer y = 200;
		int z = 0;
		z=x + y;
		System.out.println(z);
		
		String s1 ="JAVA";
		String s2 ="java";
		System.out.println(s1.equalsIgnoreCase(s2));
		
		String s3 = "               art               ";
		System.out.println(s3.trim());
		
		
		String ssn = "123456789";
		System.out.println(ssn.substring(0,6));
		
		System.out.println(ExitEx.class.getName());
		for (int i=0; i<10; i++) {
			if (i==5) {
				System.exit(0);
//				break;
			}
		}
		System.out.println("종료");
	}

}
