package com.jianguo.util;

import java.util.List;

public class PageModel<E>{

	//���浱ǰҳ������
	private List<E> list;
	
	//ÿҳ��ʾ����������
	private int pageSize = 15;
	
	private int totalRecords;// �ܼ�¼��
	
	private int firstResult=0;//�ӵڼ������ݿ�ʼ���� 
	
	private int pageNo = 1;// ��ǰ�ڼ�ҳ
	private String name;
	// ��ȡ��ҳ��
	public int getTotalPages(){
		return (this.totalRecords+this.pageSize - 1)/this.pageSize;
	}
	// ���һҳ
	public int getBottomPage(){
		return this.getTotalPages();
	}
	// ��һҳ
	public int getFirstPage(){
		return 1;
	}
	
	// ��һҳ
	public int getPrePage(){
		if(this.pageNo <=1){
			return 1;
		}
		return this.pageNo - 1;
	}
	
	// ��һҳ
	public int getNextPage(){
		if(this.pageNo >= this.getBottomPage()){
			return this.getBottomPage();
		}
		return this.pageNo + 1;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getFirstResult() {
		return (this.pageNo - 1) * this.pageSize;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
