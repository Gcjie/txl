package com.txl.Dao;

import java.sql.ResultSet;

import com.txl.Vo.Own;

/**
 * ����Own������ݲ������׼
 * @author DELL
 *
 */
public interface OwnDao {

	/**
	 * ���ݵ����Ӳ�����ִ�е���INSERT���
	 * @param own ������Ҫ���ӵ�������Ϣ
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ����ִ��Ӱ������� ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int add(Own own)throws Exception;
	/**
	 * ���ݵĲ�ѯ������ִ�е���SELETE���
	 * @param l_name Ҫ��ѯ������
	 * @return ����һ����ѯ����Ľ����
	 * @throws Exception ����ִ��Ӱ������� ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public ResultSet list(String l_name)throws Exception;
}
