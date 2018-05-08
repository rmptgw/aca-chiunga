package com.mis.controller.action.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.EmpDAO;
import com.mis.dto.EmpVO;

public class EmpListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/emp/empList.jsp";
		
		EmpDAO eDAO = EmpDAO.getInstance();
		
		List<EmpVO>empList = eDAO.selectAllEmployees();
		
		request.setAttribute("empList", empList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
