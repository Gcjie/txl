package com.txl.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.txl.Dao.OwnDao;
import com.txl.Vo.Own;

/**
 * ���Ҫ�������ݲ����࣬��ôһ��Ҫ�ڹ��췽���д���Connection�ӿڶ���
 * @author DELL
 *
 */
public class OwnDaoImpl implements OwnDao {
	
	private Connection conn;			//���ݿ����Ӷ���
	/**
	 * ʵ�������ݲ��������ͬʱ����һ�����ݿ����Ӷ���
	 * @param conn Connection���Ӷ������Ϊnull��ʾ���ݿ�û�д�
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
