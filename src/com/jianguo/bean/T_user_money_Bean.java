package com.jianguo.bean;

public class T_user_money_Bean {

	//�û�Ǯ����
	private int id;//ID
	private int login_id;//�û���¼ID
	private String name;//�û�����
	private double money;//���
	private String zhifubao;//֧����
	private String yinhang;//����
	private String kahao;//����
	private String pay_password;//��������
	private String pay_status;//��������
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getZhifubao() {
		return zhifubao;
	}
	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}
	public String getYinhang() {
		return yinhang;
	}
	public void setYinhang(String yinhang) {
		this.yinhang = yinhang;
	}
	public String getKahao() {
		return kahao;
	}
	public void setKahao(String kahao) {
		this.kahao = kahao;
	}
	public String getPay_password() {
		return pay_password;
	}
	public void setPay_password(String payPassword) {
		pay_password = payPassword;
	}
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
	public String getPay_status() {
		return pay_status;
	}
	
}
