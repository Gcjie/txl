package com.txl.Dao;

import java.sql.ResultSet;

import com.txl.Vo.Linkman;

/**
 * 定义Linkman表的数据层操作标准
 * @author DELL
 *
 */
public interface LinkmanDao {
	/**
	 * 数据的增加操作，执行的是INSERT语句
	 * @param linkman 包含了要增加的数据信息
	 * @return 返回执行影响的行数
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public int add(Linkman linkman)throws Exception;
	/**
	 * 数据的查询操作，执行的是SELETE语句
	 * @param linkman 包含了要查询的数据信息
	 * @return 返回一个查询结果的结果集
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public ResultSet list(Linkman linkman)throws Exception;
	/**
	 * 数据的删除操作，执行的是DELETE语句
	 * @param id 要删除的条件
	 * @param flag 判断输入的是姓名还是电话
	 * @return 返回执行影响的行数
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public int delete(String id,int flag)throws Exception;
	/**
	 * 数据的修改操作，执行的是UPDATE语句，本次修改会更具name将所有数据进行变更
	 * @param linkman 包含了要修改的数据信息
	 * @param id 要查询的条件
	 * @param flag 判断输入的是姓名还是电话
	 * @return 返回执行影响的行数
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public int update(Linkman linkman,String id,int flag)throws Exception;
}
