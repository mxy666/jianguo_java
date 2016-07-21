package com.jianguo.servlet.usermoney;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.bean.T_user_moneyout_Bean;
import com.jianguo.sql.T_user_moneyout_Sql;
import com.jianguo.util.Frequently;

public class T_user_money_OutLook_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_user_money_OutLook_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_user_money_OutLook_Servlet
	//http://101.200.205.243:8080/T_user_money_OutLook_Servlet?only=831B19CDF904CA6133A3982F94C3E5AD&login_id=4&password=22	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_user_money_OutLook_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();

		String login_id =request.getParameter("login_id");
		String count =request.getParameter("count");

		//------------------��������--------��ʼ----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){
			//------------------��������--------����----------------------

			List<T_user_moneyout_Bean> list_t_user_moneyout = T_user_moneyout_Sql.select_All_name(login_id,count);
			Map map = new HashMap();
			map.put("list_t_user_moneyout", list_t_user_moneyout);

			params.put("data", map);
			params.put("message", "�û�֧����ϸ��ѯ�ɹ�");
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
