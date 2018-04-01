package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * 
 * @author stormdony
 * at 2018/03/05
 * ���ؿͻ��ĸ�����Ϣ�Ľ����
 *
 */
public class CustomerInfoUtils {
	
	public static ResultSet getInfo(String id) throws Exception  {
		Connection con = JdbcUtils.getConnection();
		String sql ="select * from customer where Cid=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		return rs;
	}

}
