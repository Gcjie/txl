package com.txl.serviceImpl;

import com.txl.Factory.Daofactory;
import com.txl.Vo.User;
import com.txl.dbc.DatabaseConnection;
import com.txl.service.UserService;

public class UserServiceImpl implements UserService {

	private DatabaseConnection dbc = new DatabaseConnection();
	
	@Override
	public User login(User user) throws Exception {
		try {
			if(Daofactory.getUserDaoInstance(this.dbc.getCon()).login(user) != null) {
				return Daofactory.getUserDaoInstance(this.dbc.getCon()).login(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return null;
	}

	@Override
	public int add(User user) throws Exception {
		try {
			return Daofactory.getUserDaoInstance(this.dbc.getCon()).add(user);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

	@Override
	public int delete(String name) throws Exception {
		try {
			return Daofactory.getUserDaoInstance(this.dbc.getCon()).delete(name);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

	@Override
	public int update(User user,String password) throws Exception {
		try {
			return Daofactory.getUserDaoInstance(this.dbc.getCon()).update(user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.dbc.closeCon();
		}
		return 0;
	}

}
