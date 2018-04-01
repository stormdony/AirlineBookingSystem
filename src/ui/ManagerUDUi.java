package ui;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import domain.Flight;
import utils.MainQueryUtils;
import utils.ManagerUDUtils;

public class ManagerUDUi implements ActionListener {

	private JRadioButton tbook;
	private JRadioButton[] jr;
	private List<Flight> flightList = new ArrayList<>();
	private String fid;
	private String mid;

	private JFrame frame;
	private Flight flight;
	private boolean deleteBook;
	private boolean deleteTicket;

	public ManagerUDUi(String Fid, String Mid) throws Exception {
		fid = Fid;
		mid = Mid;
		ResultSet rs = ManagerUDUtils.QueryAll(Fid);
		int i = 0;
		try {
			while (rs.next()) {
				i++;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		frame = new JFrame("查询结果");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();

		// 航班(航班编号(主码),飞机名称,起点,终点,航班等级,票价,折扣)
		JLabel Jid = new JLabel("航班编号");
		JLabel Jname = new JLabel("飞机名称");
		JLabel Jstart = new JLabel("起点");
		JLabel Jdestination = new JLabel("终点");
		JLabel Jgrade = new JLabel("航班等级");
		JLabel Jprice = new JLabel("票价");
		JLabel Jdiscount = new JLabel("折扣");
		JLabel Jbegin = new JLabel("起飞时间");
		JLabel Jend = new JLabel("到达时间");
		JLabel Jbook = new JLabel("修改信息");

		ButtonGroup group = new ButtonGroup();

		pan.setLayout(new GridLayout(i + 4, 12, 10, 10));
		// 顶行空白行
		pan.add(new JLabel(Fid));
		for (int j = 0; j < 11; j++) {
			pan.add(new Label());
		}

		pan.add(new Label());
		pan.add(Jid);
		pan.add(Jname);
		pan.add(Jstart);
		pan.add(Jdestination);
		pan.add(Jgrade);
		pan.add(Jprice);
		pan.add(Jbegin);
		pan.add(Jend);
		pan.add(Jdiscount);
		pan.add(Jbook);
		pan.add(new Label());

		jr = new JRadioButton[i];
		for (int j = 0; j < jr.length; j++) {
			jr[j] = new JRadioButton();

		}

		flightList = ManagerUDUtils.QueryFlightByMid(fid);
		int k = 0;
		for (int j = 0; j < flightList.size(); j++) {
			Flight flight = flightList.get(j);
			String id = flight.getFid();
			String Fname = flight.getFname();
			String Fstart = flight.getStart();
			String Fdestination = flight.getDestination();
			String grade = flight.getFgrade();
			String price = flight.getPrice();
			String Fbegin = flight.getBegin();
			String Fend = flight.getEnd();
			String discount = flight.getDiscount();
			System.out.println(id + "---" + Fname + "--" + Fstart + "--" + Fdestination + "---" + Fbegin + "--" + Fend
					+ "--" + grade + "--" + price + "--" + discount);
			// 创建信息框
			JLabel tid = new JLabel();
			JLabel tname = new JLabel();
			JLabel tstart = new JLabel();
			JLabel tdestination = new JLabel();
			JLabel tgrade = new JLabel();
			JLabel tprice = new JLabel();
			JLabel tbegin = new JLabel();
			JLabel tend = new JLabel();
			JLabel tdiscount = new JLabel();

			group.add(jr[k]);

			tid.setText(id);
			tname.setText(Fname);
			tstart.setText(Fstart);
			tdestination.setText(Fdestination);
			tgrade.setText(grade);
			tprice.setText(price);
			tbegin.setText(Fbegin);
			tend.setText(Fend);
			tdiscount.setText(discount);
			pan.add(new Label());

			pan.add(tid);
			pan.add(tname);
			pan.add(tstart);
			pan.add(tdestination);
			pan.add(tgrade);
			pan.add(tprice);
			pan.add(tbegin);
			pan.add(tend);
			pan.add(tdiscount);
			pan.add(jr[k]);
			pan.add(new Label());
			k++;
		}

		for (int j = 0; j < 4; j++) {
			pan.add(new Label());
		}
		Button back = new Button("返回");
		Button update = new Button("修改航班");
		Button delete = new Button("删除航班");
		back.addActionListener(this);
		delete.addActionListener(this);
		update.addActionListener(this);
		pan.add(back);
		pan.add(update);
		pan.add(delete);
		for (int j = 0; j < 17; j++) {
			pan.add(new Label());
		}

		container.add(pan);
		frame.setSize(900, 100 + 50 * i);
		frame.setLocation(300, 250);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "修改航班") {
			System.out.println("修改航班");
			// 弹出登录界面,登录后展示选中的信息,弹出下单界面,添加航班信息到数据库,并提示下单成功
			// 传递航班的编号,客户id
			for (int i = 0; i < jr.length; i++) {
				if (jr[i].isSelected()) {
					System.out.println(i);
					System.out.println(flightList.get(i).toString());
					String Fid = flightList.get(i).getFid().trim();
					List<Flight> list = null;
					try {
						list = ManagerUDUtils.QueryFlightByFid(Fid);
						for (int j = 0; j < list.size(); j++) {
							flight = list.get(j);
						}
						new ManagerUpdateFlightUi(flight);
						frame.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		} else if (e.getActionCommand() == "删除航班") {
			System.out.println("删除航班");
			for (int i = 0; i < jr.length; i++) {
				if (jr[i].isSelected()) {
					System.out.println(i);
					System.out.println(flightList.get(i).toString());
					String Fid = flightList.get(i).getFid().trim();
					try {
						List<Flight> list = ManagerUDUtils.QueryFlightByMid(mid);
						if (list.size() > 0) {
							List<Flight> bookByFid = ManagerUDUtils.QueryBookByFid(Fid);
							if (bookByFid.size() > 0) {
								deleteBook = ManagerUDUtils.deleteBook(Fid);
							}
							List<Flight> ticketByFid = ManagerUDUtils.QueryTicketByFid(Fid);
							if (ticketByFid.size() > 0) {
								deleteTicket = ManagerUDUtils.deleteTicket(Fid);
							}
							boolean deleteFlight = ManagerUDUtils.deleteFlight(mid);
							if (deleteFlight) {
								System.out.println("删除成功");
								frame.dispose();
							}
						} else {
							System.out.println("没有你管理的航班");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		} else if (e.getActionCommand() == "返回") {
			frame.dispose();
		}

	}
	// public static void main(String[] args) {
	// try {
	// new ManagerUDUi("2002");
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
