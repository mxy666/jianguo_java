package com.jianguo.servlet.jpush;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jianguo.bean.T_use_Money_Bean;
import com.jianguo.bean.T_user_resume_Bean;
import com.jianguo.servlet.jpush.action.PushAction;
import com.jianguo.sql.T_push_Sql;
import com.jianguo.sql.T_push_new_Sql;
import com.jianguo.sql.T_useMoney_Sql;
import com.jianguo.util.Jdpush;
import com.jianguo.util.Jdpushcc;
import com.jianguo.util.Jdpusher;
import com.jianguo.util.PageModel;

public class T_to_push_Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public T_to_push_Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("---T_to_push_Servlet---");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		String cityId=request.getParameter("cityId");
		String school=request.getParameter("school");
		String tel=request.getParameter("tel");
		String sex=request.getParameter("sex");
		
		int pageNo =Integer.parseInt(request.getParameter("pageNo"));
		PageModel page = new PageModel();
		if(pageNo != 0 ){
			page.setPageNo(pageNo);
		}
		page = (PageModel) T_push_new_Sql.queryAllT(page,cityId,school,tel,sex);
		request.setAttribute("page", page);
		
		List<T_user_resume_Bean>pushObj =T_push_new_Sql.queryAll(cityId,school,tel,sex);
//		for(int i=0;i<pushObj.size(); i++){
//			if(pushObj.get(i).getSex()==0){
//				pushObj.get(i).setSexnew("Å®");
//				System.out.println(pushObj.get(i).getSex()+"---"+pushObj.get(i).getSexnew());
//			}else if(pushObj.get(i).getSex()==1){
//				System.out.println(pushObj.get(i).getSex()+"==="+pushObj.get(i).getSexnew());
//				pushObj.get(i).setSexnew("ÄÐ");
//			}
//			pushObj.add(e);
//		}
		
		
//		if(cityId != "" || cityId != null){
			request.setAttribute("cityId", cityId);
//		}else if(school != "" || school != null){
			request.setAttribute("school", school);
			System.out.println(school+"--------");
//		}else if(tel != "" || tel != null){
			request.setAttribute("tel", tel);
//		}else if(sex != "" || sex != null){
			request.setAttribute("sex", sex);
//		}
		
		request.setAttribute("pushObj", pushObj);

		request.getRequestDispatcher("interaction\\push.jsp").forward(request, response);
		
		
	}

	

	
}
