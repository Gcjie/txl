package com.txl.Vo;

/**
 * 联系人实体
 * @author DELL
 *
 */
public class Linkman {

	private String l_number;	//联系人编号
	private String name;		//联系人姓名
	private String sex;			//联系人性别
	private String phone;		//联系人电话
	private String qq;			//联系人qq
	private String address;		//联系人地址
//	private String photo;		//联系人照片
	
	
	public Linkman() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Linkman(String l_number, String name, String sex, String phone, String qq, String address) {
		super();
		this.l_number = l_number;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.qq = qq;
		this.address = address;
//		this.photo = photo;
	}


	
//	public Linkman(String name, String sex, String phone, String qq, String address) {
//		super();
//		this.name = name;
//		this.sex = sex;
//		this.phone = phone;
//		this.qq = qq;
//		this.address = address;
//	}


	public String getL_number() {
		return l_number;
	}
	public void setL_number(String l_number) {
		this.l_number = l_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	public String getPhoto() {
//		return photo;
//	}
//	public void setPhoto(String photo) {
//		this.photo = photo;
//	}
	
	
}
