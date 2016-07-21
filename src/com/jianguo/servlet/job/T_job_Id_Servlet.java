package com.jianguo.servlet.job;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.bean.T_area_Bean;
import com.jianguo.bean.T_city_Bean;
import com.jianguo.bean.T_job_Bean;
import com.jianguo.bean.T_job_info_Bean;
import com.jianguo.bean.T_merchant_Bean;
import com.jianguo.bean.T_type_Bean;
import com.jianguo.sql.T_job_Sql;
import com.jianguo.sql.T_job_info_Sql;
import com.jianguo.sql.T_merchant_Sql;
import com.jianguo.sql.T_school_Sql;
import com.jianguo.util.Frequently;

public class T_job_Id_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_job_Id_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_job_Id_Servlet?only=8D81DE7AB0D3E338EFE94CE55B32135E&merchant_id=2&type=0
	//http://101.200.205.243:8080/T_job_Id_Servlet?only=43803E576A53ECF4D30D058541BBFA4E&merchant_id=1&type=0&count=0
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_job_Model_List_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();

		String job_id =request.getParameter("job_id");

		//------------------��������--------��ʼ----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){
			//------------------��������--------����----------------------
					T_job_Bean t_job = T_job_Sql.select_id(job_id);
					
					long ll = System.currentTimeMillis()/1000;
					int ii = Integer.parseInt(t_job.getStart_date());
					if(ll >= ii){
						T_job_Sql.update_status("2", job_id);
						
						params.put("message", "�����ѿ�ʼ�������޸ĸü�ְ");
						params.put("code", "500");
						PrintWriter pw = response.getWriter();
						Gson g = new Gson();
						String str = g.toJson(params); 
						pw.write(str);
						pw.flush();
						pw.close();
					}else{
					
					t_job.setModel_name("0");
					
					T_city_Bean t_city = T_school_Sql.select_t_city_id(t_job.getCity_id()+"");
					t_job.setCity_id_name(t_city.getCity());
					
					T_area_Bean t_area = T_school_Sql.select_t_area_id(t_job.getArea_id()+"");
					t_job.setArea_id_name(t_area.getArea_name());
					
					T_type_Bean t_type = T_school_Sql.select_t_type_id(t_job.getType_id()+"");
					t_job.setType_id_name(t_type.getType_name());
					
					T_merchant_Bean t_merchant = T_merchant_Sql.select_id(t_job.getMerchant_id()+"");
					t_job.setMerchant_id_name(t_merchant.getName());
					
					T_job_info_Bean t_job_info = T_job_info_Sql.select_job_id(t_job.getId()+"");
					t_job.setInfo_start_time(t_job_info.getStart_time());
					t_job.setInfo_stop_time(t_job_info.getStop_time());
					t_job.setInfo_set_place(t_job_info.getSet_place());
					t_job.setInfo_set_time(t_job_info.getSet_time());
					t_job.setInfo_limit_sex(t_job_info.getLimit_sex()+"");
					t_job.setInfo_term(t_job_info.getTerm()+"");
					t_job.setInfo_other(t_job_info.getOther()+"");
					t_job.setInfo_work_content(t_job_info.getWork_content()+"");
					t_job.setInfo_work_require(t_job_info.getWork_require()+"");
					t_job.setInfo_tel(t_job_info.getTel());
					
					if(!t_job.getAlike().equals("0")){
						T_job_Bean t_job2 = T_job_Sql.select_alike(t_job.getAlike());
						t_job.setNv_job_id(t_job2.getId()+"");
						t_job.setNv_sum(t_job2.getSum()+"");
						t_job.setNv_count(t_job2.getCount()+"");
					}
					
				Map map = new HashMap();
				map.put("t_job", t_job);
				
				params.put("data", map);
				params.put("message", "��ʷ��ְ��ѯ�ɹ�");
				params.put("code", "200");
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
