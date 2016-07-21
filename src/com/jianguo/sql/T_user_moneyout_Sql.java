package com.jianguo.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jianguo.bean.T_user_money_Bean;
import com.jianguo.bean.T_user_moneyout_Bean;
import com.jianguo.util.DButil;

public class T_user_moneyout_Sql {

	//�жϸ��ֻ����Ƿ���ע��
	public static boolean check(String login_id,String job_id){
		Connection conn=DButil.getCon();
		boolean b = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from t_user_moneyout where login_id=? and job_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login_id);
			pstmt.setString(2, job_id);
			rs = pstmt.executeQuery();
			b = rs.next();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public static int insert(String login_id,String money,String type,String status,String time){
		int num=0;
		Connection conn=DButil.getCon();
		String sql="insert into t_user_moneyout(login_id,money,type,status,time) values(?,?,?,?,?)";
		PreparedStatement pst=DButil.getPstm(conn, sql);
		try {
			pst.setString(1, login_id);
			pst.setString(2, money);
			pst.setString(3, type);
			pst.setString(4, status);
			pst.setString(5, time);
			num=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			DButil.close(conn);
			DButil.psClose(pst);
		}
		return num;
	}
	
	public static List<T_user_moneyout_Bean> select_All_name(String login_id,String count){
		List<T_user_moneyout_Bean> list=new ArrayList<T_user_moneyout_Bean>();
		ResultSet rs=null;
		Connection conn=DButil.getCon();
		String sql = "select * from t_user_moneyout where login_id=? order by id desc limit "+count+",10";
		PreparedStatement psmt = DButil.getPstm(conn, sql);
		try {
			psmt.setString(1,login_id);
			rs=psmt.executeQuery();
			while(rs.next()){
				
				T_user_moneyout_Bean t_user_moneyout = new T_user_moneyout_Bean();
				t_user_moneyout.setId(rs.getInt("id"));
				t_user_moneyout.setLogin_id(rs.getInt("login_id"));
				t_user_moneyout.setMoney(rs.getDouble("money"));
				t_user_moneyout.setType(rs.getInt("type"));
				t_user_moneyout.setStatus(rs.getInt("status"));
				t_user_moneyout.setTime(rs.getString("time")+"");
				t_user_moneyout.setRemarks(rs.getString("remarks")+"");
				list.add(t_user_moneyout);
			}
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
	
	public static List<T_user_moneyout_Bean> select_All(){
		List<T_user_moneyout_Bean> list=new ArrayList<T_user_moneyout_Bean>();
		ResultSet rs=null;
		Connection conn=DButil.getCon();
		String sql = "select * from t_user_moneyout where status=0";
		PreparedStatement psmt = DButil.getPstm(conn, sql);
		try {
			rs=psmt.executeQuery();
			while(rs.next()){
				T_user_moneyout_Bean t_user_moneyout = new T_user_moneyout_Bean();
				t_user_moneyout.setId(rs.getInt("id"));
				t_user_moneyout.setLogin_id(rs.getInt("login_id"));
				t_user_moneyout.setMoney(rs.getDouble("money"));
				t_user_moneyout.setType(rs.getInt("type"));
				t_user_moneyout.setStatus(rs.getInt("status"));
				t_user_moneyout.setTime(rs.getString("time")+"");
				t_user_moneyout.setRemarks(rs.getString("remarks")+"");
				list.add(t_user_moneyout);
			}
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
	
	public static List<T_user_moneyout_Bean> select_All_ok(String count){
		List<T_user_moneyout_Bean> list=new ArrayList<T_user_moneyout_Bean>();
		ResultSet rs=null;
		Connection conn=DButil.getCon();
		String sql = "select * from t_user_moneyout where status=1 order by id desc limit "+count+",100";
		PreparedStatement psmt = DButil.getPstm(conn, sql);
		try {
			rs=psmt.executeQuery();
			while(rs.next()){
				T_user_moneyout_Bean t_user_moneyout = new T_user_moneyout_Bean();
				t_user_moneyout.setId(rs.getInt("id"));
				t_user_moneyout.setLogin_id(rs.getInt("login_id"));
				t_user_moneyout.setMoney(rs.getDouble("money"));
				t_user_moneyout.setType(rs.getInt("type"));
				t_user_moneyout.setStatus(rs.getInt("status"));
				t_user_moneyout.setTime(rs.getString("time")+"");
				t_user_moneyout.setRemarks(rs.getString("remarks")+"");
				list.add(t_user_moneyout);
			}
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
	
	public static List<T_user_moneyout_Bean> select_All_okss(){
		List<T_user_moneyout_Bean> list=new ArrayList<T_user_moneyout_Bean>();
		ResultSet rs=null;
		Connection conn=DButil.getCon();
		String sql = "select * from t_user_moneyout where status=1 order by id desc";
		PreparedStatement psmt = DButil.getPstm(conn, sql);
		try {
			rs=psmt.executeQuery();
			while(rs.next()){
				T_user_moneyout_Bean t_user_moneyout = new T_user_moneyout_Bean();
				t_user_moneyout.setId(rs.getInt("id"));
				t_user_moneyout.setLogin_id(rs.getInt("login_id"));
				t_user_moneyout.setMoney(rs.getDouble("money"));
				t_user_moneyout.setType(rs.getInt("type"));
				t_user_moneyout.setStatus(rs.getInt("status"));
				t_user_moneyout.setTime(rs.getString("time")+"");
				t_user_moneyout.setRemarks(rs.getString("remarks")+"");
				list.add(t_user_moneyout);
			}
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
	
	public static List<T_user_moneyout_Bean> select_All_ok_sum(){
		List<T_user_moneyout_Bean> list=new ArrayList<T_user_moneyout_Bean>();
		ResultSet rs=null;
		Connection conn=DButil.getCon();
		String sql = "select id,money from t_user_moneyout where status=1";
		PreparedStatement psmt = DButil.getPstm(conn, sql);
		try {
			rs=psmt.executeQuery();
			while(rs.next()){
				T_user_moneyout_Bean t_user_moneyout = new T_user_moneyout_Bean();
				t_user_moneyout.setId(rs.getInt("id"));
//				t_user_moneyout.setLogin_id(rs.getInt("login_id"));
				t_user_moneyout.setMoney(rs.getDouble("money"));
//				t_user_moneyout.setType(rs.getInt("type"));
//				t_user_moneyout.setStatus(rs.getInt("status"));
//				t_user_moneyout.setTime(rs.getString("time")+"");
//				t_user_moneyout.setRemarks(rs.getString("remarks")+"");
				list.add(t_user_moneyout);
			}
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
	
	public static T_user_moneyout_Bean select_id(String id){
		ResultSet rs=null;
		T_user_moneyout_Bean t_user_moneyout = new T_user_moneyout_Bean();
		Connection conn=DButil.getCon();
		String sql = "select * from t_user_moneyout where id=?";
		PreparedStatement psmt = DButil.getPstm(conn, sql);
		try {
			psmt.setString(1,id);
			rs=psmt.executeQuery();
			while(rs.next()){
				t_user_moneyout.setId(rs.getInt("id"));
				t_user_moneyout.setLogin_id(rs.getInt("login_id"));
				t_user_moneyout.setMoney(rs.getDouble("money"));
				t_user_moneyout.setType(rs.getInt("type"));
				t_user_moneyout.setStatus(rs.getInt("status"));
				t_user_moneyout.setTime(rs.getString("time")+"");
				t_user_moneyout.setRemarks(rs.getString("remarks")+"");
			}
			psmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DButil.close(conn);
		}
		return t_user_moneyout;
	}
	
	public static int update_status(String status,String id){
		int num=0;
		try {
			Connection conn=DButil.getCon();
			String sql = "update t_user_moneyout set status=? where id=?";
			PreparedStatement psmt = DButil.getPstm(conn, sql);
			psmt.setString(1, status);
			psmt.setString(2, id);
			num=psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public static int update_status_no(String status,String remarks,String id){
		int num=0;
		try {
			Connection conn=DButil.getCon();
			String sql = "update t_user_moneyout set status=?,remarks=? where id=?";
			PreparedStatement psmt = DButil.getPstm(conn, sql);
			psmt.setString(1, status);
			psmt.setString(2, remarks);
			psmt.setString(3, id);
			num=psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public static int delete_id(String id){
		int num=0;
		PreparedStatement pstmt = null;
		Connection conn=DButil.getCon();
		try {
			String sql = "delete from t_user_moneyout where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			num = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
}
