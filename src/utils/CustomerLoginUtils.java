package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author stormdony
 * at 2018/03/04
 * 验证客户是否登录成功
 *
 */

public class CustomerLoginUtils {
	private static String id;
	private static String Cpwd;

	public static boolean checkLogin(String Cid, String Cpassword) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from customer where Cid=? ";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, Cid);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			id = rs.getString("Cid");
			Cpwd = rs.getString("Cpassword");
		}
		JdbcUtils.closeResourse(conn, st, rs);
		if (Cid.equals(id) && Cpassword.equals(Cpwd)) {
			return true;
		} else {
			return false;
		}
	}
}
