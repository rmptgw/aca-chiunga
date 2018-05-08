package com.mis.controller;

import com.mis.controller.action.Action;
import com.mis.controller.action.cus.CusDeleteAction;
import com.mis.controller.action.cus.CusListAction;
import com.mis.controller.action.cus.CusUpdateAction;
import com.mis.controller.action.cus.CusUpdateFormAction;
import com.mis.controller.action.cus.CusViewAction;
import com.mis.controller.action.cus.CusWriteAction;
import com.mis.controller.action.cus.CusWriteFormAction;
import com.mis.controller.action.emp.EmpDeleteAction;
import com.mis.controller.action.emp.EmpListAction;
import com.mis.controller.action.emp.EmpUpdateAction;
import com.mis.controller.action.emp.EmpUpdateFormAction;
import com.mis.controller.action.emp.EmpViewAction;
import com.mis.controller.action.emp.EmpWriteAction;
import com.mis.controller.action.emp.EmpWriteFormAction;
import com.mis.controller.action.ord.OrdListAction;
import com.mis.controller.action.pro.ProDeleteAction;
import com.mis.controller.action.pro.ProListAction;
import com.mis.controller.action.pro.ProUpdateAction;
import com.mis.controller.action.pro.ProUpdateFormAction;
import com.mis.controller.action.pro.ProViewAction;
import com.mis.controller.action.pro.ProWriteAction;
import com.mis.controller.action.pro.ProWriteFormAction;


public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		/* 추가된 부분 */
		if (command.equals("pro_list")) {
			action = new ProListAction();}
		else if(command.equals("pro_write_form")){
			action = new ProWriteFormAction();
		}else if(command.equals("pro_write")){
			action = new ProWriteAction();
		}else if(command.equals("pro_view")){
			action = new ProViewAction();
		}else if(command.equals("pro_update_form")){
			action = new ProUpdateFormAction();
		}else if(command.equals("pro_update")){
			action = new ProUpdateAction();
		}else if(command.equals("pro_delete")){
			action = new ProDeleteAction();
		}else if(command.equals("cus_list")){
			action = new CusListAction();
		}else if(command.equals("cus_write_form")){
			action = new CusWriteFormAction();
		}else if(command.equals("cus_write")){
			action = new CusWriteAction();
		}else if(command.equals("cus_view")){
			action = new CusViewAction();
		}else if(command.equals("cus_update_form")){
			action = new CusUpdateFormAction();
		}else if(command.equals("cus_update")){
			action = new CusUpdateAction();
		}else if(command.equals("cus_delete")){
			action = new CusDeleteAction();
		}else if(command.equals("emp_list")){
			action = new EmpListAction();
		}else if(command.equals("emp_write_form")){
			action = new EmpWriteFormAction();
		}else if(command.equals("emp_write")){
			action = new EmpWriteAction();
		}else if(command.equals("emp_view")){
			action = new EmpViewAction();
		}else if(command.equals("emp_update_form")){
			action = new EmpUpdateFormAction();
		}else if(command.equals("emp_update")){
			action = new EmpUpdateAction();
		}else if(command.equals("emp_delete")){
			action = new EmpDeleteAction();
		}else if(command.equals("ord_list")){
			action = new OrdListAction();
		}
		return action;
	}
}
