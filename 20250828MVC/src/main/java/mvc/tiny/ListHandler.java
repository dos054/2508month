package mvc.tiny;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TinyDAO;
import dto.TinyDTO;
import mvc.command.CommandHandler;

public class ListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TinyDAO dao = new TinyDAO();
		List<TinyDTO> list = dao.selectList();
		request.setAttribute("list", list);
		
		return "/WEB-INF/view/list.jsp";
	}
}
