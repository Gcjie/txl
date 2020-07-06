package com.txl.test.junit;

import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import com.txl.Factory.Daofactory;
import com.txl.Factory.Servicefactory;
import com.txl.Vo.Own;
import com.txl.dbc.DatabaseConnection;

import junit.framework.TestCase;

/**
 * 联系人分组自动测试 类
 * @author DELL
 *
 */
class OwnServiceTest {

	@Test
	void testAdd() {
		Own own = new Own("l_8","g_3");
		try {
			if(Servicefactory.getOwnServiceInstance().add(own) > 0) {
				TestCase.assertTrue(true);
			}else {
				TestCase.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testList() {
		String name="静静";
		try {
			ResultSet rs = Daofactory.getOwnDaoInstance(new DatabaseConnection().getCon()).list(name);
			int count = 0;
			while(rs.next()) {
				count++;
			}
			System.out.println("查询到有关"+count+"条记录！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
