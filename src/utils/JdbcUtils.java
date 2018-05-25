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
	// 
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/plane?useSSL=true", "root",
				"123456");
		return connection;
	}

	/**
	 * 
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
	 * 
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
		// 
		con = null;
	}

	/**
	 *
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
		// 
		stms = null;
	}

	/**
	 * 
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
		// 
		rs = null;
	}
}
