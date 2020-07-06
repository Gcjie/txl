package com.txl.serviceImpl;

import java.sql.ResultSet;

import com.txl.Factory.Daofactory;
import com.txl.Vo.Own;
import com.txl.dbc.DatabaseConnection;
import com.txl.service.OwnService;

public class OwnServiceImpl implements OwnService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public int add(Own own) throws Exception {
		try {
			return Daofactory.getOwnDaoInstance(this.dbc.getCon()).add(own);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

	@Override
	public ResultSet list(String l_name) throws Exception {
		try {
			if(Daofactory.getOwnDaoInstance(this.dbc.getCon()).list(l_name) != null) {
				return Daofactory.getOwnDaoInstance(this.dbc.getCon()).list(l_name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return null;
	}

}
