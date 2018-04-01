package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author stormdony 
 * at 2018/03/04
 *
 */
public class JdbcUtils {
	// 获取连接
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/plane?useSSL=true", "root",
				"123456");
		return connection;
	}

	/**
	 * 释放资源
	 * 
	 * @param con
	 * @param stmts
	 * @param rs
	 */
	public static void closeResourse(Connection con, Statement stmts, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(stmts);
		closeConnection(con);
	}

	/**
	 * 释放连接
	 * 
	 * @param connection
	 */
	public static void closeConnection(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		// 快速释放资源
		con = null;
	}

	/**
	 * 释放连接
	 * 
	 * @param Statement
	 */
	public static void closeStatement(Statement stms) {
		if (stms != null)
			try {
				stms.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		// 快速释放资源
		stms = null;
	}

	/**
	 * 释放连接
	 * 
	 * @param ResultSet
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// 快速释放资源
		rs = null;
	}
}
