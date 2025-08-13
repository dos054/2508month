package Student;

import java.util.Objects;

public class Student {
//student 클래스를 만들고 학번(sno) 칼럼이 같으면 같은 객체로 판명되도록 
//Object 클래스를 재정의 한 후 테스트 하는 자바 코드를 만들어보시오

	String sno;
	String name;
	
	
	public Student(String sno, String name) {
		this.sno = sno;
		this.name = name;
	}


	@Override
	public int hashCode() {
//		return Objects.hash(name, sno);
		return sno.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		return Objects.equals(name, other.name) && Objects.equals(sno, other.sno);
		
		if(obj instanceof Student) {
			Student student = (Student) obj;
			if(sno.equals(student.sno)) {
				return true;
			}
		}
		return false;
		
	}


	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + "]";
	}

	

	


	
	
	
	
	
}
