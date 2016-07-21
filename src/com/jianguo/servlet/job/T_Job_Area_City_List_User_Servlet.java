package com.jianguo.servlet.job;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.jianguo.bean.T_area_Bean;
import com.jianguo.bean.T_city_Bean;
import com.jianguo.bean.T_type_Bean;
import com.jianguo.sql.T_school_Sql;
import com.jianguo.util.Frequently;

public class T_Job_Area_City_List_User_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_Job_Area_City_List_User_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.132/JianGuo_Server/T_Job_Area_City_List_User_Servlet?only=8BE28DACD04482E3481C3BF51A3F0089&city_id=010
	//http://101.200.205.243:8080/T_Job_Area_City_List_User_Servlet?only=B59A663DEE102A901FDA75E75BA3ABF0&city_id=1
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_Job_Area_City_List_User_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();

		String login_id =request.getParameter("login_id");
		String city_id =request.getParameter("city_id");

		//------------------��������--------��ʼ----------------------
		String only =request.getParameter("only");
		String ss_only = Frequently.daycount();
		String ss_only2 = Frequently.daycount2();
		String ss_only3 = Frequently.daycount3();
		if(only.equals(ss_only) || only.equals(ss_only2) || only.equals(ss_only3)){
			//------------------��������--------����----------------------

			List<T_city_Bean> list_t_city = null;
			if(city_id == "" || city_id == null){
				list_t_city = T_school_Sql.select_All_city();
			}else{
//				System.out.println("----"+city_id+"-----------");
				String ss = "";
				if(city_id.equals("010")){
					ss = "3";
				}
				if(city_id.equals("0899")){
					ss = "1";
				}
				if(city_id.equals("0898")){
					ss = "2";
				}
				if(city_id.equals("0571")){
					ss = "4";
				}
				if(city_id.equals("029")){
					ss = "5";
				}
				if(city_id.equals("3")){
					ss = "3";
				}
				if(city_id.equals("1")){
					ss = "1";
				}
				if(city_id.equals("2")){
					ss = "2";
				}
				if(city_id.equals("4")){
					ss = "4";
				}
				if(city_id.equals("5")){
					ss = "5";
				}
				
//				list_t_city = T_school_Sql.select_All_city_id(ss);
				list_t_city = T_school_Sql.select_All_city();
			}
			List<T_city_Bean> list_t_city2 = new ArrayList<T_city_Bean>();
			for (int i = 0; i < list_t_city.size(); i++) {
				T_city_Bean t_city = list_t_city.get(i);
				List<T_area_Bean> list_t_area = new ArrayList<T_area_Bean>();
				List<T_area_Bean> list_t_area2 = new ArrayList<T_area_Bean>();
				list_t_area = T_school_Sql.select_All_area(t_city.getId()+"");
				
				T_area_Bean t_area = new T_area_Bean();;
				t_area.setId(0);
				t_area.setCity_id(0);
				t_area.setArea_name("��������");
				list_t_area2.add(t_area);
				
				for (int j = 0; j < list_t_area.size(); j++) {
					T_area_Bean t_area2 = list_t_area.get(j);
					
					list_t_area2.add(t_area2);
				}
				
				t_city.setList_t_area(list_t_area2);

				list_t_city2.add(t_city);
			}
			List<T_type_Bean> list_t_type = T_school_Sql.select_All_type();
			List<T_type_Bean> list_t_type2 = new ArrayList<T_type_Bean>();
			
			T_type_Bean t = new T_type_Bean();
			t.setId(0);
			t.setType_name("ְҵ����");
			
			list_t_type2.add(t);
			for (int i = 0; i < list_t_type.size(); i++) {
				T_type_Bean ttt = list_t_type.get(i);
				
				list_t_type2.add(ttt);
			}
			
				Map map = new HashMap();
				map.put("list_t_city2", list_t_city2);
				map.put("list_t_type", list_t_type2);

				params.put("data", map);
				params.put("message", "��ȡ������Ϣ�ɹ�");
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
