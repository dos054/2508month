package Student;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("1234","홍길동");
		Student s2 = new Student("1234","홍길동");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		if(s1.equals(s2)) {
			System.out.println("같은 객체");
		}else {
			System.out.println("다른 객체");
		}
	}

}
