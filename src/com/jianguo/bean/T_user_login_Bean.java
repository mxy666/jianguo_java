package com.jianguo.bean;

public class T_user_login_Bean {

	//�û���¼��
	private int id;//ID
	private String tel;//����
	private String password;//�绰
	private String qqwx_token;//QQ
	private int status;//״̬
	private int resume;//�Ƿ���д����
	private int hobby;//��ְ��������
	private String qiniu;//��ţ
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setQqwx_token(String qqwx_token) {
		this.qqwx_token = qqwx_token;
	}
	public String getQqwx_token() {
		return qqwx_token;
	}
	public void setQiniu(String qiniu) {
		this.qiniu = qiniu;
	}
	public String getQiniu() {
		return qiniu;
	}
	public void setResume(int resume) {
		this.resume = resume;
	}
	public int getResume() {
		return resume;
	}
	public void setHobby(int hobby) {
		this.hobby = hobby;
	}
	public int getHobby() {
		return hobby;
	}
	
}
