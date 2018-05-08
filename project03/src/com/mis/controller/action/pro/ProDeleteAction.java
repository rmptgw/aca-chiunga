package com.mis.controller.action.pro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.controller.action.cus.CusListAction;
import com.mis.dao.ProDAO;

public class ProDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pro_no = request.getParameter("pro_no");
		
		ProDAO pDao = ProDAO.getInstance();
		pDao.deletePro(pro_no);
		
		new CusListAction().execute(request, response);
		
	}

}
