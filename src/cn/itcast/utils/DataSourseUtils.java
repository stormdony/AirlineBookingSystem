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
	 * ��ȡ����
	 * @return ����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	/**
	 * �ͷ���Դ
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
	 * �ͷ�����
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
//		�����ͷ���Դ
		con=null;
	}
	/**
	 * �ͷ�����
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
//		�����ͷ���Դ
		stms=null;
	}
	/**
	 * �ͷ�����
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
//		�����ͷ���Դ
		rs=null;
	}
	
}
