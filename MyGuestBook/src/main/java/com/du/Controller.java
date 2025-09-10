package com.du;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.service.GetMessageListService;
import guestbook.service.MessageListView;

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
		
		if(com.equals("/") ||  com.equals("/list")) {
			String pageNumberStr = request.getParameter("page");
			int pageNumber = 1;
			if (pageNumberStr != null) {
				pageNumber = Integer.parseInt(pageNumberStr);
			}

			GetMessageListService messageListService = 
					GetMessageListService.getInstance();
			MessageListView viewData = 
					messageListService.getMessageList(pageNumber);
			
			request.setAttribute("viewData", viewData);
			view = "glist.jsp";
		}
		
		if (view.startsWith("redirect:")) {	//redirect 또는 포워딩
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
