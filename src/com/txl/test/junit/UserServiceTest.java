package com.txl.test.junit;

import org.junit.jupiter.api.Test;

import com.txl.Factory.Servicefactory;
import com.txl.Util.RandomUtil;
import com.txl.Vo.User;

import junit.framework.TestCase;

/**
 * 自动测试类（在用户表里生成一万条记录）
 * @author DELL
 *
 */
class UserServiceTest {

	@Test
	void testAdd() {
		for(int i = 1; i < 10001; i++) {
			// 编号
			StringBuilder id = new StringBuilder("user_");
			if(i < 10) {
				id.append("0000").append(i);
			}else if(i >= 10 && i < 100) {
				id.append("000").append(i);
			}else if(i >= 100 && i < 1000){
				id.append("00").append(i);
			}else if(i >= 1000 && i < 10000){
				id.append("0").append(i);
			}else {
				id.append(i);
			}
			
			User user = new User(id.toString(), RandomUtil.getUsername(), "123456");
			try {
				if(Servicefactory.getUserServiceInstance().add(user) > 0) {
					TestCase.assertTrue(true);
				}else {
					TestCase.assertTrue(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
