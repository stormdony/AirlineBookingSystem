package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 
 * @author stormdony
 * at 2018/03/05
 * 更改个人信息的工具 类,返回布尔值
 *
 */

public class CustomerUpdateInfoUtils {

	public static boolean updateInfo(String cpassword, String cname, String cphone, String cpaperwork, String cid,
			String pwd, String name, String phone, String paper) {
		boolean flag=false;
		if (!(cpassword.equals(pwd) && cname.equals(name) && cphone.equals(phone) && cpaperwork.equals(paper))) {
			try {
				Connection con = JdbcUtils.getConnection();
				String sql = "update customer set Cpassword=? ,Cname=?,phone=?,Cpaperwork=? where Cid =?";
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, pwd);
				st.setString(2, name);
				st.setString(3, phone);
				st.setString(4, paper);
				st.setString(5, cid);
				int update = st.executeUpdate();
				if (update>0) {
					flag=true;
				}
				JdbcUtils.closeStatement(st);
				JdbcUtils.closeConnection(con);
			} catch (Exception e) {
				System.out.println("系统异常,稍后重试!!");
				e.printStackTrace();
			}
		}
		return flag;
	}

}
