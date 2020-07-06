package com.txl.Dao;

import java.sql.ResultSet;

import com.txl.Vo.Own;

/**
 * 定义Own表的数据层操作标准
 * @author DELL
 *
 */
public interface OwnDao {

	/**
	 * 数据的增加操作，执行的是INSERT语句
	 * @param own 包含了要增加的数据信息
	 * @return 返回执行影响的行数
	 * @throws Exception 返回执行影响的行数 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public int add(Own own)throws Exception;
	/**
	 * 数据的查询操作，执行的是SELETE语句
	 * @param l_name 要查询的姓名
	 * @return 返回一个查询结果的结果集
	 * @throws Exception 返回执行影响的行数 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public ResultSet list(String l_name)throws Exception;
}
