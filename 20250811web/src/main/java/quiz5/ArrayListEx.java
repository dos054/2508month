package quiz5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Student.Student;



public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i>3; i++) {
			System.out.println((i+i) +"학번을 입력하시오>");
			String sno = sc.nextLine();
			System.out.println((i+i)  +"이름을 입력하시오>");
			String name = sc.nextLine();
			
			list.add(new Student(sno,name));
			
			
		}
		for(Student stu : list) {
			System.out.println(stu);
		}
	}
}
