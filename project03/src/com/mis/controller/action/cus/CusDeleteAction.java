package com.mis.controller.action.cus;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.CusDAO;

public class CusDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cno = request.getParameter("cno");
		
		CusDAO cDao = CusDAO.getInstance();
		cDao.deleteCus(cno);
		
		new CusListAction().execute(request, response);
		
	}

}
