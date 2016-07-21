package com.jianguo.servlet.jpush.action;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import com.jianguo.bean.T_user_resume_Bean;
import com.jianguo.sql.T_push_Sql;
import com.jianguo.sql.T_push_new_Sql;
import com.jianguo.util.Jdpush;
import com.jianguo.util.Jdpushcc;
import com.jianguo.util.Jdpusher;
import com.jianguo.util.Server_Get;
import com.jianguo.util.Text_Sms;

public class PushAction {
	public static void push(String pushWay,String message,String cityId,String school,String name,String sex) {
		
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ly_time = time.format(new java.util.Date());
		List<T_user_resume_Bean>pushObj =T_push_new_Sql.queryAll(cityId,school,name,sex);
		//极光推送
		if(pushWay.equals("light")){
			for(int i=0;i<pushObj.size();i++){
			Jdpush.sendPush(message,"jianguo"+pushObj.get(i).getId());//iOS
				Jdpusher.sendPush(message,"jianguo"+pushObj.get(i).getId());//安卓
				Jdpushcc.sendPush(message,"jianguo"+pushObj.get(i).getId());//iOS
				T_push_Sql.insert(pushObj.get(i).getId()+"", "推送", "推送", message, "0", ly_time);
				System.out.println("---"+pushObj.get(i).getId()+"---");
			}	
		}else if(pushWay.equals("sms")){//短信推送
			System.out.println(message+"-------------");
			String str_message = "【兼果兼职】欢迎使用兼果兼职,"+message;
			for(int i=0;i<pushObj.size();i++){
				String tel =pushObj.get(i).getTel().toString();
				String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend?sn=SDK-BBX-010-24859&pwd=FF906E078CC0AFCBF3286AD39DDD98C9&mobile="+tel+"&content="+str_message+"&ext=&stime=&rrid=&msgfmt=";
				Server_Get.get(url);
			System.out.println("---"+tel+"---");
			}
			
		}
		
		

		
	}
}
