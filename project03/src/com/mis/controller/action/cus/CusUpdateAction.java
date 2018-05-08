package com.mis.controller.action.cus;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.CusDAO;
import com.mis.dto.CusVO;

public class CusUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CusVO cVo = new CusVO();
		
		cVo.setCno(Integer.parseInt(request.getParameter("cno")));
		cVo.setCname(request.getParameter("cname"));
		cVo.setCpost(request.getParameter("cpost"));
		cVo.setCaddr(request.getParameter("caddr"));
		cVo.setCphone(request.getParameter("cphone"));
		cVo.setCemail(request.getParameter("cemail"));
		
		CusDAO cDao = CusDAO.getInstance();
		cDao.updateCus(cVo);
		
		new CusListAction().execute(request, response);
		
	}

}
