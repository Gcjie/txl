package com.txl.service;

import java.sql.ResultSet;

import com.txl.Vo.Grouping;

public interface GroupingService {

	/**
	 * 实现分组数据的增加操作，在本操作之前需要使用GroupingDao接口中的如下方法：<br>
	 * <li>首先利用GroupingDao.list()方法判断要增加的分组编号是否存在。</li>
	 * <li>如果分组编号不存在，则使用GroupingDao.add()方法保存分组信息</li>
	 * @param grouping 包含了要增加数据的grouping类对象
	 * @return 返回执行影响的行数
	 * @throws Exception GroupingDao接口中的抛出异常
	 */
	public int add(Grouping grouping)throws Exception;
	/**
	 *  实现数据的查找操作，调用的是GroupingDao.list()方法
	 * @param grouping 包含了要查找的数据信息
	 * @return 返回一个查询结果的结果集
	 * @throws Exception GroupingDao接口中的抛出异常
	 */
	public ResultSet list(Grouping grouping)throws Exception;
	/**
	 *  实现数据的删除操作，调用的是GroupingDao.delete()方法
	 * @param name 要删除的姓名
	 * @return 返回执行影响的行数
	 * @throws Exception GroupingDao接口中的抛出异常
	 */
	public int delete(String name)throws Exception;
	/**
	 * 实现数据的修改操作，调用的是GroupingDao.update()方法，此操作属于全部修改
	 * @param grouping 包含了要修改的数据信息
	 * @param name 要修改的姓名
	 * @return 返回执行影响的行数
	 * @throws Exception GroupingDao接口中的抛出异常
	 */
	public int update(Grouping grouping,String name)throws Exception;
}
