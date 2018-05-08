package com.mis.controller.action.cus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.CusDAO;
import com.mis.dto.CusVO;

public class CusUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/cus/cusUpdate.jsp";
		
		String cno = request.getParameter("cno");
		
		CusDAO cDao = CusDAO.getInstance();
		
		CusVO cVo = cDao.selectOneCusByNo(cno);
		
		request.setAttribute("cus", cVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
