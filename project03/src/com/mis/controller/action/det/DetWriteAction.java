package com.mis.controller.action.det;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.controller.action.Action;
import com.mis.dao.ProDAO;
import com.mis.dto.ProVO;

public class DetWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProVO pVo = new ProVO();
		
		pVo.setPro_name(request.getParameter("pro_name"));
		pVo.setPro_price(Integer.parseInt(request.getParameter("pro_price")));
		pVo.setPro_stock(Integer.parseInt(request.getParameter("pro_stock")));
		
		ProDAO proDAO = ProDAO.getInstance();
		proDAO.insertProduct(pVo);
		
		new DetListAction().execute(request, response);
	}

}
