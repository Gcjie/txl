package com.txl.test.junit;

import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import com.txl.Factory.Daofactory;
import com.txl.Factory.Servicefactory;
import com.txl.Vo.Linkman;
import com.txl.dbc.DatabaseConnection;

import junit.framework.TestCase;

/**
 * ��ϵ�˵��Զ�������
 * @author DELL
 *
 */
class LinkmanServiceTest {

	@Test
	void testAdd() {
		Linkman likeman = new Linkman("l_9","��������","��","006","225544","���Բ���");
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
		Linkman likeman = new Linkman("l_4","��","Ů","004","336","�������ݵ���");
		try {
			ResultSet rs = Daofactory.getLinkmanDaoInstance(new DatabaseConnection().getCon()).list(likeman);
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
			if(Servicefactory.getLinkmanServiceInstance().delete("Junit����", 0) > 0) {
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
		Linkman likeman = new Linkman("l_9","Junit����","��","0006","220550440","����");
		try {
			if(Servicefactory.getLinkmanServiceInstance().update(likeman, "��������", 0) > 0) {
				TestCase.assertTrue(true);
			}else {
				TestCase.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
