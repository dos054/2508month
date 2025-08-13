package sec01.exam01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class HashSetEx {

	public static void main(String[] args) {
		Set<String> list = new HashSet<String>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add("Database");
		list.add("iBATIS");
		
		int size = list.size();
		System.out.println("총 객체 수: "+size);
		System.out.println();
		
		Iterator<String> it = list.iterator();	//반복자
		while(it.hasNext()) {
			System.out.println(it.next());	//값을 찍을수있다.
		}
		
		System.out.println();
		for(String str : list) {
			System.out.println(str);
		}
		
		
	}

}
