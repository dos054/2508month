package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Student {
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	
}

public class StreamEx2 {
	public static void main(String[] args) {
//		List<Student> list1 = new ArrayList<>();
//		list1.add(new Student("홍길동",90));
//		list1.add(new Student("김하나",80));
//		list1.add(new Student("김자바",100));
		
		List<Student> list = Arrays.asList(new Student("홍길동",94),new Student("김하나",89),new Student("김자바",85));
		
//		for (Student stu : list) {
//			System.out.println(stu);
//		}
		
		
//		Stream<String> stream = list.stream();
		list.stream().forEach(n -> System.out.println(n));
		double avg = list.stream().mapToInt(Student :: getScore).average().getAsDouble();
		System.out.println(avg);
	}
	

}
