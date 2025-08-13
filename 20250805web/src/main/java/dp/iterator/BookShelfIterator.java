package dp.iterator;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book>{

	private BookShelf bookShelf; 	//책장(도서 저장)
	private int index;
	
	public BookShelfIterator(BookShelf bookShelf) {	//책장 초기화
		this.bookShelf = bookShelf;
		this.index=0;
	}
	
	
	@Override
	public boolean hasNext() {
		if ( index < bookShelf.getLength()) {	//다음 책이 있니?
			return true;
		} else {
			return false;	
		}
	}

	@Override
	public Book next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		Book book = bookShelf.getBookAt(index);		//해당 인덱스의 책을 가져오기
		index++;
		return null;
	}

}
