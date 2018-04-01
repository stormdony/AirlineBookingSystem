package utils;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.itcast.utils.DataSourseUtils;
import domain.Customer;
import domain.Flight;
import domain.Ticket;

/**
 * 
 * @author stormdony at 2018/03/06 得到客户的航班记录
 *
 */
public class CustomerMyorderUtils {
	private static List<Flight> myFlights = new LinkedList<>();
	private static String cid;

	public static List<Ticket> getOrder(String id) throws SQLException {
		cid = id;
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "select * from ticket where Ctid=? ";
		List<Ticket> tickets = runner.query(sql, new BeanListHandler<>(Ticket.class), cid);
//		System.out.println("tickets:" + tickets.size());
		return tickets;
	}

	public static List<Ticket> getbook() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "select * from ticket where Ctid=? ";
		List<Ticket> rebooks = runner.query(sql, new BeanListHandler<>(Ticket.class), cid);
		return rebooks;
	}
	//退订
	public static boolean tobook(String fid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "update ticket set rebook=? where Ctid=? and Ftid=? ";
		int update = runner.update(sql, 1,cid,fid);
		if (update>0) {
			return true;
		} else {
			return false;
		}
	}
	//支付
	public static boolean topay(String fid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "update ticket set payment=? where Ctid=? and Ftid=? ";
		int update = runner.update(sql, 1,cid,fid);
		if (update>0) {
			return true;
		} else {
			return false;
		}
	}

	public static Flight getFlight(String Ftid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql = "select * from flight where Fid= ?";
		Flight flight = runner.query(sql, new BeanHandler<>(Flight.class), Ftid);
		return flight;
	}

	public static List<Flight> getCusFlight(String id) throws SQLException {
		String Cid = id;
		List<Ticket> list = getOrder(Cid);
//		System.out.println(myFlights.size());
				myFlights.clear();
//		System.out.println("myFlights"+myFlights.size());
		for (int i = 0; i < list.size(); i++) {
			Ticket ticket = list.get(i);
			myFlights.add(getFlight(ticket.getFtid()));
		}
//		System.out.println(myFlights.size());
		return myFlights;

	}
}
