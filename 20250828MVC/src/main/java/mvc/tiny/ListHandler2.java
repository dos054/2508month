package mvc.tiny;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TinyDAO;
import dto.TinyDTO;
import mvc.command.CommandHandler;

public class ListHandler2 implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		return "/WEB-INF/view/insertForm.jsp";
	}
}
