package com.txl.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.txl.Dao.GroupingDao;
import com.txl.Util.StringUtil;
import com.txl.Vo.Grouping;

/**
 * 如果要操作数据层子类，那么一定要在构造方法中传入Connection接口对象
 * @author DELL
 *
 */
public class GroupingDaoImpl implements GroupingDao {
	
	private Connection conn;			//数据库连接对象
	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * @param conn Connection连接对象，如果为null表示数据库没有打开
	 */
	public GroupingDaoImpl(Connection conn) {
		this.conn=conn;
	}

	@Override
	public int add(Grouping grouping) throws Exception {
		String sql="insert into grouping values(?,?)";
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1, grouping.getG_number());
		pstmt.setString(2, grouping.getG_name());
		return pstmt.executeUpdate();
	}

	@Override
	public ResultSet list(Grouping grouping) throws Exception {
		StringBuffer sb=new StringBuffer("select * from grouping");
		if(StringUtil.isNotEmpty(grouping.getG_name())) {
			sb.append(" and g_name like '%"+grouping.getG_name()+"%'");
		}
		PreparedStatement pstmt =conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	@Override
	public int delete(String name) throws Exception {
		String sql="delete from grouping where g_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,name);
		return pstmt.executeUpdate();
	}

	@Override
	public int update(Grouping grouping, String name) throws Exception {
		String sql="update grouping set g_number=?,g_name=? where g_name=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, grouping.getG_number());
		pstmt.setString(2, grouping.getG_name());
		pstmt.setString(3, name);
		return pstmt.executeUpdate();
	}

}
