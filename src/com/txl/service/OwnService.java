package com.txl.service;

import java.sql.ResultSet;

import com.txl.Vo.Own;

public interface OwnService {

	/**
	 * ʵ�����ݵ����Ӳ��������õ���Own.add()����
	 * @param own ������Ҫ�������ݵ�own�����
	 * @return ����ִ��Ӱ�������
	 * @throws Exception OwnDao�ӿ��е��׳��쳣
	 */
	public int add(Own own)throws Exception;
	/**
	 * ʵ�����ݵĲ��Ҳ��������õ���OwnDao.list()����
	 * @param l_name Ҫ���ҵ�����
	 * @return ����һ����ѯ����Ľ����
	 * @throws Exception OwnDao�ӿ��е��׳��쳣
	 */
	public ResultSet list(String l_name)throws Exception;
	
}
