package com.jianguo.bean;

public class T_wages_Bean {

	//���ʱ�
	private int id;//ID
	private int login_id;//�û���¼ID
	private int job_id;//��ְID
	private double hould_money;//Ӧ������
	private double real_money;//ʵ������
	private String remarks;//��ע
	private String reg_time;//����ʱ��
	private String job_image;//����ʱ��
	private String job_name;//����ʱ��
	private String job_start;//����ʱ��
	private String job_stop;//����ʱ��
	private String job_city;//����ʱ��
	
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
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int jobId) {
		job_id = jobId;
	}
	public double getHould_money() {
		return hould_money;
	}
	public void setHould_money(double houldMoney) {
		hould_money = houldMoney;
	}
	public double getReal_money() {
		return real_money;
	}
	public void setReal_money(double realMoney) {
		real_money = realMoney;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getReg_time() {
		return reg_time;
	}
	public void setReg_time(String regTime) {
		reg_time = regTime;
	}
	public void setJob_image(String job_image) {
		this.job_image = job_image;
	}
	public String getJob_image() {
		return job_image;
	}
	public void setJob_start(String job_start) {
		this.job_start = job_start;
	}
	public String getJob_start() {
		return job_start;
	}
	public void setJob_stop(String job_stop) {
		this.job_stop = job_stop;
	}
	public String getJob_stop() {
		return job_stop;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_city(String job_city) {
		this.job_city = job_city;
	}
	public String getJob_city() {
		return job_city;
	}
	
}
