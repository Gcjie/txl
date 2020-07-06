package com.txl.Dao;

import com.txl.Vo.User;

/**
 * 定义User表的数据层操作标准
 * @author DELL
 *
 */
public interface UserDao {

	/**
	 * 数据的增加操作，执行的是INSERT语句
	 * @param user 包含了要增加的数据信息
	 * @return 返回一个user对象
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public User login(User user)throws Exception;
	/**
	 * 数据的查询操作，执行的是SELETE语句
	 * @param user 包含了要查询的数据信息
	 * @return 返回执行影响的行数
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public int add(User user)throws Exception;
	/**
	 * 数据的删除操作，执行的是DELETE语句
	 * @param name 要查询的姓名
	 * @return 返回执行影响的行数
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public int delete(String name)throws Exception;
	/**
	 * 数据的修改操作，执行的是UPDATE语句，本次修改会更具name将所有数据进行变更
	 * @param user 包含了要修改的数据信息
	 * @param password 新密码
	 * @return 返回执行影响的行数
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public int update(User user,String password)throws Exception;
}
