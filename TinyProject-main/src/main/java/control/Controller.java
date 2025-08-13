package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TinyDAO;
import dto.TinyDTO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		String uri = request.getRequestURI();		//getRequestURI() : URI를 가져오는것
		String conPath = request.getContextPath();	//getContextPath() : 프로젝트문자열만 가져옴
		String com = uri.substring(conPath.length());	//uri에 문자열중 compath문자열만 잘라서 보여줌
		
		if (com.equals("/list") || com.equals("/")) {
			TinyDAO dao = new TinyDAO();
			List<TinyDTO> list = dao.selectList();
			request.setAttribute("list", list);
			view = "list.jsp";
			
		} else if (com.equals("/insertForm")) {
			view = "redirect:insertForm.jsp";
		}else if (com.equals("/insert")) {
			String content = request.getParameter("content");
			TinyDAO dao = new TinyDAO();
			dao.insertOne(new TinyDTO(0, content));
			view = "redirect:list";
		}else if(com.equals("/delete")) {
			int num = Integer.parseInt(request.getParameter("num"));
			TinyDAO dao = new TinyDAO();
			dao.deleteOne(new TinyDTO(num,""));
			view = "redirect:list";
		}else if(com.equals("/updateForm")) {
			String num = request.getParameter("num");
			TinyDAO dao = new TinyDAO();
			TinyDTO dto = dao.selectOne(num);
			request.setAttribute("dto", dto);
			view = "updateForm.jsp";		
			
		}else if(com.equals("/update")) {
			String content = request.getParameter("content");
			int num = Integer.parseInt(request.getParameter("num"));
			TinyDAO dao = new TinyDAO();
			dao.updateOne(new TinyDTO(num,content));
			view = "redirect:list";
		}
		
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
