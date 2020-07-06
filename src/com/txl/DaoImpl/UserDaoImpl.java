package com.txl.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.txl.Dao.UserDao;
import com.txl.Vo.User;
import com.txl.dbc.DatabaseConnection;

/**
 * 如果要操作数据层子类，那么一定要在构造方法中传入Connection接口对象
 * @author DELL
 *
 */
public class UserDaoImpl implements UserDao {

	private Connection conn;			//数据库连接对象
	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * @param conn Connection连接对象，如果为null表示数据库没有打开
	 */
	public UserDaoImpl(Connection conn) {
		this.conn=conn;
	}
	
	@Override
	public User login(User user) throws Exception {
		User resultUser = null;
		String sql="select * from worker where username=? and password=?";
		PreparedStatement pstmt = new DatabaseConnection().getCon().prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultUser=new User();
		//	resultUser.setId(rs.getString("id"));
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
		}
		new DatabaseConnection().closeCon();
		return resultUser;
	}

	@Override
	public int add(User user) throws Exception {
		String sql="insert into worker values(?,?,?)";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getUsername());
		pstmt.setString(3, user.getPassword());
		return pstmt.executeUpdate();
	}

	@Override
	public int delete(String name) throws Exception {
		String sql="delete from worker where username=?";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1,name);
		return pstmt.executeUpdate();
	}

	@Override
	public int update(User user, String password) throws Exception {
		String sql="update worker set password=? where username=?";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2,password);
		return pstmt.executeUpdate();
	}

}
