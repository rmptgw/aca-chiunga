package com.mis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mis.dao.MemberDAO;
import com.mis.dto.MemberVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String emp_id = request.getParameter("emp_id");
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.getMember(emp_id);
		request.setAttribute("mVo", mVo);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("member/memberUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
	
		String emp_id = request.getParameter("emp_id");
		String emp_pass = request.getParameter("emp_pass");
		String emp_dept = request.getParameter("emp_dept");
		String emp_phone = request.getParameter("emp_phone");
		String emp_email = request.getParameter("emp_email");
		
		MemberVO mVo = new MemberVO();
		mVo.setEmp_id(emp_id);
		mVo.setEmp_pass(emp_pass);
		mVo.setEmp_dept(emp_dept);
		mVo.setEmp_phone(emp_phone);
		mVo.setEmp_email(emp_email);
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMember(mVo);
		response.sendRedirect("login.do");
	}

}
