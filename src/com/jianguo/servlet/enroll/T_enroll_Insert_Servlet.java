package com.jianguo.servlet.enroll;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.bean.T_enroll_limit_Bean;
import com.jianguo.bean.T_job_Bean;
import com.jianguo.bean.T_job_info_Bean;
import com.jianguo.bean.T_merchant_Bean;
import com.jianguo.bean.T_user_login_Bean;
import com.jianguo.bean.T_user_resume_Bean;
import com.jianguo.sql.T_enroll_Sql;
import com.jianguo.sql.T_enroll_limit_Sql;
import com.jianguo.sql.T_job_Sql;
import com.jianguo.sql.T_job_info_Sql;
import com.jianguo.sql.T_job_record_Sql;
import com.jianguo.sql.T_merchant_Sql;
import com.jianguo.sql.T_push_Sql;
import com.jianguo.sql.T_user_login_Sql;
import com.jianguo.sql.T_user_resume_Sql;
import com.jianguo.util.Frequently;
import com.jianguo.util.Jdpush;
import com.jianguo.util.Jdpush_shang;
import com.jianguo.util.Jdpushcc;
import com.jianguo.util.Jdpushcc_shang;
import com.jianguo.util.Jdpusher;
import com.jianguo.util.Jdpusher_shang;
import com.jianguo.util.Text_Sms;

public class T_enroll_Insert_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_enroll_Insert_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_enroll_Insert_Servlet?only=26F9FD590B0EFE6D69217B6588AA0B13&login_id=20&job_id=69
	//http://101.200.205.243:8080/T_enroll_Insert_Servlet?only=9DC23D32BEF618D010458C00B43EADF6&login_id=5753&job_id=1119
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_enroll_Insert_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();
		
		String login_id =request.getParameter("login_id");
		String job_id =request.getParameter("job_id");
		
		//------------------��������--------��ʼ----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){
			//------------------��������--------����----------------------

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ly_time = sdf.format(new java.util.Date());
			
			T_job_Bean t_job11 = T_job_Sql.select_id(job_id);
			T_job_info_Bean t_job_onfo11 = T_job_info_Sql.select_job_id(job_id);
			if(t_job11.getMerchant_id()==28 || t_job11.getMerchant_id()==29 || t_job11.getMerchant_id()==30 || t_job11.getMerchant_id()==31 || t_job11.getMerchant_id()==32){
				T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
				T_user_resume_Bean t_user_resume = T_user_resume_Sql.select_login_id(login_id);
				String ss_sex = "";
				if(t_user_resume.getSex() == 1){
					ss_sex = "��";
				}else{
					ss_sex = "Ů";
				}
				Text_Sms.textdemos5(t_job_onfo11.getTel(), t_job11.getName(), t_user_resume.getName(), ss_sex, t_user_login.getTel(), t_user_resume.getSchool());
//				MD_SMS_Info.wailu5(t_job_onfo11.getTel(), t_job11.getName(), t_user_resume.getName(), ss_sex, t_user_login.getTel(), t_user_resume.getSchool());
				
//				String code = Text_Sms.textdemos1(t_user_login.getTel());
				
				T_job_Sql.update_count(job_id);
				
//				T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
				Text_Sms.textdemos1212(t_user_login.getTel(),t_job_onfo11.getTel());
			}else{
				T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
				Text_Sms.textdemos1(t_user_login.getTel());
			}
			
			if(T_enroll_Sql.check_login_id_job_id2(login_id, job_id, "12")){
				T_enroll_Sql.delete(login_id, job_id);
			}
			
			if(!T_enroll_Sql.check_login_id_job_id(login_id, job_id) || T_enroll_Sql.check_login_id_job_id2(login_id, job_id, "1")){
				
//				T_job_Bean t_job_info = T_job_Sql.select_id(job_id);
//				long ll = System.currentTimeMillis()/1000;
//				int ii = Integer.parseInt(t_job_info.getStart_date());
//				if(ll >= ii){
//					params.put("message", "���ѱ���ʱ�ü�ļ�ְ�����кö����ѡŶ��");
//					params.put("code", "403");
//					PrintWriter pw = response.getWriter();
//					Gson g = new Gson();
//					String str = g.toJson(params); 
//					pw.write(str);
//					pw.flush();
//					pw.close();
//			}else{
				
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
				String ly_time2 = sdf2.format(new java.util.Date());
				int ii=Integer.parseInt(ly_time2);
				
					T_enroll_limit_Bean t_enroll_limit = T_enroll_limit_Sql.select_login_id(login_id);
					if(t_enroll_limit.getCount() >= 3 && t_enroll_limit.getDate() == ii){
						params.put("message", "���ձ����Ѵ�����");
						params.put("code", "403");
						PrintWriter pw = response.getWriter();
						Gson g = new Gson();
						String str = g.toJson(params); 
						pw.write(str);
						pw.flush();
						pw.close();
						
					}else{
						T_enroll_limit_Bean t_enroll_limit2 = T_enroll_limit_Sql.select_login_id(login_id);
						if(t_enroll_limit2.getDate() != ii){
							T_enroll_limit_Sql.update_count0(ly_time2,login_id);
						}else{
						T_enroll_limit_Sql.update_count(ly_time2,login_id);
						}
						if(!T_enroll_Sql.check_login_id_job_id(login_id, job_id)){
							String str_max = "";
							if(t_job11.getMax() == 0){
								str_max = "0";
							}else{
								str_max = "1";
							}
							T_enroll_Sql.insert(login_id, job_id, "0",ly_time,"0",str_max);
							
							if(!T_job_record_Sql.check_login_id(login_id)){
								T_job_record_Sql.insert(login_id, "0", "0");
							}
						}else if(T_enroll_Sql.check_login_id_job_id2(login_id, job_id, "1")){
							T_enroll_Sql.update_status("0",login_id, job_id);
						}
						T_job_Sql.update_user_count(job_id);
						
						Jdpush.sendPush("������"+t_job11.getName()+"�����ύ����ȴ��̼�ȷ��","jianguo"+login_id);
						Jdpusher.sendPush("������"+t_job11.getName()+"�����ύ����ȴ��̼�ȷ��","jianguo"+login_id);
						Jdpushcc.sendPush("������"+t_job11.getName()+"�����ύ����ȴ��̼�ȷ��","jianguo"+login_id);
						T_push_Sql.insert(login_id, t_job11.getName(), "����", "������"+t_job11.getName()+"�����ύ����ȴ��̼�ȷ��", "0", ly_time);
						
//						T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
//						Text_Sms.textdemos1(t_user_login.getTel());
//						MD_SMS_Info.baoming1(t_user_login.getTel());
//						Text_Sms.textdemos1(t_user_login.getTel());
						
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						T_merchant_Bean t_merchant = T_merchant_Sql.select_id(t_job.getMerchant_id()+"");
						Jdpush_shang.sendPush("�������ġ�"+t_job.getName()+"����ְ���˱���","jianguo"+t_merchant.getLogin_id());
						Jdpusher_shang.sendPush("�������ġ�"+t_job.getName()+"����ְ���˱���","jianguo"+t_merchant.getLogin_id());
						Jdpushcc_shang.sendPush("�������ġ�"+t_job.getName()+"����ְ���˱���","jianguo"+t_merchant.getLogin_id());

						params.put("message", "��ְ�����ɹ�");
						params.put("code", "200");
						PrintWriter pw = response.getWriter();
						Gson g = new Gson();
						String str = g.toJson(params); 
						pw.write(str);
						pw.flush();
						pw.close();
					}
//			}
			}else{
				params.put("message", "��ְ����ʧ��");
				params.put("code", "500");
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
}
