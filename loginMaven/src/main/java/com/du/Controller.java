package com.du;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		    try ( 
		        Connection conn = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/DoTtSQL", "root", "1234");
		        Statement stmt = conn.createStatement();
		            
		            // 지정된 아이디와 비밀번호를 가진 레코드가 있는지 쿼리 
		        ResultSet rs = stmt.executeQuery(String.format(         
		                "select * from member where id='%s' and pw='%s'",
		                request.getParameter("id"), request.getParameter("pw")));
		    ) {
		        // 그런 레코드가 있으면, 세션 속성을 등록하고, 메인 화면으로 돌아감
		        if (rs.next()) {
		            session.setAttribute("userId",   rs.getString("id"  ));
		            session.setAttribute("userName", rs.getString("name"));
		                
		            view="login_main.jsp";
		        }
		        
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
			
		    
		} else if(com.equals("/logout")) {
		    session.removeAttribute("userId"  );
		    session.removeAttribute("userName");

			view = "redirect:login_main.jsp";// 로그인 메인 화면으로
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
