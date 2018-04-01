package wbui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import domain.Flight;
import domain.Ticket;
import ui.CustomerNoFlightUi;
import ui.FailUi;
import ui.SuccessUi;
import utils.CustomerMyorderUtils;

public class CustomerFlightInfoUi implements ActionListener {
	private JRadioButton[] jr;
	private String pay;
	private String rebook;
	private String fid;
	private JFrame frame;

	public CustomerFlightInfoUi(List<Flight> flights) throws SQLException {
		int i = flights.size();
		System.out.println("i=" + i);
		if (i <= 0) {
			// 弹出没有订单的画面
			new CustomerNoFlightUi();
		} else {
			frame = new JFrame("查询结果");
			Container container = frame.getContentPane();
			JPanel pan = new JPanel();
			// 航班(航班编号(主码),飞机名称,起点,终点,航班等级,票价,折扣)
			JLabel Jid = new JLabel("航班编号");
			JLabel Jname = new JLabel("航班名称");
			JLabel Jstart = new JLabel("起点");
			JLabel Jdestination = new JLabel("终点");
			JLabel Jgrade = new JLabel("航班等级");
			JLabel Jprice = new JLabel("票价");
			JLabel Jbegin = new JLabel("起飞时间");
			JLabel Jend = new JLabel("到达时间");
			JLabel Jdiscount = new JLabel("折扣");
			JLabel Jpayment = new JLabel("是否付款");
			JLabel Jbook = new JLabel("是否退订");
			JLabel Jsele = new JLabel("选定");
			JButton topay = new JButton("付款");
			JButton tobook = new JButton("退订");
			
			topay.addActionListener(this);
			tobook.addActionListener(this);
			ButtonGroup group = new ButtonGroup();

			pan.setLayout(new GridLayout(i + 3, 14, 10, 10));
			// 顶行空白行
			for (int j = 0; j < 14; j++) {
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
			pan.add(Jpayment);
			pan.add(Jbook);
			pan.add(Jsele);
			pan.add(new Label());

			jr = new JRadioButton[i];
			for (int j = 0; j < jr.length; j++) {
				jr[j] = new JRadioButton();
			}

			List<Ticket> tickets = CustomerMyorderUtils.getbook();
			int k = 0;
			for (int j = 0; j < i; j++) {
				
				JLabel id = new JLabel();
				JLabel name = new JLabel();
				JLabel start = new JLabel();
				JLabel destination = new JLabel();
				JLabel grade = new JLabel();
				JLabel price = new JLabel();
				JLabel begin = new JLabel();
				JLabel end = new JLabel();
				JLabel discount = new JLabel();
				JLabel payment = new JLabel();
				JLabel book = new JLabel();

				group.add(jr[k]);

				Flight flight = flights.get(j);

				fid = flight.getFid();
				String fname = flight.getFname();
				String begin2 = flight.getBegin();
				String destination2 = flight.getDestination();
				String discount2 = flight.getDiscount();
				String end2 = flight.getEnd();
				String fgrade = flight.getFgrade();
				String price2 = flight.getPrice();
				String start2 = flight.getStart();

				id.setText(fid);
				name.setText(fname);
				start.setText(start2);
				destination.setText(destination2);
				grade.setText(fgrade);
				price.setText(price2);
				begin.setText(begin2);
				end.setText(end2);
				discount.setText(discount2);
				Ticket ticket = null;
				try {
					ticket = tickets.get(j);
				} catch (Exception e) {
					System.out.println("出错了");
					new FailUi("系统繁忙,稍后重试!");
					// e.printStackTrace();
				}
				pay = ticket.getPayment();
				rebook = ticket.getRebook();
				if ("1".equals(pay)) {
					payment.setText("已支付");
				} else if ("0".equals(pay)) {
					payment.setText("待付款");
				}
				if ("1".equals(rebook)) {
					book.setText("已退订");
				} else if ("0".equals(rebook)) {
					book.setText("未退订");
				}
				pan.add(new Label());
				pan.add(id);
				pan.add(name);
				pan.add(start);
				pan.add(destination);
				pan.add(grade);
				pan.add(price);
				pan.add(begin);
				pan.add(end);
				pan.add(discount);
				pan.add(payment);
				pan.add(book);
				pan.add(jr[k]);
				pan.add(new Label());
				k++;
			}
				pan.add(new JLabel());
				pan.add(new JLabel());
				pan.add(new JLabel());
				pan.add(new JLabel());
				pan.add(new JLabel());
				pan.add(new JLabel());
				pan.add(tobook);
				pan.add(topay);
				pan.add(new JLabel());
				pan.add(new JLabel());
				pan.add(new JLabel());
				pan.add(new JLabel());
				pan.add(new JLabel());
				pan.add(new JLabel());
				
			

			container.add(pan);
			frame.setSize(1000, 100 + 50 * i);
			frame.setLocation(300, 250);
			frame.setVisible(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "付款") {
			if ("0".equals(pay)) {
				try {
					boolean topay = CustomerMyorderUtils.topay(fid);
					if (topay) {
						new SuccessUi("付款成功！！！");
						frame.dispose();
					} else {
						new FailUi("系统繁忙，请稍后重试！");
						frame.dispose();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else {
				new FailUi("你已付款，无需重复操作！");
			}
		} else if (e.getActionCommand() == "退订") {
			if ("0".equals(rebook)) {
				try {
					boolean rebook = CustomerMyorderUtils.tobook(fid);
					if (rebook) {
						new SuccessUi("退订成功！！！");
						frame.dispose();
					} else {
						new FailUi("系统繁忙，请稍后重试！");
						frame.dispose();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else {
				new FailUi("你已退订，无需重复操作！");
			}
		}
	}

}
