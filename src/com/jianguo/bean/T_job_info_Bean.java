package com.jianguo.bean;

public class T_job_info_Bean {

	//��ְ�����
	private int id;//ID
	private int job_id;//��ְ��Ϣ�����ID
	private String tel;//�绰
	private String address;//��ַ
	private double lon;//����
	private double lat;//γ��
	private String start_date;//������ʼ����
	private String stop_date;//������������
	private String start_time;//������ʼʱ��
	private String stop_time;//��������ʱ��
	private String set_place;//���ϵص�
	private String set_time;//����ʱ��
	private int limit_sex;//�Ա����ƣ�0=ֻ��Ů��1=ֻ���У�2=������Ů��
	private int term;//���ޣ�1=�½ᣬ2=�ܽᣬ3=�սᣬ4=Сʱ�ᣩ
	private int mode;//���㷽ʽ
	private String other;//����
	private String work_content;//��������
	private String work_require;//����Ҫ��
	private String is_collection;//�Ƿ��ղ�
	private String is_enroll;//�Ƿ���
	private String nv_job_id;//�Ƿ���
	private String nv_sum;//�Ƿ���
	private String nv_count;//�Ƿ���
	private String nv_user_count;//�Ƿ���
	
	private String job_name;//�Ƿ���
	private String job_image;//�Ƿ���
	private String job_money;//�Ƿ���
	private String job_merchant_name;//�Ƿ���
	private String job_merchant_tel;//�Ƿ���
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int jobId) {
		job_id = jobId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String startDate) {
		start_date = startDate;
	}
	public String getStop_date() {
		return stop_date;
	}
	public void setStop_date(String stopDate) {
		stop_date = stopDate;
	}
	public String getSet_place() {
		return set_place;
	}
	public void setSet_place(String setPlace) {
		set_place = setPlace;
	}
	public int getLimit_sex() {
		return limit_sex;
	}
	public void setLimit_sex(int limitSex) {
		limit_sex = limitSex;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getWork_content() {
		return work_content;
	}
	public void setWork_content(String workContent) {
		work_content = workContent;
	}
	public String getWork_require() {
		return work_require;
	}
	public void setWork_require(String workRequire) {
		work_require = workRequire;
	}
	public void setIs_collection(String is_collection) {
		this.is_collection = is_collection;
	}
	public String getIs_collection() {
		return is_collection;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}
	public String getStop_time() {
		return stop_time;
	}
	public void setSet_time(String set_time) {
		this.set_time = set_time;
	}
	public String getSet_time() {
		return set_time;
	}
	public void setIs_enroll(String is_enroll) {
		this.is_enroll = is_enroll;
	}
	public String getIs_enroll() {
		return is_enroll;
	}
	public void setNv_job_id(String nv_job_id) {
		this.nv_job_id = nv_job_id;
	}
	public String getNv_job_id() {
		return nv_job_id;
	}
	public void setNv_sum(String nv_sum) {
		this.nv_sum = nv_sum;
	}
	public String getNv_sum() {
		return nv_sum;
	}
	public void setNv_count(String nv_count) {
		this.nv_count = nv_count;
	}
	public String getNv_count() {
		return nv_count;
	}
	public void setNv_user_count(String nv_user_count) {
		this.nv_user_count = nv_user_count;
	}
	public String getNv_user_count() {
		return nv_user_count;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_image(String job_image) {
		this.job_image = job_image;
	}
	public String getJob_image() {
		return job_image;
	}
	public void setJob_money(String job_money) {
		this.job_money = job_money;
	}
	public String getJob_money() {
		return job_money;
	}
	public void setJob_merchant_name(String job_merchant_name) {
		this.job_merchant_name = job_merchant_name;
	}
	public String getJob_merchant_name() {
		return job_merchant_name;
	}
	public void setJob_merchant_tel(String job_merchant_tel) {
		this.job_merchant_tel = job_merchant_tel;
	}
	public String getJob_merchant_tel() {
		return job_merchant_tel;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public int getMode() {
		return mode;
	}
	
}
