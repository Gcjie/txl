package com.txl.Dao;

import java.sql.ResultSet;

import com.txl.Vo.Grouping;
/**
 * ����Grouping������ݲ������׼
 * @author DELL
 *
 */
public interface GroupingDao {
	/**
	 * ���ݵ����Ӳ�����ִ�е���INSERT���
	 * @param grouping ������Ҫ���ӵ�������Ϣ
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int add(Grouping grouping)throws Exception;
	/**
	 * ���ݵĲ�ѯ������ִ�е���SELETE���
	 * @param grouping ������Ҫ��ѯ��������Ϣ
	 * @return ����һ����ѯ����Ľ����
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public ResultSet list(Grouping grouping)throws Exception;
	/**
	 * ���ݵ�ɾ��������ִ�е���DELETE���
	 * @param name Ҫɾ��������
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int delete(String name)throws Exception;
	/**
	 * ���ݵ��޸Ĳ�����ִ�е���UPDATE��䣬�����޸Ļ����name���������ݽ��б��
	 * @param grouping ������Ҫ�޸����ݵ���Ϣ
	 * @param name Ҫ�޸ĵ�����
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int update(Grouping grouping,String name)throws Exception;
	
}
