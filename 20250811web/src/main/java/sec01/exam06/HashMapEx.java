package sec01.exam06;

import java.util.HashMap;
import java.util.Map;

import Student.Student;

public class HashMapEx {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<Student, Integer>();
		map.put(new Student("1234","홍"),  100);
		map.put(new Student("1235","길"),  200);
		map.put(new Student("1234","홍1"),  300);
		
		System.out.println(map.get(new Student("1234","홍")));
		
	}

}
