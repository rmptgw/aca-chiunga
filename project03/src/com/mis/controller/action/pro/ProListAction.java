package com.mis.controller.action.pro;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.ProDAO;
import com.mis.dto.ProVO;

public class ProListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/pro/proList.jsp";
		
		ProDAO pDao = ProDAO.getInstance();
		
		List<ProVO>proList = pDao.selectAllProducts();
		
		request.setAttribute("proList", proList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
