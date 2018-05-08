package com.mis.controller.action.ord;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.ProDAO;
import com.mis.dto.ProVO;

public class ProUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/pro/proUpdate.jsp";
		
		String pro_no = request.getParameter("pro_no");
		
		ProDAO pDao = ProDAO.getInstance();
		
		ProVO pVo = pDao.selectOneProByNo(pro_no);
		
		request.setAttribute("pro", pVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
