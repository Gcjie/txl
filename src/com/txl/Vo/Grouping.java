package com.txl.Vo;

/**
 * ����ʵ��
 * @author DELL
 *
 */
public class Grouping {
	
	private String g_number;	//���
	private String g_name;		//������
	
	public Grouping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Grouping(String g_number, String g_name) {
		super();
		this.g_number = g_number;
		this.g_name = g_name;
	}

	public String getG_number() {
		return g_number;
	}
	public void setG_number(String g_number) {
		this.g_number = g_number;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	
}
