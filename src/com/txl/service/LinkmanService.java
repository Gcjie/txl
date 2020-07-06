package com.txl.service;

import java.sql.ResultSet;

import com.txl.Vo.Linkman;

public interface LinkmanService {
	/**
	 * ʵ����ϵ�����ݵ����Ӳ������ڱ�����֮ǰ��Ҫʹ��LinkmanDao�ӿ��е����·�����<br>
	 * <li>��������LinkmanDao.list()�����ж�Ҫ���ӵ���ϵ�˱���Ƿ���ڡ�</li>
	 * <li>�����ϵ�˱�Ų����ڣ���ʹ��LinkmanDao.add()����������ϵ����Ϣ</li>
	 * @param linkman ������Ҫ�������ݵ�linkman�����
	 * @return ����ִ��Ӱ�������
	 * @throws Exception LinkmanDao�ӿ��е��׳��쳣
	 */
	public int add(Linkman linkman)throws Exception;
	/**
	 * ʵ�����ݵĲ��Ҳ��������õ���LinkmanDao.list()����
	 * @param linkman ������Ҫ���ҵ�������Ϣ
	 * @return ����һ����ѯ����Ľ����
	 * @throws Exception LinkmanDao�ӿ��е��׳��쳣
	 */
	public ResultSet list(Linkman linkman)throws Exception;
	/**
	 * ʵ�����ݵ�ɾ�����������õ���LinkmanDao.delete()����
	 * @param id Ҫɾ��������
	 * @param flag �ж���������������ǵ绰
	 * @return ����ִ��Ӱ�������
	 * @throws Exception LinkmanDao�ӿ��е��׳��쳣
	 */
	public int delete(String id,int flag)throws Exception;
	/**
	 * ʵ�����ݵ��޸Ĳ��������õ���LinkmanDao.update()����
	 * @param linkman ������Ҫ�޸ĵ�������Ϣ
	 * @param id Ҫ�޸ĵ�����
	 * @param flag �ж���������������ǵ绰
	 * @return ����ִ��Ӱ�������
	 * @throws Exception LinkmanDao�ӿ��е��׳��쳣
	 */
	public int update(Linkman linkman,String id,int flag)throws Exception;
}
