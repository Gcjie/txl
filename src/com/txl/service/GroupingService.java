package com.txl.service;

import java.sql.ResultSet;

import com.txl.Vo.Grouping;

public interface GroupingService {

	/**
	 * ʵ�ַ������ݵ����Ӳ������ڱ�����֮ǰ��Ҫʹ��GroupingDao�ӿ��е����·�����<br>
	 * <li>��������GroupingDao.list()�����ж�Ҫ���ӵķ������Ƿ���ڡ�</li>
	 * <li>��������Ų����ڣ���ʹ��GroupingDao.add()�������������Ϣ</li>
	 * @param grouping ������Ҫ�������ݵ�grouping�����
	 * @return ����ִ��Ӱ�������
	 * @throws Exception GroupingDao�ӿ��е��׳��쳣
	 */
	public int add(Grouping grouping)throws Exception;
	/**
	 *  ʵ�����ݵĲ��Ҳ��������õ���GroupingDao.list()����
	 * @param grouping ������Ҫ���ҵ�������Ϣ
	 * @return ����һ����ѯ����Ľ����
	 * @throws Exception GroupingDao�ӿ��е��׳��쳣
	 */
	public ResultSet list(Grouping grouping)throws Exception;
	/**
	 *  ʵ�����ݵ�ɾ�����������õ���GroupingDao.delete()����
	 * @param name Ҫɾ��������
	 * @return ����ִ��Ӱ�������
	 * @throws Exception GroupingDao�ӿ��е��׳��쳣
	 */
	public int delete(String name)throws Exception;
	/**
	 * ʵ�����ݵ��޸Ĳ��������õ���GroupingDao.update()�������˲�������ȫ���޸�
	 * @param grouping ������Ҫ�޸ĵ�������Ϣ
	 * @param name Ҫ�޸ĵ�����
	 * @return ����ִ��Ӱ�������
	 * @throws Exception GroupingDao�ӿ��е��׳��쳣
	 */
	public int update(Grouping grouping,String name)throws Exception;
}
