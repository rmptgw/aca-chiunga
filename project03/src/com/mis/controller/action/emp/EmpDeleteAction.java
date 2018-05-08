package com.mis.controller.action.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.EmpDAO;

public class EmpDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int emp_no = Integer.parseInt(request.getParameter("emp_no"));
		
		EmpDAO eDao = EmpDAO.getInstance();
		eDao.deleteEmp(emp_no);
		
		new EmpListAction().execute(request, response);
		
	}

}
