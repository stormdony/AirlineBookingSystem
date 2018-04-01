package cn.itcast.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourseUtils {
	private static ComboPooledDataSource ds=new ComboPooledDataSource("mysql");

	public static DataSource getDataSourse(){
		return ds;
		
	}
	/**
	 * 获取连接
	 * @return 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	/**
	 * 释放资源
	 * @param con
	 * @param stmts
	 * @param rs
	 */
	public static void closeResourse(Connection con,Statement stmts,ResultSet rs){
		closeResultSet(rs);
		closeStatement(stmts);
		closeConnection(con);
	}
	/**
	 * 释放连接
	 * @param connection
	 */
	public static void closeConnection(Connection con) {
		if (con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		快速释放资源
		con=null;
	}
	/**
	 * 释放连接
	 * @param Statement
	 */
	public static void closeStatement(Statement stms) {
		if (stms!=null)
			try {
				stms.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		快速释放资源
		stms=null;
	}
	/**
	 * 释放连接
	 * @param ResultSet
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		快速释放资源
		rs=null;
	}
	
}
