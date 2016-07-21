package com.jianguo.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.servlet.sms.MD_SMS_Info;
import com.jianguo.sql.T_tel_code_Sql;
import com.jianguo.sql.T_user_login_Sql;
import com.jianguo.util.Frequently;
import com.jianguo.util.Text_Sms;

public class T_user_login_Check_Merchant_BackTel_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_user_login_Check_Merchant_BackTel_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.0.104/JianGuo_Server/T_user_login_Check_Merchant_BackTel_Servlet?only=9DC23D32BEF618D010458C00B43EADF6&tel=18631017353
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_user_login_Check_Merchant_BackTel_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();

		String tel =request.getParameter("tel");
		
		//------------------��������--------��ʼ----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){	
		//------------------��������--------����----------------------

		boolean b = T_user_login_Sql.check_tel_power(tel,"0");
		if(b == true){
			
			String code = Text_Sms.textdemos(tel);
//			String code = MD_SMS_Info.yanzhengma0(tel);
			
//			if(T_tel_code_Sql.check_tel(tel)){
//				T_tel_code_Sql.update_tel(code, tel);
//			}else{
//				T_tel_code_Sql.update_tel(code, tel);
//			}
			
			params.put("message", "�ɹ�");
			params.put("code", "200");
			params.put("text", code);
			params.put("is_tel", "1");
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params); 
			pw.write(str);
			pw.flush();
			pw.close();
		}else{
			params.put("message", "ʧ��");
			params.put("code", "500");
			params.put("is_tel", "0");
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params); 
			pw.write(str);
			pw.flush();
			pw.close();
		}
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
