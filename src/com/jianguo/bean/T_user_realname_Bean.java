package com.jianguo.bean;

public class T_user_realname_Bean {

	//�û�ʵ����
	private int id; //ID
	private int login_id; //�û���¼�����ID
	private String front_image; //����
	private String behind_image; //����
	private String realname; //��ʵ����
	private String id_number;//���֤��
	private int sex;//�Ա�
	private int status;//�Ա�
	private String school;//�Ա�
	
	private String tel;//���֤��
	
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
	public String getFront_image() {
		return front_image;
	}
	public void setFront_image(String frontImage) {
		front_image = frontImage;
	}
	public String getBehind_image() {
		return behind_image;
	}
	public void setBehind_image(String behindImage) {
		behind_image = behindImage;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String idNumber) {
		id_number = idNumber;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getSex() {
		return sex;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSchool() {
		return school;
	} 
	
}
