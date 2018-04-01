package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 * @author stormdony
 * at 2018/03/04
 * 验证管理员是否登录成功
 *
 */

public class ManagerLoginUtils {
	private static String id;
	private static String mpwd;

	public static boolean checkLogin(String Mid, String Mpassword) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from manager where Mid=? ";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, Mid);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			id = rs.getString("Mid");
			mpwd = rs.getString("Mpassword");
		}
		JdbcUtils.closeResourse(conn, st, rs);
		if (Mid.equals(id) && Mpassword.equals(mpwd)) {
			return true;
		} else {
			return false;
		}
	}
}
