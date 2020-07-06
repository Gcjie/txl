package com.txl.Dao;

import com.txl.Vo.User;

/**
 * ����User������ݲ������׼
 * @author DELL
 *
 */
public interface UserDao {

	/**
	 * ���ݵ����Ӳ�����ִ�е���INSERT���
	 * @param user ������Ҫ���ӵ�������Ϣ
	 * @return ����һ��user����
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public User login(User user)throws Exception;
	/**
	 * ���ݵĲ�ѯ������ִ�е���SELETE���
	 * @param user ������Ҫ��ѯ��������Ϣ
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int add(User user)throws Exception;
	/**
	 * ���ݵ�ɾ��������ִ�е���DELETE���
	 * @param name Ҫ��ѯ������
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int delete(String name)throws Exception;
	/**
	 * ���ݵ��޸Ĳ�����ִ�е���UPDATE��䣬�����޸Ļ����name���������ݽ��б��
	 * @param user ������Ҫ�޸ĵ�������Ϣ
	 * @param password ������
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int update(User user,String password)throws Exception;
}
