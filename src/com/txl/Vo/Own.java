package com.txl.Vo;

/**
 * 联系人分组实体
 * @author DELL
 *
 */
public class Own {
	private String l_number;
	private String g_number;
	
	public Own() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Own(String l_number, String g_number) {
		super();
		this.l_number = l_number;
		this.g_number = g_number;
	}

	public String getL_number() {
		return l_number;
	}
	public void setL_number(String l_number) {
		this.l_number = l_number;
	}
	public String getG_number() {
		return g_number;
	}
	public void setG_number(String g_number) {
		this.g_number = g_number;
	}
	
}
