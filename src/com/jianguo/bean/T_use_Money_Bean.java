package com.jianguo.bean;

public class T_use_Money_Bean {

	//usemoney�б�
	private int id;
	private String admin;
	private String workDate;
	private String merchant;//ҵ������
	private String name;
	private String tel;
	private double houldMoney;//Ӧ������
	private double moneyOut;//���ֽ��
	private String moneyOutDate;//��������
	private String remarks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoneyOutDate() {
		return moneyOutDate;
	}
	public void setMoneyOutDate(String moneyOutDate) {
		this.moneyOutDate = moneyOutDate;
	}
	
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public double getHouldMoney() {
		return houldMoney;
	}
	public void setHouldMoney(double houldMoney) {
		this.houldMoney = houldMoney;
	}
	public double getMoneyOut() {
		return moneyOut;
	}
	public void setMoneyOut(double moneyOut) {
		this.moneyOut = moneyOut;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRemarks() {
		return remarks;
	}

	
	 
}
