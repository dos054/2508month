package com.du;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();		//세션이 있으면 가져오고 없으면 만들어 준다
		if (com.equals("/") || com.equals("/main")) {
			String userId = (String) session.getAttribute("userId");
		    if (userId != null) {
		    	view = "loginOk.jsp";
		    } else {
		    	view = "redirect:loginForm.jsp";
		    }
			
		} else if(com.equals("/login")) {
			
			String id = request.getParameter("id");
		    String pw = request.getParameter("pw");

		    if (id.equals("admin") && pw.equals("1234")) {
		    	session.setAttribute("userId",   id     );		//세션 생성
		        session.setAttribute("userName", "관리자");
		        
		        view = "loginOk.jsp";
		    } else {
		    	view = "redirect:loginFail.jsp";
		    }
		    
		    
		} else if(com.equals("/logout")) {
			session.invalidate();   //세션끝내기
			view = "redirect:loginForm.jsp";
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
