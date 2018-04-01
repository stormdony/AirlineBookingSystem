package utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.utils.DataSourseUtils;
import domain.Customer;
import domain.Ticket;

public class CustomerOrderUtils {
	private static String tid;
//	找出Customer中的Tid,再在Ticket中添加航班信息
	public static List<Customer> getCustomer(String Cid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql ="select * from customer where Cid=?";
		List<Customer> list = runner.query(sql, new BeanListHandler<>(Customer.class), Cid);
		return list;
	}
	public static String getTid(String Cid) throws SQLException {
		List<Customer> list = getCustomer(Cid);
		for (int i = 0; i < list.size(); i++) {
			Customer customer = list.get(i);
			tid = customer.getTid();
		}
		return tid;
	}
	public static List<Ticket> setTid() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
		String sql ="select * from ticket ";
		List<Ticket> list = runner.query(sql, new BeanListHandler<>(Ticket.class));
		return list;
	}
	
	public static boolean CustomerOrder(String Cid,String Fid) {
		try {
			List<Ticket> list = setTid();
			String tid=list.get(list.size()-1).getTid();
			int tid2 =Integer.parseInt(tid)+1;
			QueryRunner runner = new QueryRunner(DataSourseUtils.getDataSourse());
			String sql ="insert into ticket values(?,?,?,?,?)";
			int i = runner.update(sql, tid2,Fid,Cid,"0","0");
			if (i>0) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("下单失败");
			return false;
		}
	}
	
}
