package com.txl.service;

import java.sql.ResultSet;

import com.txl.Vo.Linkman;

public interface LinkmanService {
	/**
	 * 实现联系人数据的增加操作，在本操作之前需要使用LinkmanDao接口中的如下方法：<br>
	 * <li>首先利用LinkmanDao.list()方法判断要增加的联系人编号是否存在。</li>
	 * <li>如果联系人编号不存在，则使用LinkmanDao.add()方法保存联系人信息</li>
	 * @param linkman 包含了要增加数据的linkman类对象
	 * @return 返回执行影响的行数
	 * @throws Exception LinkmanDao接口中的抛出异常
	 */
	public int add(Linkman linkman)throws Exception;
	/**
	 * 实现数据的查找操作，调用的是LinkmanDao.list()方法
	 * @param linkman 包含了要查找的数据信息
	 * @return 返回一个查询结果的结果集
	 * @throws Exception LinkmanDao接口中的抛出异常
	 */
	public ResultSet list(Linkman linkman)throws Exception;
	/**
	 * 实现数据的删除操作，调用的是LinkmanDao.delete()方法
	 * @param id 要删除的条件
	 * @param flag 判断输入的是姓名还是电话
	 * @return 返回执行影响的行数
	 * @throws Exception LinkmanDao接口中的抛出异常
	 */
	public int delete(String id,int flag)throws Exception;
	/**
	 * 实现数据的修改操作，调用的是LinkmanDao.update()方法
	 * @param linkman 包含了要修改的数据信息
	 * @param id 要修改的条件
	 * @param flag 判断输入的是姓名还是电话
	 * @return 返回执行影响的行数
	 * @throws Exception LinkmanDao接口中的抛出异常
	 */
	public int update(Linkman linkman,String id,int flag)throws Exception;
}
