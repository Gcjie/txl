package com.txl.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.txl.Dao.OwnDao;
import com.txl.Vo.Own;

/**
 * 如果要操作数据层子类，那么一定要在构造方法中传入Connection接口对象
 * @author DELL
 *
 */
public class OwnDaoImpl implements OwnDao {
	
	private Connection conn;			//数据库连接对象
	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * @param conn Connection连接对象，如果为null表示数据库没有打开
	 */
	public OwnDaoImpl(Connection conn) {
		this.conn=conn;
	}
	
	@Override
	public int add(Own own) throws Exception {
		String sql="insert into own values(?,?)";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, own.getL_number());
		pstmt.setString(2, own.getG_number());
		return pstmt.executeUpdate();
	}

	@Override
	public ResultSet list(String l_name) throws Exception {
		String sql="SELECT * FROM grouping where grouping.g_number=(SELECT own.g_number FROM own WHERE own.l_number = (SELECT link.l_number FROM link where link.name=?))";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, l_name);
		return pstmt.executeQuery();
	}

}
