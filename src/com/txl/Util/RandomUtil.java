package com.txl.Util;

/**
  *  ��������������û����е��û����Ĺ�����
 * @author DELL
 *
 */
public class RandomUtil {
	
	public static String getUsername() {
		//String random = "";
		String[] name = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		StringBuilder u = new StringBuilder();
		for(int i = 0; i< 5; i++) {
			int index = (int)(Math.random() * name.length);
			u.append(name[index]);
		}
		return u.toString();
	}
}
