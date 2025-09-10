package com.du;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/")) {
			
			
			request.setAttribute("aaa", LocalDateTime.now());	//forwarding 하기전 데이터 정하기
			view = "main.jsp";		//forwarding 데이터 넘겨주면서 페이지 옮기기
		}else if(com.equals("/b")) {
			String str = request.getParameter("val");
			System.out.println(str);
			request.setAttribute("val", str);
			view="b.jsp";
		}else if(com.equals("/c")) {
			String str = request.getParameter("nn"); 	//main.jsp에서 form태그에서 nn이라고 정해둔 값을 가져오는법
			System.out.println(str);
			request.setAttribute("res", str);
			view  = "main.jsp";
		}
			
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));	//페이지만 넘길려면 씀
		} else {
			request.getRequestDispatcher(view).forward(request, response);	//jsp에 데이터 넣기용
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
