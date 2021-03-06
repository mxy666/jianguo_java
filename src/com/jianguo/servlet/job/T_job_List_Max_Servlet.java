package com.jianguo.servlet.job;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.bean.T_job_Bean;
import com.jianguo.sql.T_job_Sql;
import com.jianguo.util.Frequently;

public class T_job_List_Max_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_job_List_Max_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_job_List_Max_Servlet?only=AEEB31108665D33C9ED84D8DF1185E3E&city_id=3&count=0
	//http://101.200.205.243:8080/T_job_List_Max_Servlet?only=492496461AE7016D1D7371F051132214&hot=1&count=0&city_id=3
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_job_List_Max_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();

		String count =request.getParameter("count");
		String city_id =request.getParameter("city_id");
		
		//------------------访问限制--------开始----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){
			//------------------访问限制--------结束----------------------

//			SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date beginDate = new Date();
//			Calendar date = Calendar.getInstance();
//			date.setTime(beginDate);
//			date.set(Calendar.DATE, date.get(Calendar.DATE) - 3);
//			long timeStemp = 0;
//			try {
//				Date endDate = dft.parse(dft.format(date.getTime()));
//				SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				String sd = sdf2.format(endDate);
//				 Date dates=sdf2.parse(sd);
//				 timeStemp = dates.getTime();
//				System.out.println("----"+sd+"----"+timeStemp);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			long ll = System.currentTimeMillis()/1000;
//			long ll = timeStemp/1000;
			List<T_job_Bean> list_t_job = null;
				list_t_job = T_job_Sql.select_max(city_id,ll+"",count);

			Map map = new HashMap();
			map.put("list_t_job", list_t_job);

			params.put("data", map);
			params.put("message", "兼职信息查询成功");
			params.put("code", "200");
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params); 
			pw.write(str);
			pw.flush();
			pw.close();
			
			//------------------访问限制--------开始----------------------
		}else{
			params.put("message", "无效访问");
			params.put("code", "404");
			PrintWriter pw = response.getWriter();
			Gson g = new Gson();
			String str = g.toJson(params); 
			pw.write(str);
			pw.flush();
			pw.close();
		}
		//------------------访问限制--------结束----------------------
	}
}
