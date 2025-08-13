package ramda;

public class Main {

	public static void main(String[] args) { 
		functionalInterface fi = (a) -> {
            System.out.println("anyMethods() " + a);
        };
		fi.anyMethods("hello");
	}

}
