package com.du;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MoveTest
 */
@WebServlet("/test")
public class MoveTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();	//uri 가져오기
		System.out.println(uri);
		String conPath = request.getContextPath();	//path만 가져오기
		System.out.println(conPath);
		String com = uri.substring(conPath.length());	//문자열 자르기 
		System.out.println(com);
		
		request.setAttribute("name", "홍길동");
		
		if(com.equals("/test/a") || com.equals("/test/")) {		//a나 라면 a.jsp가고 포워딩하라
			request.getRequestDispatcher("a.jsp").forward(request, response);
		}else if(com.equals("/test/b")) {		//b 라면 b.jsp로 가라
			response.sendRedirect("b.jsp");
		}else {		//아니면 Invalid Access!라고 나와라
			response.getWriter().println("Invalid Access!");
			return;
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
