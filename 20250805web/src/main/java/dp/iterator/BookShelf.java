package dp.iterator;

import java.util.Iterator;

public class BookShelf implements Iterable<Book>{
	private Book[] books;	//도서 배열
	private int last = 0;	//배열의 인덱스
	
	public BookShelf(int maxsize) {	//배열 생성
		this.books=new Book[maxsize];
	}
	
	public Book getBookAt(int index) {	//책 가져오기
		return books[index];
	}
	
	public void appendBook(Book book) {	//책 추가하기
		this.books[last] = book;
		last++;
	}

	public int getLength() {	//지정된 책의 수량
		return last;
	}

	@Override
	public Iterator<Book> iterator() {
		return new BookShelfIterator(this);
	}
	

}
