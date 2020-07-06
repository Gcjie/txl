package com.txl.service;

import com.txl.Vo.User;

public interface UserService {

	/**
	 * 实现数据的查找操作，调用的是UserDao.login()方法
	 * @param user 包含了要查找的数据信息
	 * @return 返回一个user对象
	 * @throws Exception UserDao接口中的抛出异常
	 */
	public User login(User user)throws Exception;
	/**
	 * 实现数据的增加操作，调用的是UserDao.add()方法
	 * @param user 包含了要增加的数据信息
	 * @return 返回执行影响的行数
	 * @throws Exception UserDao接口中的抛出异常
	 */
	public int add(User user)throws Exception;
	/**
	 * 实现数据的删除操作，调用的是UserDao.delete()方法
	 * @param name 要删除的用户名
	 * @return 返回执行影响的行数
	 * @throws Exception UserDao接口中的抛出异常
	 */
	public int delete(String name)throws Exception;
	/**
	 * 实现数据的修改操作，调用的是UserDao.update()方法
	 * @param user 要修改的用户名
	 * @param password 新密码
	 * @return 返回执行影响的行数
	 * @throws Exception UserDao接口中的抛出异常
	 */
	public int update(User user,String password)throws Exception;
}
