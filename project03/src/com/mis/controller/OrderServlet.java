package com.mis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mis.controller.action.Action;
import com.mis.dto.EmpVO;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		EmpVO emp=(EmpVO) session.getAttribute("loginUser");
		Integer result=(Integer) session.getAttribute("result");
		if(emp != null && result==1){
			String command = request.getParameter("command");
			System.out.println("OrderServlet에서 요청을 받음을 확인 : " + command);
			ActionFactory af = ActionFactory.getInstance();
			Action action = af.getAction(command);
			if (action != null) {
				action.execute(request, response);
			}
		}else{
			response.sendRedirect("login.do");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
