package com.txl.test.junit;

import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import com.txl.Factory.Daofactory;
import com.txl.Factory.Servicefactory;
import com.txl.Vo.Grouping;
import com.txl.dbc.DatabaseConnection;

import junit.framework.TestCase;

/**
 * �����Զ�������
 * @author DELL
 *
 */
class GroupingServiceTest {

	@Test
	void testAdd() {
		Grouping grouping = new Grouping("g_8","����");
		try {
			if(Servicefactory.getGroupingServiceInstance().add(grouping) > 0) {
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
		Grouping grouping = new Grouping("g_4","����");
		try {
			ResultSet rs = Daofactory.getGroupingDaoInstance(new DatabaseConnection().getCon()).list(grouping);
			int count = 0;
			while(rs.next()) {
				count++;
			}
			System.out.println("��ѯ���й�"+count+"����¼��");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testDelete() {
		try {
			if(Servicefactory.getGroupingServiceInstance().delete("junit����") > 0) {
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
		Grouping grouping = new Grouping("g_8","junit����");
		try {
			if(Servicefactory.getGroupingServiceInstance().update(grouping, "����") > 0) {
				TestCase.assertTrue(true);
			}else {
				TestCase.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
