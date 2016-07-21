package com.jianguo.servlet.wages;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.bean.T_enroll_Bean;
import com.jianguo.bean.T_job_Bean;
import com.jianguo.bean.T_user_login_Bean;
import com.jianguo.bean.T_user_money_Bean;
import com.jianguo.bean.T_wages_Bean;
import com.jianguo.servlet.sms.MD_SMS_Info;
import com.jianguo.sql.T_enroll_Sql;
import com.jianguo.sql.T_job_Sql;
import com.jianguo.sql.T_job_record_Sql;
import com.jianguo.sql.T_push_Sql;
import com.jianguo.sql.T_user_login_Sql;
import com.jianguo.sql.T_user_money_Sql;
import com.jianguo.sql.T_wages_Sql;
import com.jianguo.util.Frequently;
import com.jianguo.util.Jdpush;
import com.jianguo.util.Jdpushcc;
import com.jianguo.util.Jdpusher;
import com.jianguo.util.Text_Sms;

public class T_wages_Insert_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_wages_Insert_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_wages_Insert_Servlet?only=D676F8B429AC1D11E2F0BE13493190AE&login_id=2&job_id=1
	//http://101.200.205.243:8080/T_wages_Insert_Servlet?only=C978AF1CD86BC4A761985B762A5C6DC1&job_id=24&offer=13
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_wages_Insert_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();
		Map params2 =  new HashMap();
		
//		String login_id =request.getParameter("login_id");
		String job_id =request.getParameter("job_id");
		String nv_job_id =request.getParameter("nv_job_id");
//		String hould_money =request.getParameter("hould_money");
//		String real_money =request.getParameter("real_money");
		String json =request.getParameter("json");
		
//		System.out.println(json);

		//------------------��������--------��ʼ----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){
			//------------------��������--------����----------------------
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ly_time = sdf.format(new java.util.Date());
			
			Gson g2 = new Gson();
			user_ss list2 = g2.fromJson(json, user_ss.class);
			for (int i = 0; i < list2.getList_t_wages_Bean().size(); i++) {
				T_wages_Bean t = list2.getList_t_wages_Bean().get(i);
				
//				System.out.println("---"+t.getLogin_id()+"---");
//				System.out.println("---"+t.getJob_id()+"---");
//				System.out.println("---"+t.getHould_money()+"---");
//				System.out.println("---"+t.getReal_money()+"---");
//				System.out.println("---"+t.getRemarks()+"---");
				
//				DecimalFormat dfr=new DecimalFormat(".##");
//				String str2=dfr.format(t.getReal_money());
//				double money1;
//				money1=Double.parseDouble(str2);
				
				T_user_money_Bean t_user_money = T_user_money_Sql.select_login_id(t.getLogin_id()+"");
				double ddd = t_user_money.getMoney()+ t.getReal_money();
				System.out.println(t_user_money.getMoney());
				System.out.println(t.getReal_money());
				System.out.println(ddd);
				float scale = (float) ddd; 
				DecimalFormat fnum = new DecimalFormat("##0.00"); 
				String dd=fnum.format(scale); 
				
				float scale2 = (float) t.getReal_money(); 
				DecimalFormat fnum2 = new DecimalFormat("##0.00"); 
				String dd2=fnum2.format(scale2); 
				
				if(!T_wages_Sql.check(t.getLogin_id()+"", t.getJob_id()+"")){
				
				T_wages_Sql.insert(t.getLogin_id()+"", t.getJob_id()+"", t.getHould_money()+"", dd2+"", t.getRemarks(), ly_time);
				T_enroll_Sql.update_state("1",t.getLogin_id()+"", t.getJob_id()+"");
			
				T_user_money_Sql.update_moneyss(dd, t.getLogin_id()+"");
				T_enroll_Sql.update_status2("12", t.getLogin_id()+"",t.getJob_id()+"");

				T_job_record_Sql.update_complete(t.getLogin_id()+"");
				
				T_job_Bean t_job = T_job_Sql.select_id(t.getJob_id()+"");
				T_user_login_Bean t_user_login = T_user_login_Sql.select_id(t.getLogin_id()+"");
//				Text_Sms.textdemos4(t_user_login.getTel(),t_job.getName(),dd2+"");
//				MD_SMS_Info.daqian4(t_user_login.getTel(),t_job.getName(),dd2+"");
				
				Jdpush.sendPush("���ʵ��ˣ��˻����յ�"+dd2+"Ԫ,��"+t_job.getName()+"����ְ�Ĺ���","jianguo"+t.getLogin_id()+"");
				Jdpusher.sendPush("���ʵ��ˣ��˻����յ�"+dd2+"Ԫ,��"+t_job.getName()+"����ְ�Ĺ���","jianguo"+t.getLogin_id()+"");
				Jdpushcc.sendPush("���ʵ��ˣ��˻����յ�"+dd2+"Ԫ,��"+t_job.getName()+"����ְ�Ĺ���","jianguo"+t.getLogin_id()+"");

				T_push_Sql.insert(t.getLogin_id()+"", t_job.getName(), "���ʵ���", "���ʵ��ˣ��˻����յ�"+dd2+"Ԫ,��"+t_job.getName()+"����ְ�Ĺ���", "1", ly_time);
				}
			}
			List<T_enroll_Bean> list_t_enroll2 = T_enroll_Sql.select_job_id_status_count(job_id,nv_job_id, "9");
			
			if(list_t_enroll2.size() == 0){
				T_job_Sql.update_status("5", job_id);
				T_job_Sql.update_status("5", nv_job_id);
			}
			
			params.put("message", "���ʽ���ɹ�");
			params.put("sum", list_t_enroll2.size());
			params.put("code", "200");
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params); 
			pw.write(str);
			pw.flush();
			pw.close();
//			17000103671
			//------------------��������--------��ʼ----------------------
		}else{
			params.put("message", "��Ч����");
			params.put("code", "404");
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params);
			pw.write(str);
			pw.flush();
			pw.close();
		}
		//------------------��������--------����----------------------
	}
	
	private class user_ss{
		private List<T_wages_Bean> list_t_wages_Bean;

		public void setList_t_wages_Bean(List<T_wages_Bean> list_t_wages_Bean) {
			this.list_t_wages_Bean = list_t_wages_Bean;
		}

		public List<T_wages_Bean> getList_t_wages_Bean() {
			return list_t_wages_Bean;
		}
	}
}
