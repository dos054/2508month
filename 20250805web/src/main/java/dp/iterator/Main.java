package dp.iterator;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("80일간의 세계일주"));
		bookShelf.appendBook(new Book("Bible"));
		bookShelf.appendBook(new Book("신데렐라"));
		bookShelf.appendBook(new Book("장발장"));
		
//		Iterator<Book> it = bookShelf.iterator();	//이터레이터 생성
//		while(it.hasNext()) {	//다음 책이 있나?
//			Book book = it.next();		//책 가져오기
//			System.out.println(book.getName());
//		}
//		System.out.println();

		
		for (Book book : bookShelf) {
			System.out.println(book.getName());
		}
		
	}

}
