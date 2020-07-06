package com.txl.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.txl.Dao.LinkmanDao;
import com.txl.Util.StringUtil;
import com.txl.Vo.Linkman;

/**
 * ���Ҫ�������ݲ����࣬��ôһ��Ҫ�ڹ��췽���д���Connection�ӿڶ���
 * @author DELL
 *
 */
public class LinkmanDaoImpl implements LinkmanDao {

	private Connection conn;			//���ݿ����Ӷ���
	
	/**
	 * ʵ�������ݲ��������ͬʱ����һ�����ݿ����Ӷ���
	 * @param conn Connection���Ӷ������Ϊnull��ʾ���ݿ�û��
	 */
	public LinkmanDaoImpl(Connection conn) {
		this.conn=conn;
	}
	
	@Override
	public int add(Linkman linkman) throws Exception {
		String sql="insert into link values(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, linkman.getL_number());
		pstmt.setString(2, linkman.getName());
		pstmt.setString(3, linkman.getSex());
		pstmt.setString(4, linkman.getPhone());
		pstmt.setString(5, linkman.getQq());
		pstmt.setString(6, linkman.getAddress());
		return pstmt.executeUpdate();
	}

	@Override
	public ResultSet list(Linkman linkman) throws Exception {
		StringBuffer sb=new StringBuffer("select * from link");
		if(StringUtil.isNotEmpty(linkman.getName())) {
			sb.append(" and name like '%"+linkman.getName()+"%'");
		}else if(StringUtil.isNotEmpty(linkman.getPhone())) {
			sb.append(" and phone like '%"+linkman.getPhone()+"%'");
		}
		PreparedStatement pstmt =conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	@Override
	public int delete(String id, int flag) throws Exception {
		String sql=null;
		if(flag==0) {
			sql="delete from link where name=?";
		}else if(flag==1) {
			sql="delete from link where phone=?";
		}
		PreparedStatement pstmt =conn.prepareStatement(sql);
		pstmt.setString(1,id);
		return pstmt.executeUpdate();
	}

	@Override
	public int update(Linkman linkman, String id, int flag) throws Exception {
		String sql=null;
		if(flag==0) {
			sql="update link set l_number=?,name=?,sex=?,phone=?,qq=?,address=? where name=?";
		}else if(flag==1) {
			sql="update link set l_number=?,name=?,sex=?,phone=?,qq=?,address=? where phone=?";
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, linkman.getL_number());
		pstmt.setString(2, linkman.getName());
		pstmt.setString(3, linkman.getSex());
		pstmt.setString(4, linkman.getPhone());
		pstmt.setString(5, linkman.getQq());
		pstmt.setString(6, linkman.getAddress());
		pstmt.setString(7, id);
		return pstmt.executeUpdate();
	}

}
