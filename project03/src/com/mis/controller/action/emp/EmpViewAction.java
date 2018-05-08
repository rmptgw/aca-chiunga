package com.mis.controller.action.emp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.EmpDAO;
import com.mis.dto.EmpVO;

public class EmpViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/emp/empView.jsp";
		
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		
		EmpDAO eDao = EmpDAO.getInstance();
		
		EmpVO eVo = eDao.selectOneEmpByNo(emp_no);
		
		request.setAttribute("emp", eVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
