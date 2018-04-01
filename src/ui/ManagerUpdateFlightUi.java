package ui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Flight;
import utils.JdbcUtils;
import utils.ManagerUDUtils;

/**
 * 
 * @author stormdony at 2018/03/08 ����Ա���º�����Ϣ
 *
 */

public class ManagerUpdateFlightUi implements ActionListener {

	private JLabel tid;
	private JTextField tname;
	private JTextField tstart;
	private JTextField tdestination;
	private JTextField tgrade;
	private JTextField tprice;
	private JTextField tdiscount;
	private Connection conn;
	private PreparedStatement st;
	private JFrame frame;
	private JTextField tbegin;
	private JTextField tend;
	private Flight flight2;
	private static Flight flight;

	public ManagerUpdateFlightUi(Flight flight) {
		flight2 = flight;
		frame = new JFrame("�޸ĺ�����Ϣ");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(12, 4, 10, 10));

		JLabel Fid = new JLabel("������");
		JLabel Fname = new JLabel("�ɻ�����");
		JLabel start = new JLabel("���");
		JLabel destination = new JLabel("�յ�");
		JLabel Fgrade = new JLabel("�ȼ�");
		JLabel price = new JLabel("Ʊ��");
		JLabel begin = new JLabel("���ʱ��");
		JLabel end = new JLabel("����ʱ��");
		JLabel discount = new JLabel("�ۿ�");

		tid = new JLabel(flight2.getFid());
		tname = new JTextField(flight2.getFname());
		tstart = new JTextField(flight2.getStart());
		tdestination = new JTextField(flight2.getDestination());
		tgrade = new JTextField(flight2.getFgrade());
		tprice = new JTextField(flight2.getPrice());
		tdiscount = new JTextField(flight2.getDiscount());
		tbegin = new JTextField(flight2.getBegin());
		tend = new JTextField(flight2.getEnd());

		JButton done = new JButton("ȷ��");
		JButton cancel = new JButton("����");
		done.addActionListener(this);
		cancel.addActionListener(this);

		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(Fid);
		pan.add(tid);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(Fname);
		pan.add(tname);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(start);
		pan.add(tstart);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(destination);
		pan.add(tdestination);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(Fgrade);
		pan.add(tgrade);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(price);
		pan.add(tprice);
		pan.add(new Label());

		pan.add(new Label());
		pan.add(discount);
		pan.add(tdiscount);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(begin);
		pan.add(tbegin);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(end);
		pan.add(tend);
		pan.add(new Label());

		pan.add(new Label());
		pan.add(cancel);
		pan.add(done);
		pan.add(new Label());
		pan.add(new Label());

		container.add(pan);
		frame.setSize(600, 350);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ȷ��") {
			try {
				conn = JdbcUtils.getConnection();
				String id = tid.getText();
				String name = tname.getText();
				String start = tstart.getText();
				String destination = tdestination.getText();
				String grade = tgrade.getText();
				String price = tprice.getText();
				String discount = tdiscount.getText();
				String begin = tbegin.getText();
				String end = tend.getText();
				String mid = flight2.getMid();

				boolean flag = true;
				flag = (flight2.getFid().equals(id) && flight2.getFname().equals(name)
						&& flight2.getStart().equals(start)
						&& flight2.getDestination().equals(destination)
						&& flight2.getFgrade().equals(grade) && flight2.getPrice().equals(price)
						&& flight2.getDiscount().equals(discount)
						&& flight2.getBegin().equals(begin) && flight2.getEnd().equals(end));
				if (!flag) {

					String sql = "update  flight set Fname=?,start=?,destination=?,Fgrade=?,price=?,discount=?,begin=?,end=? where Mid=? and Fid=?";
					st = conn.prepareStatement(sql);
					st.setString(1, name.trim());
					st.setString(2, start.trim());
					st.setString(3, destination.trim());
					st.setString(4, grade.trim());
					st.setString(5, price.trim());
					st.setString(6, discount.trim());
					st.setString(7, begin.trim());
					st.setString(8, end.trim());
					st.setString(9, mid);
					st.setString(10, id.trim());
					int update = st.executeUpdate();
					if (update >= 1) {
						System.out.println("success~~~~~~~");
						new ManagerInsertFlightSuccessUi();
					}
				} else {
					System.out.println("fail");
				}
			} catch (Exception e1) {
//				 e1.printStackTrace();
				System.out.println("insert fail");
				new ManagerInsertFlightFailUi();
			}
			JdbcUtils.closeResourse(conn, st, null);

		} else if (e.getActionCommand() == "����") {
			System.out.println("����");
			frame.dispose();
		}

	}

}
