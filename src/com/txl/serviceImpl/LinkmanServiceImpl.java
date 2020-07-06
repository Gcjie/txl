package com.txl.serviceImpl;

import java.sql.ResultSet;

import com.txl.Factory.Daofactory;
import com.txl.Vo.Linkman;
import com.txl.dbc.DatabaseConnection;
import com.txl.service.LinkmanService;

public class LinkmanServiceImpl implements LinkmanService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public int add(Linkman linkman) throws Exception {
		try {
			if(Daofactory.getLinkmanDaoInstance(this.dbc.getCon()).list(linkman) != null) {
				return Daofactory.getLinkmanDaoInstance(this.dbc.getCon()).add(linkman);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

	@Override
	public ResultSet list(Linkman linkman) throws Exception {
		try {
			if(Daofactory.getLinkmanDaoInstance(this.dbc.getCon()).list(linkman) != null) {
				return Daofactory.getLinkmanDaoInstance(this.dbc.getCon()).list(linkman);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return null;
	}

	@Override
	public int delete(String id, int flag) throws Exception {
		try {
			//if(Daofactory.getLinkmanDaoInstance(this.dbc.getCon()).list(linkman) != null) {
				return Daofactory.getLinkmanDaoInstance(this.dbc.getCon()).delete(id, flag);

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

	@Override
	public int update(Linkman linkman, String id, int flag) throws Exception {
		try {
			//if(Daofactory.getLinkmanDaoInstance(this.dbc.getCon()).list(linkman) != null) {
				return Daofactory.getLinkmanDaoInstance(this.dbc.getCon()).update(linkman, id, flag);
			//}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

}
