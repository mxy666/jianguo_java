package com.jianguo.bean;

public class T_user_wx_Bean {

	//�û�΢�ű�
	private int id;//ID
	private int login_id;//�û���¼ID
	private String openid;//��ͨ�û��ı�ʶ���Ե�ǰ�������ʺ�Ψһ
	private String nickname;//��ͨ�û��ǳ�
	private int sex;//��ͨ�û��Ա�1Ϊ���ԣ�2ΪŮ��
	private String province;//��ͨ�û�����������д��ʡ��
	private String city;//��ͨ�û�����������д�ĳ���
	private String country;//���ң����й�ΪCN
	private String headimgurl;//�û�ͷ��
	private String privilege;//�û���Ȩ��Ϣ	ͬһ�û���unionid��Ψһ�ġ�
	private String unionid;//�û�ͳһ��ʶ�����һ��΢�ſ���ƽ̨�ʺ��µ�Ӧ�ã�
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int loginId) {
		login_id = loginId;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
}
