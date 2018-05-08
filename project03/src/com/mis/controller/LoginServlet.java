package com.mis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mis.dao.EmpDAO;
import com.mis.dto.EmpVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("emp_id");
		String pwd = request.getParameter("emp_pass");
		String url=null;
		
		EmpDAO empDAO = EmpDAO.getInstance();
		int result = empDAO.userCheck(id, pwd);
		//�α��� ����
		if(result == 1){
			EmpVO emp = new EmpVO();
			emp = empDAO.geteVo(id);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", emp);			
			session.setAttribute("result", result);			
			url = "main.jsp";				
		}else{
			url = "login.jsp";
			if(result == 0){			
				request.setAttribute("message", "로그인2 : 비번이 달라여");
			}else{			
				request.setAttribute("message", "로그인3 : 회원이 아이네");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
