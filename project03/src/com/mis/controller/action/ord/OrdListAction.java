package com.mis.controller.action.ord;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.OrdDAO;
import com.mis.dto.OrdVO;

public class OrdListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/ord/ordList.jsp";
		
		OrdDAO oDao = OrdDAO.getInstance();
		
		
		
		List<OrdVO>ordList = oDao.selectAllOrders();
		request.setAttribute("ordList", ordList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
