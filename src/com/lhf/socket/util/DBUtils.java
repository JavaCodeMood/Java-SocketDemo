package com.lhf.socket.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**   
 * @ClassName:  DBUtils   
 * @Description: 连接数据库工具类
 * @author: liuhefei
 * @date:   2018年11月21日 上午11:53:42   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class DBUtils {
	
	/**
	 * 建立数据库连接
	 * @return
	 * 
	 * @author liuhefei
	 * 2018年11月21日
	 */
	public static Connection getConnection() {
		String driverClassName = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://127.0.0.1:3306/test";
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(URL, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param stmt
	 * @param rs
	 * 
	 * @author liuhefei
	 * 2018年11月21日
	 */
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(conn!=null){
				conn.close();
			}
			if(stmt!=null){
				stmt.close();
			}if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
