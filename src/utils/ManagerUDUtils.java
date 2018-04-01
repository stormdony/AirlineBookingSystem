package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.utils.DataSourseUtils;
import domain.Flight;

public class ManagerUDUtils {
	public static ResultSet QueryAll(String Fid) throws Exception {
		Connection con = JdbcUtils.getConnection();
		String sql = "select * from flight where Mid=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, Fid);
		ResultSet rs = st.executeQuery();
		return rs;
	}

	public static List<Flight> QueryFlightByFid(String Fid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "select * from flight where Fid=?";
		List<Flight> list = runner.query(sql, new BeanListHandler<>(Flight.class), Fid);
		return list;
	}

	public static List<Flight> QueryBookByFid(String Fid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "select * from book where Fid=?";
		List<Flight> list = runner.query(sql, new BeanListHandler<>(Flight.class), Fid);
		return list;
	}

	public static List<Flight> QueryTicketByFid(String Fid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "select * from Ticket where Ftid=?";
		List<Flight> list = runner.query(sql, new BeanListHandler<>(Flight.class), Fid);
		return list;
	}

	public static List<Flight> QueryFlightByMid(String Mid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "select * from flight where Mid=?";
		List<Flight> list = runner.query(sql, new BeanListHandler<>(Flight.class), Mid);
		return list;
	}

	public static boolean deleteTicket(String Fid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "delete from ticket where Ftid=?";
		int i = runner.update(sql, Fid);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean deleteFlight(String Mid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "delete from flight where Mid=?";
		int i = runner.update(sql, Mid);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean deleteBook(String Fid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "delete from book where Fid=?";
		int i = runner.update(sql, Fid);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}
}
