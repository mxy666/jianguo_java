package com.jianguo.servlet.enroll;

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
import com.jianguo.bean.T_enroll_Bean;
import com.jianguo.bean.T_job_Bean;
import com.jianguo.bean.T_job_info_Bean;
import com.jianguo.bean.T_merchant_Bean;
import com.jianguo.bean.T_user_login_Bean;
import com.jianguo.sql.T_enroll_Sql;
import com.jianguo.sql.T_job_Sql;
import com.jianguo.sql.T_job_info_Sql;
import com.jianguo.sql.T_job_record_Sql;
import com.jianguo.sql.T_merchant_Sql;
import com.jianguo.sql.T_push_Sql;
import com.jianguo.sql.T_user_login_Sql;
import com.jianguo.util.Frequently;
import com.jianguo.util.Jdpush;
import com.jianguo.util.Jdpush_shang;
import com.jianguo.util.Jdpushcc;
import com.jianguo.util.Jdpushcc_shang;
import com.jianguo.util.Jdpusher;
import com.jianguo.util.Jdpusher_shang;
import com.jianguo.util.Text_Sms;

public class T_enroll_Offer_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_enroll_Offer_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_enroll_Offer_Servlet?only=648C6D6926E835F494A0878DBB0CFB90&login_id=2&job_id=1��&Offer=1
	//http://101.200.205.243:8080/T_enroll_Offer_Servlet?only=FF3BD5ECC52DD9D14C30A7C2DF876C6E&login_id=10305&job_id=1149&offer=3
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_enroll_Offer_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();
		
		String login_id =request.getParameter("login_id");
		String job_id =request.getParameter("job_id");
		String Offer =request.getParameter("offer");
		
		//------------------��������--------��ʼ----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){
			//------------------��������--------����----------------------
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ly_time = sdf.format(new java.util.Date());
			
			if(T_enroll_Sql.check_login_id_job_id(login_id, job_id)){
				if(Offer.equals("1")){
					int i = T_enroll_Sql.update_status("1",login_id, job_id);
					if(i == 1){
						T_job_Sql.update_user_count_jian(job_id);
						
						Jdpush.sendPush("�����ɹ�ȡ�������ȡ����Ӱ���������õȼ�","jianguo"+login_id);
						Jdpusher.sendPush("�����ɹ�ȡ�������ȡ����Ӱ���������õȼ�","jianguo"+login_id);
						Jdpushcc.sendPush("�����ɹ�ȡ�������ȡ����Ӱ���������õȼ�","jianguo"+login_id);
						
						T_job_Bean t_job11 = T_job_Sql.select_id(job_id);
						T_push_Sql.insert(login_id, t_job11.getName(), "ȡ������", "�����ɹ�ȡ�������ȡ����Ӱ���������õȼ�", "0", ly_time);
						
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						T_merchant_Bean t_merchant = T_merchant_Sql.select_id(t_job.getMerchant_id()+"");
						Jdpush.sendPush("����ȡ��������"+t_job.getName()+"����鿴","jianguo"+t_merchant.getLogin_id());
						Jdpusher.sendPush("����ȡ��������"+t_job.getName()+"����鿴","jianguo"+t_merchant.getLogin_id());
						Jdpushcc.sendPush("����ȡ��������"+t_job.getName()+"����鿴","jianguo"+t_merchant.getLogin_id());
						
						params.put("message", "�û�ȡ���ɹ�");
//					}else{
//					params.put("message", "�û�ȡ��ʧ��");
					}
				}else if(Offer.equals("2")){
						T_enroll_Sql.update_status("2",login_id, job_id);
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						
						T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
//						Text_Sms.textdemos32(t_user_login.getTel(),t_job.getName());
//						MD_SMS_Info.jujue32(t_user_login.getTel(),t_job.getName());
						
						Jdpush.sendPush("��������"+t_job.getName()+"�����̼Ҿܾ��ˣ������������ְ","jianguo"+login_id);
						Jdpusher.sendPush("��������"+t_job.getName()+"�����̼Ҿܾ��ˣ������������ְ","jianguo"+login_id);
						Jdpushcc.sendPush("��������"+t_job.getName()+"�����̼Ҿܾ��ˣ������������ְ","jianguo"+login_id);
						
//						T_job_Bean t_job11 = T_job_Sql.select_id(job_id);
						T_push_Sql.insert(login_id, t_job.getName(), "��������", "��������"+t_job.getName()+"�����̼Ҿܾ��ˣ������������ְ", "0", ly_time);
						
						params.put("message", "�̼�ȡ��¼ȡ�ɹ�");
				}else if(Offer.equals("3")){
					int i = T_enroll_Sql.update_status("5",login_id, job_id);
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						T_job_info_Bean t_job_info = T_job_info_Sql.select_job_id(job_id);
						List<T_enroll_Bean> list_t_enroll = T_enroll_Sql.select_job_id_status2_all(job_id, "3","5","8","9","10","11","12","13");
						T_job_Sql.update_countss(list_t_enroll.size()+"",job_id);
						
						T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
						Text_Sms.textdemos2(t_user_login.getTel(),t_job.getName(),t_job_info.getTel());
//						MD_SMS_Info.luyong2(t_user_login.getTel(),t_job.getName());
						
//						Jdpush.sendPush("��������"+t_job.getName()+"���ѱ��̼���ʽ¼�ã���ȷ�ϲμ�","jianguo"+login_id);
//						Jdpusher.sendPush("��������"+t_job.getName()+"���ѱ��̼���ʽ¼�ã���ȷ�ϲμ�","jianguo"+login_id);
//						Jdpushcc.sendPush("��������"+t_job.getName()+"���ѱ��̼���ʽ¼�ã���ȷ�ϲμ�","jianguo"+login_id);
						
						Jdpush_shang.sendPush("�̼ҳɹ�¼ȡ��"+t_job.getName()+"��","jianguo"+login_id);
						Jdpusher_shang.sendPush("�̼ҳɹ�¼ȡ��"+t_job.getName()+"��","jianguo"+login_id);
						Jdpushcc_shang.sendPush("�̼ҳɹ�¼ȡ��"+t_job.getName()+"��","jianguo"+login_id);
						
						T_push_Sql.insert(login_id, t_job.getName(), "¼��", "��������"+t_job.getName()+"���ѱ��̼���ʽ¼�ã���ȷ�ϲμ�", "0", ly_time);
						
						params.put("message", "�̼�¼ȡ�ɹ�");
				}else if(Offer.equals("4")){
					int i = T_enroll_Sql.update_status("4",login_id, job_id);
					if(i == 1){
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						
						T_merchant_Bean t_merchant = T_merchant_Sql.select_id(t_job.getMerchant_id()+"");
						Jdpush_shang.sendPush("�û�ȡ���μӡ�"+t_job.getName()+"��","jianguo"+t_merchant.getLogin_id());
						Jdpusher_shang.sendPush("�û�ȡ���μӡ�"+t_job.getName()+"��","jianguo"+t_merchant.getLogin_id());
						Jdpushcc_shang.sendPush("�û�ȡ���μӡ�"+t_job.getName()+"��","jianguo"+t_merchant.getLogin_id());
						
						T_job_Bean t = T_job_Sql.select_id(job_id);
						if(t.getCount() == 0){
						}else{
							T_job_Sql.update_count_jian(job_id);
						}
						T_job_record_Sql.update_cancel(login_id);
						
						params.put("message", "�û�ȡ���μӳɹ�");
					}else{
					params.put("message", "�û�ȡ���μ�ʧ��");
					}
				}else if(Offer.equals("5")){
					int i = T_enroll_Sql.update_status("5",login_id, job_id);
					if(i == 1){
						T_job_Bean t_job = T_job_Sql.select_id(job_id);
						T_job_info_Bean t_job_info = T_job_info_Sql.select_job_id(job_id);
						
						T_merchant_Bean t_merchant = T_merchant_Sql.select_id(t_job.getMerchant_id()+"");
						Jdpush_shang.sendPush("�û�ȷ�ϲμӡ�"+t_job.getName()+"��","jianguo"+t_merchant.getLogin_id());
						Jdpusher_shang.sendPush("�û�ȷ�ϲμӡ�"+t_job.getName()+"��","jianguo"+t_merchant.getLogin_id());
						Jdpushcc_shang.sendPush("�û�ȷ�ϲμӡ�"+t_job.getName()+"��","jianguo"+t_merchant.getLogin_id());
						
						T_push_Sql.insert(login_id, t_job.getName(), "ȷ�ϲμ�", "�û�ȷ�ϲμӡ�"+t_job.getName()+"��", "0", ly_time);
						
						T_user_login_Bean t_user_login = T_user_login_Sql.select_id(login_id);
						Text_Sms.textdemos6(t_user_login.getTel(),t_job.getName(),t_job_info.getTel());
//						MD_SMS_Info.querencanjia6(t_user_login.getTel(),t_job.getName(),t_job_info.getTel());
						
						params.put("message", "�û�ȷ�ϲμӳɹ�");
					}else{
					params.put("message", "�û�ȷ�ϲμ�ʧ��");
					}
				}else if(Offer.equals("6")){
					int i = T_enroll_Sql.update_status("6",login_id, job_id);
					if(i == 1){
						T_job_Sql.update_count_jian(job_id);
						params.put("message", "�û�ȡ���μӳɹ�");
					}else{
					params.put("message", "�û�ȡ���μ�ʧ��");
					}
				}else if(Offer.equals("7")){
					int i = T_enroll_Sql.update_status("7",login_id, job_id);
					if(i == 1){
						T_job_Bean t = T_job_Sql.select_id(job_id);
						if(t.getCount() == 0){
						}else{
							T_job_Sql.update_count_jian(job_id);
						}
						params.put("message", "�̼�ȡ��¼ȡ�ɹ�");
					}else{
					params.put("message", "�̼�ȡ��¼ȡʧ��");
					}
				}else if(Offer.equals("8")){
					int i = T_enroll_Sql.update_status("8",login_id, job_id);
					if(i == 1){
						params.put("message", "������ʱ��ɹ�");
					}else{
					params.put("message", "������ʱ��ʧ��");
					}
				}else if(Offer.equals("9")){
					int i = T_enroll_Sql.update_status("9",login_id, job_id);
					
					if(i == 1){
						params.put("message", "�̼ҵ�������ɹ�");
					}else{
					params.put("message", "�̼ҵ������ʧ��");
					}
				}else if(Offer.equals("10")){
					int i = T_enroll_Sql.update_status("10",login_id, job_id);
					if(i == 1){
						params.put("message", "�û��߹��ʳɹ�");
					}else{
					params.put("message", "�û��߹���ʧ��");
					}
				}else if(Offer.equals("11")){
					int i = T_enroll_Sql.update_status("11",login_id, job_id);
					if(i == 1){
						params.put("message", "�̼ҽ���ɹ�");
					}else{
					params.put("message", "�̼ҽ���ʧ��");
					}
				}else if(Offer.equals("12")){
					int i = T_enroll_Sql.update_status("12",login_id, job_id);
					if(i == 1){
						params.put("message", "�̼����۳ɹ�");
					}else{
					params.put("message", "�̼�����ʧ��");
					}
				}else if(Offer.equals("13")){
					int i = T_enroll_Sql.update_status("13",login_id, job_id);
					
					if(i == 1){
						params.put("message", "�̼����۳ɹ�");
					}else{
					params.put("message", "�̼�����ʧ��");
					}
				}
				
				params.put("code", "200");
				PrintWriter pw = response.getWriter();
				Gson g = new Gson();
				String str = g.toJson(params); 
				pw.write(str);
				pw.flush();
				pw.close();
			}else{
				params.put("message", "�û�û�б����ü�ְ�����ܲ�����");
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
