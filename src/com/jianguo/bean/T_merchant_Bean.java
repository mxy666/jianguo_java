package com.jianguo.bean;

public class T_merchant_Bean {
	
	//�̼���Ϣ��
	private int id;//ID
	private int login_id;//�û���¼�����ID
	private String name;//�̼�����
	private String name_image;//�̼�ͷ��
	private String about;//�̼Ҽ��
	private String label;//��ǩ���ֺŸ���ÿ����ǩ(;)��
	private double score;//����
	private int job_count;//���ṩ���ٴμ�ְ
	private int user_count;//����������û�
	private int fans_count;//���ٷ�˿
	private int post;//���ж��ٸ�λ
	private String regedit_time;//ע��ʱ��
	private String login_time;//��¼ʱ��
	private String is_follow;//��¼ʱ��
	private String qiniu;//��ţ
	private String pay_password;//֧������
	private String tel;//֧������
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_image() {
		return name_image;
	}
	public void setName_image(String nameImage) {
		name_image = nameImage;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getJob_count() {
		return job_count;
	}
	public void setJob_count(int jobCount) {
		job_count = jobCount;
	}
	public int getUser_count() {
		return user_count;
	}
	public void setUser_count(int userCount) {
		user_count = userCount;
	}
	public int getFans_count() {
		return fans_count;
	}
	public void setFans_count(int fansCount) {
		fans_count = fansCount;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public String getRegedit_time() {
		return regedit_time;
	}
	public void setRegedit_time(String regeditTime) {
		regedit_time = regeditTime;
	}
	public String getLogin_time() {
		return login_time;
	}
	public void setLogin_time(String loginTime) {
		login_time = loginTime;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setIs_follow(String is_follow) {
		this.is_follow = is_follow;
	}
	public String getIs_follow() {
		return is_follow;
	}
	public void setQiniu(String qiniu) {
		this.qiniu = qiniu;
	}
	public String getQiniu() {
		return qiniu;
	}
	public void setPay_password(String pay_password) {
		this.pay_password = pay_password;
	}
	public String getPay_password() {
		return pay_password;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;
	}
	
}
