package com.jianguo.servlet.pc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jianguo.bean.T_user_login_Bean;
import com.jianguo.bean.T_user_realname_Bean;
import com.jianguo.sql.T_push_Sql;
import com.jianguo.sql.T_user_login_Sql;
import com.jianguo.sql.T_user_realname_Sql;
import com.jianguo.util.Jdpush;
import com.jianguo.util.Jdpush_realname;
import com.jianguo.util.Jdpushcc;
import com.jianguo.util.Jdpushcc_realname;
import com.jianguo.util.Jdpusher;
import com.jianguo.util.Jdpusher_realname;

public class T_user_realname_Pass_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public T_user_realname_Pass_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	//http://192.168.1.233/JianGuo_Server/T_user_realname_List_Servlet?only=3016E9490D2C47F18954E1277DCA873E&tel=18631017353&password=3
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		System.out.println("---T_user_realname_List_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map params =  new HashMap();

		String login_id =request.getParameter("login_id");
		String pass =request.getParameter("pass");
		String beizhu =request.getParameter("beizhu");
		String qita =request.getParameter("qita");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ly_time = sdf.format(new java.util.Date());
		
			if(pass.equals("0")){
				if(qita.equals("��")){
				Jdpush_realname.sendPush("���ύ��ʵ����Ϣ���ܣ�"+beizhu,"jianguo"+login_id);
				Jdpusher_realname.sendPush("���ύ��ʵ����Ϣ���ܣ�"+beizhu,"jianguo"+login_id);
				Jdpushcc_realname.sendPush("���ύ��ʵ����Ϣ���ܣ�"+beizhu,"jianguo"+login_id);
				T_user_login_Sql.update_status("4", login_id);
				T_push_Sql.insert(login_id, "ʵ������", "ʵ��", "���ύ��ʵ����Ϣ���ܣ�"+beizhu,"2", ly_time);
				}else{
					Jdpush_realname.sendPush("���ύ��ʵ����Ϣ���ܣ�"+qita,"jianguo"+login_id);
					Jdpusher_realname.sendPush("���ύ��ʵ����Ϣ���ܣ�"+qita,"jianguo"+login_id);
					Jdpushcc_realname.sendPush("���ύ��ʵ����Ϣ���ܣ�"+qita,"jianguo"+login_id);
					T_user_login_Sql.update_status("4", login_id);
					T_push_Sql.insert(login_id, "ʵ������", "ʵ��", "���ύ��ʵ����Ϣ���ܣ�"+beizhu,"2", ly_time);
				}
			}else if(pass.equals("1")){
				Jdpush_realname.sendPush("���ύ��ʵ����Ϣ��ͨ��","jianguo"+login_id);
				Jdpusher_realname.sendPush("���ύ��ʵ����Ϣ��ͨ��","jianguo"+login_id);
				Jdpushcc_realname.sendPush("���ύ��ʵ����Ϣ��ͨ��","jianguo"+login_id);
				T_user_login_Sql.update_status("2", login_id);
				T_push_Sql.insert(login_id, "ʵ��ͨ��", "ʵ��", "���ύ��ʵ����Ϣ��ͨ��","1", ly_time);
		}
		
		List<T_user_login_Bean> list_t_login = T_user_login_Sql.select_list("3");
		List<T_user_realname_Bean> list_t_user_realname = new ArrayList<T_user_realname_Bean>();
		for (int i = 0; i < list_t_login.size(); i++) {
			T_user_login_Bean t_user_login = list_t_login.get(i);
			T_user_realname_Bean t_user_realname = T_user_realname_Sql.select_login_id(t_user_login.getId()+"");
			list_t_user_realname.add(t_user_realname);
		}
		request.setAttribute("list_t_user_realname", list_t_user_realname);
		request.getRequestDispatcher("user_realname_list.jsp").forward(request, response);
	}
}
