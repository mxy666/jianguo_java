package com.jianguo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.jianguo.sql.T_tel_code_Sql;

public class Text_Sms {

	private final static String APP_KEY = "6eb1ac1683e252354051958c3eae100d";
	private final static String APP_NAME = "�����ְ";

	public static String textdemos(String user_username) {
		// TODO Auto-generated method stub
		long random =(long)((Math.random()*9+1)*100000);
		String code = random+"";
		String job_test = "�������ְ����ӭʹ�ü����ְ�������ֻ���֤����"+code+"����Ч��Ϊ20���ӣ��뾡����֤��������Ϣ����ظ�";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);

	if(!user_username.equals("13614093590")){
		if(T_tel_code_Sql.check_tel(user_username)){
			T_tel_code_Sql.update_tel(code, user_username);
		}else{
			T_tel_code_Sql.insert(user_username, code);
		}
	}
		return code;
	}

//		public static String textdemos(String mobile) {
//			// TODO Auto-generated method stub
//			String tpl_id = "2255";
//			String timeout = "20";
//	//		String mobile = phone;
//			
//			long random =(long)((Math.random()*9+1)*100000);
//			String code = random+"";
//	//		String code = "111111";
//			
//			if(!mobile.equals("13614093590")){
//			
//			if(T_tel_code_Sql.check_tel(mobile)){
//				T_tel_code_Sql.update_tel(code, mobile);
//			}else{
//				T_tel_code_Sql.insert(mobile, code);
//			}
//			}
//			String charset = "UTF-8";
//			String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#code#=").append(code).append("&#hour#=").append(timeout).toString();
//	//		JSONObject object = null;
//			try {
//					tpl_values = URLEncoder.encode(tpl_values, charset);
//					String url = "http://v.juhe.cn/sms/send?key=";
//					String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
//					// �õ�JSON�ַ���
//					gets(urlAll, charset);
//					// ת��ΪJSON��
//	//				object = JSONObject.fromObject(jsonResult);
//	
//			} catch (UnsupportedEncodingException e) {
//	//			e.printStackTrace();
//				return code;
//			}
//			return code;
//		}


	public static void textdemos1212(String user_username,String tel) {
		// TODO Auto-generated method stub
		String job_test = "�������ְ��ͯЬ��С�����ѽ����ı��������͸��̼��ˣ������ϲ���绰��ѯ�̼�"+tel+"���ྫ�����ע���ǹٷ�΢�Ź��ںţ����job";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}
	
	
//	public static void textdemos1(String user_username) {
//		// TODO Auto-generated method stub
//		String job_test = "�������ְ��ͯЬ��С�����ѽ����ı��������͸��̼��ˣ������ĵȴ��ɣ����ྫ�����ע���ǹٷ�΢�Ź��ںţ����job";
//		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
//		Server_Get.get(url);
//	}


		public static String textdemos1(String mobile) {
			// TODO Auto-generated method stub
			String tpl_id = "14261";
			String timeout = "20";
	//		String mobile = phone;
			
			long random =(long)((Math.random()*9+1)*100000);
			String code = random+"";
			
			String charset = "UTF-8";
			String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append(timeout).toString();
	//		JSONObject object = null;
			try {
				tpl_values = URLEncoder.encode(tpl_values, charset);
				String url = "http://v.juhe.cn/sms/send?key=";
				String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
				// �õ�JSON�ַ���
				gets(urlAll, charset);
				// ת��ΪJSON��
	//				object = JSONObject.fromObject(jsonResult);
				
			} catch (UnsupportedEncodingException e) {
	//			e.printStackTrace();
				return code;
			}
			return code;
		}


	public static void textdemos2(String user_username,String job_name,String tel) {
		// TODO Auto-generated method stub
//		String job_test = "�������ְ������ò�ڲŻ���һ����㱨����("+job_name+")�ѱ��̼�¼�ã���ǰ���ҵļ�ְ��ȷ�ϲμӸü�ְ��������ʱȷ�ϻᱻ�̼Ҿܾ�Ŷ�����ྫ�����ע�ٷ�΢�Ź��ںţ����job��";
		String job_test = "�������ְ������ò�ڲŻ���һ����㱨����("+job_name+")�ѱ��̼�¼�ã��밴�̼�Ҫ��׼��������ǧ��Ҫ�Ÿ���Ŷ�����������������ϵ�̼ң�"+tel+"��";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}

//		public static String textdemos2(String mobile,String name) {
//			// TODO Auto-generated method stub
//			String tpl_id = "14262";
//			String timeout = "20";
////			String mobile = phone;
//			long random =(long)((Math.random()*9+1)*100000);
//			String code = random+"";
//			String charset = "UTF-8";
//			String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#name#=").append(name).toString();
////			JSONObject object = null;
//			try {
//				tpl_values = URLEncoder.encode(tpl_values, charset);
//				String url = "http://v.juhe.cn/sms/send?key=";
//				String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
//				// �õ�JSON�ַ���
//				gets(urlAll, charset);
//				// ת��ΪJSON��
////					object = JSONObject.fromObject(jsonResult);
//			} catch (UnsupportedEncodingException e) {
////				e.printStackTrace();
//				return code;
//			}
//			return code;
//		}


	public static void textdemos32(String user_username,String job_name) {
		// TODO Auto-generated method stub
		String job_test = "�������ְ����Ǹ���̼ҿ��ܸ߶Ƚ���û�з�����ĲŻ��� ��ı���("+job_name+")��������ܾ��ˣ����ྫ�����ע�ٷ�΢�Ź��ںţ����job��";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}


//		public static String textdemos32(String mobile,String name) {
//			// TODO Auto-generated method stub
//			String tpl_id = "14263";
//			String timeout = "20";
//	//		String mobile = phone;
//			
//			long random =(long)((Math.random()*9+1)*100000);
//			String code = random+"";
//			
//			String charset = "UTF-8";
//			String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#name#=").append(name).toString();
//	//		JSONObject object = null;
//			try {
//				tpl_values = URLEncoder.encode(tpl_values, charset);
//				String url = "http://v.juhe.cn/sms/send?key=";
//				String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
//				// �õ�JSON�ַ���
//				gets(urlAll, charset);
//				// ת��ΪJSON��
//	//				object = JSONObject.fromObject(jsonResult);
//				
//			} catch (UnsupportedEncodingException e) {
//	//			e.printStackTrace();
//				return code;
//			}
//			return code;
//		}


	public static void textdemos4(String user_username,String job_name,String money) {
		// TODO Auto-generated method stub
		String job_test = "�������ְ��С������ͣ��İ�("+job_name+")��ְ"+money+"Ԫ���ʷ��������Ǯ�����ע����ա����ྫ�����ע�ٷ�΢�Ź��ںţ����job��";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}


//		public static String textdemos4(String mobile,String name,String money) {
//			// TODO Auto-generated method stub
//			String tpl_id = "14265";
//			String timeout = "20";
//	//		String mobile = phone;
//			
//			long random =(long)((Math.random()*9+1)*100000);
//			String code = random+"";
//			
//			String charset = "UTF-8";
//			String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#name#=").append(name).append("&#money#=").append(money).toString();
//	//		JSONObject object = null;
//			try {
//				tpl_values = URLEncoder.encode(tpl_values, charset);
//				String url = "http://v.juhe.cn/sms/send?key=";
//				String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
//				// �õ�JSON�ַ���
//				gets(urlAll, charset);
//				// ת��ΪJSON��
//	//				object = JSONObject.fromObject(jsonResult);
//				
//			} catch (UnsupportedEncodingException e) {
//	//			e.printStackTrace();
//				return code;
//			}
//			return code;
//		}


//	public static void textdemos6(String user_username,String job_name,String tel) {
//		// TODO Auto-generated method stub
//		String job_test = "�������ְ������ȷ�ϲμ�("+job_name+")��ְ���밴�̼�Ҫ��׼��������ǧ��Ҫ�Ÿ���Ŷ����Ϊ���кܶ��ڹ���ѧ��ͬѧ��Ҫ��ݹ��������������������ϵ�̼ң�"+tel+"�����ྫ�����ע�ٷ�΢�Ź��ںţ����job";
//		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
//		Server_Get.get(url);
//	}


		public static String textdemos6(String mobile,String name,String tel) {
			// TODO Auto-generated method stub
			String tpl_id = "15411";
			String timeout = "20";
	//		String mobile = phone;
			
			long random =(long)((Math.random()*9+1)*100000);
			String code = random+"";
			
			String charset = "UTF-8";
			String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#name#=").append(name).append("&#tel#=").append(tel).toString();
	//		JSONObject object = null;
			try {
				tpl_values = URLEncoder.encode(tpl_values, charset);
				String url = "http://v.juhe.cn/sms/send?key=";
				String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
				// �õ�JSON�ַ���
				gets(urlAll, charset);
				// ת��ΪJSON��
	//				object = JSONObject.fromObject(jsonResult);
				
			} catch (UnsupportedEncodingException e) {
	//			e.printStackTrace();
				return code;
			}
			return code;
		}


//	public static void textdemos5(String user_username,String job_name,String truename,String sex,String phone,String school) {
//		// TODO Auto-generated method stub
//		String job_test = "�������ְ���������ļ�ְ��Ϣ("+job_name+")�����˲μӡ�"+truename+"��"+sex+"��"+phone+"��"+school+"��";
//		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
//		Server_Get.get(url);
//	}


		public static String textdemos5(String mobile,String job_title,String truename,String sex,String phone,String school) {
			// TODO Auto-generated method stub
			String tpl_id = "5548";
			String timeout = "20";
	//		String mobile = phone;
			
			long random =(long)((Math.random()*9+1)*100000);
			String code = random+"";
			
			String charset = "UTF-8";
			String tpl_values = new StringBuffer("#app#=").append(APP_NAME).append("&#job_title#=").append(job_title).append("&#truename#=").append(truename).append("&#sex#=").append(sex).append("&#phone#=").append(phone).append("&#school#=").append(school).toString();
	//		JSONObject object = null;
			try {
				tpl_values = URLEncoder.encode(tpl_values, charset);
				String url = "http://v.juhe.cn/sms/send?key=";
				String urlAll = new StringBuffer(url).append(APP_KEY).append("&dtype=json&mobile=").append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=").append(tpl_values).toString();
				// �õ�JSON�ַ���
				gets(urlAll, charset);
				// ת��ΪJSON��
	//				object = JSONObject.fromObject(jsonResult);
				
			} catch (UnsupportedEncodingException e) {
	//			e.printStackTrace();
				return code;
			}
			return code;
		}

	/**
	 * 
	 * @param urlAll
	 *            :����ӿ�
	 * @param charset
	 *            :�ַ�����
	 * @return ����json���
	 */
	public static String gets(String urlAll, String charset) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
		try {
			URL url = new URL(urlAll);
			HttpURLConnection connection = (HttpURLConnection) url
			.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(30000);
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("User-agent", userAgent);
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, charset));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
