package com.jianguo.servlet.sms;

import com.jianguo.util.Server_Get;

public class MD_SMS_Info {

	public static String yanzhengma0ss(String user_username) {
		// TODO Auto-generated method stub
		long random =(long)((Math.random()*9+1)*100000);
		String test = random+"";
		String job_test = "�������ְ����ӭʹ�ü����ְ�������ֻ���֤����"+test+"����Ч��Ϊ20���ӣ��뾡����֤��������Ϣ����ظ�";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
		return test;
	}
	
	public static void baoming1(String user_username) {
		// TODO Auto-generated method stub
		String job_test = "�������ְ��ͯЬ��С�����ѽ����ı��������͸��̼��ˣ������ĵȴ��ɣ����ྫ�����ע���ǹٷ�΢�Ź��ںţ����job";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}
	
	public static void luyong2(String user_username,String job_name) {
		// TODO Auto-generated method stub
		String job_test = "�������ְ������ò�ڲŻ���һ����㱨����("+job_name+")�ѱ��̼�¼�ã���ǰ���ҵļ�ְ��ȷ�ϲμӸü�ְ��������ʱȷ�ϻᱻ�̼Ҿܾ�Ŷ�����ྫ�����ע�ٷ�΢�Ź��ںţ����job��";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}

	public static void jujue32(String user_username,String job_name) {
		// TODO Auto-generated method stub
		String job_test = "�������ְ����Ǹ���̼ҿ��ܸ߶Ƚ���û�з�����ĲŻ��� ��ı���("+job_name+")��������ܾ��ˣ����ྫ�����ע�ٷ�΢�Ź��ںţ����job��";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}
	
	public static void daqian4(String user_username,String job_name,String money) {
		// TODO Auto-generated method stub
		String job_test = "�������ְ��С������ͣ��İ�("+job_name+")��ְ"+money+"Ԫ���ʷ��������Ǯ�����ע����ա����ྫ�����ע�ٷ�΢�Ź��ںţ����job��";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}
	
	public static void querencanjia6(String user_username,String job_name,String tel) {
		// TODO Auto-generated method stub
		String job_test = "�������ְ������ȷ�ϲμ�("+job_name+")��ְ���밴�̼�Ҫ��׼��������ǧ��Ҫ�Ÿ���Ŷ����Ϊ���кܶ��ڹ���ѧ��ͬѧ��Ҫ��ݹ��������������������ϵ�̼ң�"+tel+"�����ྫ�����ע�ٷ�΢�Ź��ںţ����job";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}
	
	public static void wailu5(String user_username,String job_name,String truename,String sex,String phone,String school) {
		// TODO Auto-generated method stub
		String job_test = "�������ְ���������ļ�ְ��Ϣ("+job_name+")�����˲μӡ�"+truename+"��"+sex+"��"+phone+"��"+school+"��";
		String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+user_username+"&content="+job_test+"&ext=&stime=&rrid=&msgfmt=";
		Server_Get.get(url);
	}
	
}
