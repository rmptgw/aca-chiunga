package com.mis.controller.action.pro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.controller.action.cus.CusListAction;
import com.mis.dao.ProDAO;
import com.mis.dto.ProVO;

public class ProUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProVO pVo = new ProVO();
		pVo.setPro_no(Integer.parseInt(request.getParameter("pro_no")));
		pVo.setPro_name(request.getParameter("pro_name"));
		pVo.setPro_price(Integer.parseInt(request.getParameter("pro_price")));
		pVo.setPro_stock(Integer.parseInt(request.getParameter("pro_stock")));
		
		ProDAO pDao = ProDAO.getInstance();
		pDao.updatePro(pVo);
		
		new CusListAction().execute(request, response);
		
	}

}
