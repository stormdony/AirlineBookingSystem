package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 
 * @author stormdony 
 * at 2018/03/04 
 * 注册客户账号,返回布尔值
 *
 */

public class CustomerRegisterUtils {

	public static boolean CustomerRegister(String Cid, String Cpwd,String Cname,String Cphone,String Cpaperwork) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into customer values(?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, Cid);
		st.setString(2, Cpwd);
		st.setString(3, Cname);
		st.setString(4, Cphone);
		st.setString(5, Cpaperwork);
		int update = st.executeUpdate();
		if (update > 0 && update <= 1) {
			return true;
		} else {
			return false;
		}

	}

}
