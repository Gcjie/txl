package com.txl.service;

import com.txl.Vo.User;

public interface UserService {

	/**
	 * ʵ�����ݵĲ��Ҳ��������õ���UserDao.login()����
	 * @param user ������Ҫ���ҵ�������Ϣ
	 * @return ����һ��user����
	 * @throws Exception UserDao�ӿ��е��׳��쳣
	 */
	public User login(User user)throws Exception;
	/**
	 * ʵ�����ݵ����Ӳ��������õ���UserDao.add()����
	 * @param user ������Ҫ���ӵ�������Ϣ
	 * @return ����ִ��Ӱ�������
	 * @throws Exception UserDao�ӿ��е��׳��쳣
	 */
	public int add(User user)throws Exception;
	/**
	 * ʵ�����ݵ�ɾ�����������õ���UserDao.delete()����
	 * @param name Ҫɾ�����û���
	 * @return ����ִ��Ӱ�������
	 * @throws Exception UserDao�ӿ��е��׳��쳣
	 */
	public int delete(String name)throws Exception;
	/**
	 * ʵ�����ݵ��޸Ĳ��������õ���UserDao.update()����
	 * @param user Ҫ�޸ĵ��û���
	 * @param password ������
	 * @return ����ִ��Ӱ�������
	 * @throws Exception UserDao�ӿ��е��׳��쳣
	 */
	public int update(User user,String password)throws Exception;
}
