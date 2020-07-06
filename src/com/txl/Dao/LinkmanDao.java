package com.txl.Dao;

import java.sql.ResultSet;

import com.txl.Vo.Linkman;

/**
 * ����Linkman������ݲ������׼
 * @author DELL
 *
 */
public interface LinkmanDao {
	/**
	 * ���ݵ����Ӳ�����ִ�е���INSERT���
	 * @param linkman ������Ҫ���ӵ�������Ϣ
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int add(Linkman linkman)throws Exception;
	/**
	 * ���ݵĲ�ѯ������ִ�е���SELETE���
	 * @param linkman ������Ҫ��ѯ��������Ϣ
	 * @return ����һ����ѯ����Ľ����
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public ResultSet list(Linkman linkman)throws Exception;
	/**
	 * ���ݵ�ɾ��������ִ�е���DELETE���
	 * @param id Ҫɾ��������
	 * @param flag �ж���������������ǵ绰
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int delete(String id,int flag)throws Exception;
	/**
	 * ���ݵ��޸Ĳ�����ִ�е���UPDATE��䣬�����޸Ļ����name���������ݽ��б��
	 * @param linkman ������Ҫ�޸ĵ�������Ϣ
	 * @param id Ҫ��ѯ������
	 * @param flag �ж���������������ǵ绰
	 * @return ����ִ��Ӱ�������
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int update(Linkman linkman,String id,int flag)throws Exception;
}
