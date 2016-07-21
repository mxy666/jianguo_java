package com.jianguo.util;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class Jdpushcc_shang {
	protected static final Logger LOG = LoggerFactory.getLogger(Jdpushcc_shang.class);

//	private static final String appKey = "3a7ac23a1e9f11dac9ca8ac2";//IOS��ҵ��
//	private static final String masterSecret = "78cc3086ed5396138e9953fd";//IOS��ҵ��
	private static final String appKey = "b7b12502ea5672f603fb80c1";//IOS��ҵ��
	private static final String masterSecret = "ac2905cd13f1872840f8c273";//IOS��ҵ��
	private static String sound = "default";
	/*
	 * public static final String TITLE = "��ͨ���"; public static final String
	 * ALERT = "ף����´�����"; public static final String MSG_CONTENT =
	 * "��ͨ���ף���Ͽͻ��´�����"; public static final String REGISTRATION_ID =
	 * "0900e8d85ef";
	 */

	public static JPushClient jpushClient = null;

	public static void sendPush(String title,String username) {
		jpushClient = new JPushClient(masterSecret, appKey,3);

		// HttpProxy proxy = new HttpProxy("localhost", 3128);
		// Can use this https proxy: https://github.com/Exa-Networks/exaproxy

		// For push, all you need do is to build PushPayload object.
		// PushPayload payload = buildPushObject_all_all_alert();
		// �������͵����ݣ����������Ȳ���ȫ������
		PushPayload payload = buildPushObject_all_alias_alert(title,username);
		
//		buildPushObject_ios_tagAnd_alertWithExtrasAndMessage();
//		payload.addSound(sound);//����
		
		Map<String, Object> extra = new HashMap<String, Object>();
		 
//		IOSExtra iosExtra = new IOSExtra(1, "Windows_Logon_Sound.wav");//badge and sound
//		 
//		extra.put("ios", iosExtra);
//		
//		MessageResult msgResult = jpush.sendNotificationWithAppKey(sendNo, msgTitle, msgContent, 0, extra);
		
		try {
//			PushNotificationPayload payLoad =  PushNotificationPayload.fromJSON(title);  
//			payLoad.addSound(sound);
			PushResult result = jpushClient.sendPush(payload);
			LOG.info("Got result - " + result);
		} catch (Exception e) {
		}
	}

	public static PushPayload buildPushObject_all_all_alert(String alert) {
		return PushPayload.alertAll(alert);
	}

	public static PushPayload buildPushObject_all_alias_alert(String title,String username) {
		
			Map params =  new HashMap();
//			params.put("username", username);
//			params.put("type", "1");
			return PushPayload.newBuilder().setPlatform(Platform.all())// ���ý��ܵ�ƽ̨
//					.setAudience(Audience.all())// Audience����Ϊall��˵�����ù㲥��ʽ���ͣ������û������Խ��յ�
					.setAudience(Audience.alias(username))// Audience����Ϊall��˵�����ù㲥��ʽ���ͣ������û������Խ��յ�
//					.setNotification(Notification.alert(title))
					.setNotification(Notification.ios(title, params))
//					.setNotification(Notification.ios(title, params))
					.setOptions(
						Options.newBuilder().setApnsProduction(true).build())
					.build();
		
	}

	public static PushPayload buildPushObject_audienceOne(String title,
			String content, String registerId) {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.all())
				.setAudience(Audience.registrationId(registerId))
				.setMessage(
						Message.newBuilder().setMsgContent(content)
								.setTitle(title).build())
				.setNotification(Notification.alert(content)).build();
	}

	public static PushPayload buildPushObject_android_tag_alertWithTitle(
			String alert, String title) {
		return PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(Audience.all())
				.setNotification(Notification.android(alert, title, null))
				.build();
	}

	public static PushPayload buildPushObject_android_and_ios() {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.tag("tag1"))
				.setNotification(
						Notification
								.newBuilder()
								.setAlert("alert content")
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setTitle("Android Title")
												.build())
								.addPlatformNotification(
										IosNotification
												.newBuilder()
//												.incrBadge(1)
												.addExtra("extra_key",
														"extra_value").build())
								.build()).build();
	}

	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage(
			String alert, String content) {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.tag_and("tag1", "tag_all"))
				.setNotification(
						Notification
								.newBuilder()
								.addPlatformNotification(
										IosNotification.newBuilder()
												.setAlert(alert)
//												.setBadge(5)
												.setSound("default")
												.addExtra("from", "JPush")
												.build()).build())
				.setMessage(Message.content(content))
				.setOptions(
						Options.newBuilder().setApnsProduction(true).build())
				.build();
		
	}

	public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras(
			String content) {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(
						Audience.newBuilder()
								.addAudienceTarget(
										AudienceTarget.tag("tag1", "tag2"))
								.addAudienceTarget(
										AudienceTarget
												.alias("alias1", "alias2"))
								.build())
				.setMessage(
						Message.newBuilder().setMsgContent(content)
								.addExtra("from", "JPush").build()).build();
	}
}