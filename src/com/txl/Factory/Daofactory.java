package com.txl.Factory;

import java.sql.Connection;

import com.txl.Dao.GroupingDao;
import com.txl.Dao.LinkmanDao;
import com.txl.Dao.OwnDao;
import com.txl.Dao.UserDao;
import com.txl.DaoImpl.GroupingDaoImpl;
import com.txl.DaoImpl.OwnDaoImpl;
import com.txl.DaoImpl.UserDaoImpl;
import com.txl.DaoImpl.LinkmanDaoImpl;

public class Daofactory {
	public static LinkmanDao getLinkmanDaoInstance(Connection conn) {
		return new LinkmanDaoImpl(conn);
	}
	public static GroupingDao getGroupingDaoInstance(Connection conn) {
		return new GroupingDaoImpl(conn);
	}
	public static OwnDao getOwnDaoInstance(Connection conn) {
		return new OwnDaoImpl(conn);
	}
	public static UserDao getUserDaoInstance(Connection conn) {
		return new UserDaoImpl(conn);
	}
}
