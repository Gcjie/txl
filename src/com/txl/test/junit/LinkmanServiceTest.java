package com.txl.test.junit;

import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import com.txl.Factory.Daofactory;
import com.txl.Factory.Servicefactory;
import com.txl.Vo.Linkman;
import com.txl.dbc.DatabaseConnection;

import junit.framework.TestCase;

/**
 * 联系人的自动测试类
 * @author DELL
 *
 */
class LinkmanServiceTest {

	@Test
	void testAdd() {
		Linkman likeman = new Linkman("l_9","测试数据","男","006","225544","测试测试");
		try {
			if(Servicefactory.getLinkmanServiceInstance().add(likeman) > 0) {
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
		Linkman likeman = new Linkman("l_4","婷","女","004","336","湖南永州道县");
		try {
			ResultSet rs = Daofactory.getLinkmanDaoInstance(new DatabaseConnection().getCon()).list(likeman);
			int count = 0;
			while(rs.next()) {
				count++;
			}
			System.out.println("查询到有关"+count+"条记录！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testDelete() {
		try {
			if(Servicefactory.getLinkmanServiceInstance().delete("Junit测试", 0) > 0) {
				TestCase.assertTrue(true);
			}else {
				TestCase.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdate() {
		Linkman likeman = new Linkman("l_9","Junit测试","男","0006","220550440","测试");
		try {
			if(Servicefactory.getLinkmanServiceInstance().update(likeman, "测试数据", 0) > 0) {
				TestCase.assertTrue(true);
			}else {
				TestCase.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
