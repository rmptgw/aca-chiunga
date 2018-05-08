package com.mis.controller.action.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.EmpDAO;
import com.mis.dto.EmpVO;

public class EmpWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpVO eVo = new EmpVO();
		
		eVo.setEmp_name(request.getParameter("emp_name"));
		eVo.setEmp_id(request.getParameter("emp_id"));
		eVo.setEmp_pass(request.getParameter("emp_pass"));
		eVo.setEmp_dept(request.getParameter("emp_dept"));
		eVo.setEmp_phone(request.getParameter("emp_phone"));
		eVo.setEmp_email(request.getParameter("emp_email"));
		
		EmpDAO eDao = EmpDAO.getInstance();
		eDao.insertEmp(eVo);
		
		new EmpListAction().execute(request, response);
		
	}

}
