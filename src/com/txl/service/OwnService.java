package com.txl.service;

import java.sql.ResultSet;

import com.txl.Vo.Own;

public interface OwnService {

	/**
	 * 实现数据的增加操作，调用的是Own.add()方法
	 * @param own 包含了要增加数据的own类对象
	 * @return 返回执行影响的行数
	 * @throws Exception OwnDao接口中的抛出异常
	 */
	public int add(Own own)throws Exception;
	/**
	 * 实现数据的查找操作，调用的是OwnDao.list()方法
	 * @param l_name 要查找的姓名
	 * @return 返回一个查询结果的结果集
	 * @throws Exception OwnDao接口中的抛出异常
	 */
	public ResultSet list(String l_name)throws Exception;
	
}
