package com.du;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.du.dao.DEDao;
import com.du.dao.deptdao;
import com.du.dao.empdao;
import com.du.dto.Dept;
import com.du.dto.Emp;

//오라클의 emp 테이블을 사용하여 사원 관리 프로그램을 만들어 보세요
//오라클의 emp, dept을 조인한 결과를 웹 화면에 보여 주려면?

/**
 * Servlet implementation class Contoller
 */
@WebServlet("/")
public class Contoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String view = null;
		String url = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = url.substring(conPath.length());
		
		if(com.equals("/") || com.equals("/emp")) {
			empdao dao = new empdao();
			List<Emp> list = dao.selectList();
			request.setAttribute("list", list);
			request.setAttribute("isUpeate", "no");	//update, insert 구분
			view = "emp.jsp";	
		}else if (com.equals("/de")) {
			DEDao dedao = new DEDao();
			List<Dept> list = dedao.selectList();
			request.setAttribute("list", list);
			request.setAttribute("isUpeate", "no");
			view = "de.jsp";
			
		}else if (com.equals("/updateForm"))	{
			int empno = Integer.parseInt(request.getParameter("empno"));
			
			
			
			Emp emp = new Emp(empno);	//dto에 getter에 empno값 설정
			empdao dao = new empdao();	//dao에 seletlist가져오기 위한 객체 생성
			
			emp = dao.selectOne(empno);	//empno에 맞는 다른 칼럼값 가져오기
			
			request.setAttribute("dto",emp);	//jsp파일에 dto라는 이름으로 empno만 설정
			List<Emp> list = dao.selectList();	//dao에 dto에있는 모든 테이블 칼럼으로 만든 생성자로 만든 리스트
			request.setAttribute("list", list);	//list에는 지금 값이 다있음
			request.setAttribute("isUpdate", "yes");	//update 실행
			view = "emp.jsp";
			
		}else if (com.equals("/insert")) {
			request.setCharacterEncoding("utf-8");
			String loc= request.getParameter("loc");
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			int mgr = Integer.parseInt(request.getParameter("mgr"));
			String hiredate = request.getParameter("hiredate");
			int sal = Integer.parseInt(request.getParameter("sal"));
			int comm = Integer.parseInt(request.getParameter("comm"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			Emp emp = new Emp(empno,ename ,job,mgr,hiredate,sal,comm,deptno);
			empdao dao = new empdao();
			dao.insert(emp);
			
			String isUpdate = request.getParameter("isUpdate");	//update
			if (isUpdate.equals("no")) {
				dao.insert(emp);
			}else if(isUpdate.equals("yes")){
				//update 실행
				dao.update(emp);
				isUpdate="no";
			}
			view = "redirect:emp";
			
		}else if (com.equals("/delete")){
			String empno = request.getParameter("empno");
			empdao dao = new empdao();
			dao.delete(empno);
			view = "redirect:emp";
		}

		
		if(view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		}else {
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
