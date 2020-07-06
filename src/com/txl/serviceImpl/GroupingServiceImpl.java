package com.txl.serviceImpl;

import java.sql.ResultSet;

import com.txl.Factory.Daofactory;
import com.txl.Vo.Grouping;
import com.txl.dbc.DatabaseConnection;
import com.txl.service.GroupingService;

public class GroupingServiceImpl implements GroupingService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public int add(Grouping grouping) throws Exception {
		try {
			if(Daofactory.getGroupingDaoInstance(this.dbc.getCon()).list(grouping) != null) {
				return Daofactory.getGroupingDaoInstance(this.dbc.getCon()).add(grouping);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

	@Override
	public ResultSet list(Grouping grouping) throws Exception {
		try {
			if(Daofactory.getGroupingDaoInstance(this.dbc.getCon()).list(grouping) != null) {
				return Daofactory.getGroupingDaoInstance(this.dbc.getCon()).list(grouping);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return null;
	}

	@Override
	public int delete(String name) throws Exception {
		try {
			return Daofactory.getGroupingDaoInstance(this.dbc.getCon()).delete(name);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

	@Override
	public int update(Grouping grouping, String name) throws Exception {
		try {
			return Daofactory.getGroupingDaoInstance(this.dbc.getCon()).update(grouping,name);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

}
