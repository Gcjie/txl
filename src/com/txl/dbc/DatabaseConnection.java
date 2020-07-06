package com.txl.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author DELL
 *
 */
public class DatabaseConnection {
		private static final String DBDRIVER="com.mysql.jdbc.Driver";		//MySQL驱动程序
		private static final String DBURL="jdbc:mysql://localhost:3306/worker?useSSL=true";		//数据库连接地址
		private static final String DBUSER="root";		//用户名
		private static final String DBPASSWORD="123456";		//密码
		private Connection conn = null;
		
		public DatabaseConnection(){
			try {
				// 加载数据库驱动程序
				Class.forName(DBDRIVER);
				this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * 获取数据库连接
		 * @return
		 * @throws Exception
		 */
		public Connection getCon() throws Exception{
			return this.conn;
			}
		
		/**
		 * 关闭数据库连接
		 * @param conn
		 * @throws Exception
		 */
		public void closeCon()throws Exception{
			if(conn!=null) {
				this.conn.close();
			}
		}
}