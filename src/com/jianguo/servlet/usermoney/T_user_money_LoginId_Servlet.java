package com.jianguo.servlet.usermoney;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.bean.T_user_login_Bean;
import com.jianguo.bean.T_user_money_Bean;
import com.jianguo.sql.T_user_login_Sql;
import com.jianguo.sql.T_user_money_Sql;
import com.jianguo.util.Frequently;

public class T_user_money_LoginId_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_user_money_LoginId_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_user_money_LoginId_Servlet
	//http://101.200.205.243:8080/T_user_money_LoginId_Servlet?only=A7A2D6CB9D71549224A1D82CD46E1C2A&login_id=5735
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_user_money_LoginId_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();

		String login_id =request.getParameter("login_id");

		//------------------��������--------��ʼ----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){
			//------------------��������--------����----------------------

			T_user_money_Bean t_user_money = T_user_money_Sql.select_login_id(login_id);
			
			T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
			
			t_user_money.setPay_status(t_user_login.getStatus()+"");
			
			Map map = new HashMap();
			map.put("t_user_money", t_user_money);

			params.put("data", map);
			params.put("message", "�û�����ѯ�ɹ�");
			params.put("code", "200");
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params); 
			pw.write(str);
			pw.flush();
			pw.close();
			//------------------��������--------��ʼ----------------------
		}else{
			params.put("message", "��Ч����");
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params); 
			pw.write(str);
			pw.flush();
			pw.close();
		}
		//------------------��������--------����----------------------
	}
}
