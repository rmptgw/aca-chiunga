package com.mis.controller.action.cus;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.CusDAO;
import com.mis.dto.CusVO;

public class CusListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/cus/cusList.jsp";
		
		CusDAO cDao = CusDAO.getInstance();
		
		List<CusVO>cusList = cDao.selectAllCus();
		
		request.setAttribute("cusList", cusList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
