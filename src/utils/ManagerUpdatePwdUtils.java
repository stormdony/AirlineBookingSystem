package utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.utils.DataSourseUtils;
import domain.Manager;

public class ManagerUpdatePwdUtils {
	private static String mid;
	private static String mpwd;
	private static String mid2;
	private static String mpassword;
	public static boolean checkUpdatePwd(String id,String pwd) throws SQLException {
		mid = id;
		mpwd = pwd;
		List<Manager> list = getManager();
		for (int i = 0; i < list.size(); i++) {
			Manager manager = list.get(i);
			mid2 = manager.getMid();
			mpassword = manager.getMpassword();
		}
		if (!(mid.equals(mid2)&&mpwd.equals(mpassword))) {
//			执行修改操作
			int i = updatePwd();
			if (i>0) {
				return true;
			} else {
				return false;
			}
		} else {
//			不执行修改操作
			return false;
		}
		
	}
	public static List<Manager> getManager() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql= "select * from Manager where Mid=?";
		List<Manager> list = runner.query(sql, new BeanListHandler<Manager>(Manager.class), mid);
		return list;
	}
	public static int updatePwd() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql= "update Manager set Mpassword=? where Mid=?";
		int update = runner.update(sql, mpwd,mid);
		return update;
	}
	
}
