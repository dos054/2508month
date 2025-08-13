package sec01.exam05;

import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();	//객체 생성
		
		List<Board> list = dao.getBoardList();	//list를 만들었고 제네릭은 board 
		
		for(Board board : list) {
			System.out.println(board.getTitle() + "-" + board.getContent());
		}
	}

}
