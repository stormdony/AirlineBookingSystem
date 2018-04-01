package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 
 * @author stormdony 
 * at 2018/03/04 
 * 注册管理员用户,返回布尔值
 *
 */

public class ManagerRegisterUtils {

	public static boolean ManagerRegister(String Mid, String Mpwd) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into manager values(?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, Mid);
		st.setString(2, Mpwd);
		int update = st.executeUpdate();
		if (update > 0 && update <= 1) {
			return true;
		} else {
			return false;
		}

	}

}
