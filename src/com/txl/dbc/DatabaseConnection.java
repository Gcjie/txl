package com.txl.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * @author DELL
 *
 */
public class DatabaseConnection {
		private static final String DBDRIVER="com.mysql.jdbc.Driver";		//MySQL��������
		private static final String DBURL="jdbc:mysql://localhost:3306/worker?useSSL=true";		//���ݿ����ӵ�ַ
		private static final String DBUSER="root";		//�û���
		private static final String DBPASSWORD="123456";		//����
		private Connection conn = null;
		
		public DatabaseConnection(){
			try {
				// �������ݿ���������
				Class.forName(DBDRIVER);
				this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * ��ȡ���ݿ�����
		 * @return
		 * @throws Exception
		 */
		public Connection getCon() throws Exception{
			return this.conn;
			}
		
		/**
		 * �ر����ݿ�����
		 * @param conn
		 * @throws Exception
		 */
		public void closeCon()throws Exception{
			if(conn!=null) {
				this.conn.close();
			}
		}
}