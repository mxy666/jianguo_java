package com.jianguo.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jianguo.bean.T_use_Money_Bean;
import com.jianguo.bean.T_user_resume_Bean;
import com.jianguo.util.DButil;
import com.jianguo.util.PageModel;

public class T_push_new_Sql {
	 public static List<T_user_resume_Bean> queryAll(String cityId,String school,String tel,String sex){
		 Connection conn=DButil.getCon();
		// List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		 List <T_user_resume_Bean>list=new ArrayList<T_user_resume_Bean>();
		 ResultSet rs=null;
		 StringBuffer str = new StringBuffer(); 
	     String sql="select a.id,b.name,b.sex, a.tel,b.school,a.city_id from t_user_login a,t_user_resume b where b.login_id=a.id ";		 

	     if(cityId!=null&&!cityId.equals("")){
			 str.append(" and a.city_id like'%"+cityId+"%' ");
			 
		 }
		 if(tel!=null&&!tel.equals("")){
			 str.append(" and a.tel ="+tel+" ");
			 
		 }
		 if(school!=null&&!school.equals("")){
			 str.append(" and b.school like'%"+school+"%' ");
			 
		 }
		 /*if(){
			0=女，1=男 
		 }*/
		 int sexNum=0;
		 if(sex!=null&&sex!=""){
			 if(sex.equals("女")){
				 sexNum=0;
				 
			 }else if(sex.equals("男")){
				 sexNum=1;
				 
			 }
			 
			 str.append(" and b.sex='"+sexNum+"'");
			 
		 }
		 sql=sql+str.toString();
		 System.out.println(sql+"----------------------------------------");
		 PreparedStatement psmt = DButil.getPstm(conn, sql);
			try {
				rs=psmt.executeQuery();
				while(rs.next()){
					T_user_resume_Bean pushObj = new T_user_resume_Bean();
					pushObj.setId(rs.getInt("id"));
					pushObj.setSex(rs.getInt("sex"));
					pushObj.setCityId(rs.getString("city_id"));
					pushObj.setSchool(rs.getString("school"));
					pushObj.setName(rs.getString("name"));
					pushObj.setTel(rs.getString("tel"));

				
					list.add(pushObj);
				}
					/* ResultSetMetaData md = rs.getMetaData();
					  int columnCount = md.getColumnCount();
				        while (rs.next()) {
				            Map<String, Object> rowData = new HashMap<String, Object>();
				            for (int i = 1; i <= columnCount; i++) {
				                rowData.put(md.getColumnName(i), rs.getObject(i));
				            }
				           // list.add(rowData);
				        }*/
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DButil.close(conn);
			}
		return list;
	}
	 
	//分页---
		public static PageModel<T_user_resume_Bean> queryAllT(PageModel page,String cityId,String school,String tel,String sex){
		    Connection conn=DButil.getCon();
		    List <T_user_resume_Bean>list=new ArrayList<T_user_resume_Bean>();
			 ResultSet rs=null;
			 StringBuffer str = new StringBuffer();
			 String sql="select a.id, b.name,b.sex, a.tel,b.school,a.city_id from t_user_login a,t_user_resume b where b.login_id=a.id ";
			 
			 
			 if(cityId!=null&&!cityId.equals("")){
				 str.append(" and a.city_id like'%"+cityId+"%' ");
				 
			 }
			 if(tel!=null&&!tel.equals("")){
				 str.append(" and a.tel ="+tel+" ");
				 
			 }
			 if(school!=null&&!school.equals("")){
				 str.append(" and b.school like'%"+school+"%' ");
				 
			 }
			 /*if(){
				0=女，1=男 
			 }*/
			 int sexNum=0;
			 if(sex!=null&&sex!=""){
				 if(sex.equals("女")){
					 sexNum=0;
					 
				 }else if(sex.equals("男")){
					 sexNum=1;
					 
				 }
				 
				 str.append(" and b.sex='"+sexNum+"'");
				 
			 }
			 sql=sql+str.toString()+"order by a.id desc limit "+page.getFirstResult()+","+page.getPageSize();;
			 PreparedStatement psmt = DButil.getPstm(conn, sql);
				try {
					rs=psmt.executeQuery();
					
					rs=psmt.executeQuery();
					while(rs.next()){
						T_user_resume_Bean pushObj = new T_user_resume_Bean();
						pushObj.setId(rs.getInt("id"));
						pushObj.setSex(rs.getInt("sex"));
						pushObj.setCityId(rs.getString("city_id"));
						pushObj.setSchool(rs.getString("school"));
						pushObj.setName(rs.getString("name"));
						pushObj.setTel(rs.getString("tel"));

					
						list.add(pushObj);
					        }
					psmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DButil.close(conn);
			}
			page.setList(list);
			selectAll_count(page,cityId,school,tel,sex);
			return page;
		}
		
		//分页---->统计总条数
		public static void selectAll_count(PageModel<T_user_resume_Bean> page,String cityId,String school,String tel,String sex){
			 List <T_user_resume_Bean>list=new ArrayList<T_user_resume_Bean>();
		     ResultSet rs=null;
		    Connection conn=DButil.getCon();
		    StringBuffer str = new StringBuffer();
		    String sql="select count(a.id) from t_user_login a,t_user_resume b where b.login_id=a.id";
		    if(cityId!=null&&!cityId.equals("")){
				 str.append(" and a.city_id like'%"+cityId+"%' ");
				 
			 }
		    if(tel!=null&&!tel.equals("")){
				 str.append(" and a.tel ="+tel+" ");
				 	
			 }
			 if(school!=null&&!school.equals("")){
				 str.append(" and b.school like'%"+school+"%' ");
				 
			 }
			 /*if(){
				0=女，1=男 
			 }*/
			 int sexNum=0;
			 if(sex!=null&&sex!=""){
				 if(sex.equals("女")){
					 sexNum=0;
					 
				 }else if(sex.equals("男")){
					 sexNum=1;
					 
				 }
				 
				 str.append(" and b.sex='"+sexNum+"'");
				 
			 }
			sql=sql+str.toString();
		    Statement sta=DButil.getSta(conn);
		    int i = 0;
		    try { 
				rs=sta.executeQuery(sql);
				while(rs.next())
				{  
				i=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				DButil.staClose(sta);
				DButil.close(conn);
			}
			page.setTotalRecords(i);
		}
	 
	 

}
