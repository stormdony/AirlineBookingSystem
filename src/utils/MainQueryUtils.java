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

/**
 * 
 * @author stormdony
 *  at 2018/03/04 
 *  主界面查询,返回结果集
 *
 */
public class MainQueryUtils {
	public static ResultSet QueryAll(String Fid, String start, String destination, String Fgrade) throws Exception {
		Connection con = JdbcUtils.getConnection();
		String sql = "select * from flight where 1=1";
		if (Fid.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and Fid='"+Fid+"'";
		}if (start.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and start='"+start+"'";
		}if (destination.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and destination='"+destination+"'";
		}if (Fgrade.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and Fgrade='"+Fgrade+"'";
		}
		System.out.println(sql);
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return rs;
	}
	public static ResultSet CustomerQueryAll(String begin, String start, String destination, String end) throws Exception {
		Connection con = JdbcUtils.getConnection();
		String sql = "select * from flight where 1=1";
		if (begin.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and begin='"+begin+"'";
		}if (start.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and start='"+start+"'";
		}if (destination.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and destination='"+destination+"'";
		}if (end.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and Fid='"+end+"'";
		}
		System.out.println(sql);
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		return rs;
	}
	
	public static List<Flight> QueryFlight(String Fid, String start, String destination, String Fgrade) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse()); 
		String sql = "select * from flight where 1=1";
		if (Fid.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and Fid='"+Fid+"'";
		}if (start.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and start='"+start+"'";
		}if (destination.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and destination='"+destination+"'";
		}if (Fgrade.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and Fgrade='"+Fgrade+"'";
		}
		System.out.println(sql);
		List<Flight> list = runner.query(sql, new BeanListHandler<>(Flight.class));
		return list;
	}
	public static List<Flight> cusQueryFlight(String Fid, String start, String destination, String Fgrade) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse()); 
		String sql = "select * from flight where 1=1";
		if (Fid.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and Fid='"+Fid+"'";
		}if (start.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and start='"+start+"'";
		}if (destination.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and destination='"+destination+"'";
		}if (Fgrade.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and Fid='"+Fgrade+"'";
		}
		System.out.println(sql);
		List<Flight> list = runner.query(sql, new BeanListHandler<>(Flight.class));
		return list;
	}
	public static List<Flight> CustomerQueryFlight(String begin, String start, String destination, String end) throws SQLException{
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse()); 
		String sql = "select * from flight where 1=1";
		if (begin.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and begin='"+begin+"'";
		}if (start.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and start='"+start+"'";
		}if (destination.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and destination='"+destination+"'";
		}if (end.equals("")) {
			sql=sql+"";
		}else {
			sql=sql+" and Fid='"+end+"'";
		}
		System.out.println(sql);
		List<Flight> list = runner.query(sql, new BeanListHandler<>(Flight.class));
		return list;
	}
}
