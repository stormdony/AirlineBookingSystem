package ui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.JdbcUtils;

/**
 * 
 * @author stormdony
 * at 2018/03/04
 * ����Ա���뺽����Ϣ
 *
 */

public class ManagerInsertUi implements ActionListener {

	private JTextField tid;
	private JTextField tname;
	private JTextField tstart;
	private JTextField tdestination;
	private JTextField tgrade;
	private JTextField tprice;
	private JTextField tdiscount;
	private String id;
	private Connection conn;
	private PreparedStatement st;
	private JFrame frame;
	private JTextField tbegin;
	private JTextField tend;

	public ManagerInsertUi(String fid) {
		id = fid;
		frame = new JFrame("����¼��");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(12, 4, 10, 10));
		/*
		 * `Fid` int(20) NOT NULL, `Fname` varchar(255) DEFAULT NULL, `start`
		 * varchar(255) DEFAULT NULL, `destination` varchar(255) DEFAULT NULL, `Fgrade`
		 * varchar(255) DEFAULT NULL, `price` double(10,2) DEFAULT NULL, `discount`
		 * double(10,2) DEFAULT NULL, `Mid` int(20) DEFAULT NULL,
		 */
		JLabel Fid = new JLabel("������");
		JLabel Fname = new JLabel("�ɻ�����");
		JLabel start = new JLabel("���");
		JLabel destination = new JLabel("�յ�");
		JLabel Fgrade = new JLabel("�ȼ�");
		JLabel price = new JLabel("Ʊ��");
		JLabel begin = new JLabel("���ʱ��");
		JLabel end = new JLabel("����ʱ��");
		JLabel discount = new JLabel("�ۿ�");

		tid = new JTextField(20);
		tname = new JTextField(20);
		tstart = new JTextField(20);
		tdestination = new JTextField(20);
		tgrade = new JTextField(20);
		tprice = new JTextField(20);
		tdiscount = new JTextField(20);
		tbegin = new JTextField(20);
		tend = new JTextField(20);

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
			/*
			 * private JTextField tid; private JTextField tname; private JTextField tstart;
			 * private JTextField tdestination; private JTextField tgrade; private
			 * JTextField tprice; private JTextField tdiscount;
			 */
			try {
				conn = JdbcUtils.getConnection();
				String sql = "insert into flight values(?,?,?,?,?,?,?,?,?,?)";
				st = conn.prepareStatement(sql);
				st.setString(1, tid.getText().trim());
				st.setString(2, tname.getText().trim());
				st.setString(3, tstart.getText().trim());
				st.setString(4, tdestination.getText().trim());
				st.setString(5, tgrade.getText().trim());
				st.setString(6, tprice.getText().trim());
				st.setString(7, tdiscount.getText().trim());
				st.setString(8, id);
				st.setString(9, tbegin.getText().trim());
				st.setString(10, tend.getText().trim());
				int update = st.executeUpdate();
				if (update >= 1) {
					System.out.println("success~~~~~~~");
					new ManagerInsertFlightSuccessUi();
					frame.dispose();
				}

			} catch (Exception e1) {
//				e1.printStackTrace();
				System.out.println("insert fail");
				new ManagerInsertFlightFailUi();
			}
			JdbcUtils.closeResourse(conn, st, null);

		}else if (e.getActionCommand()=="����") {
			System.out.println("����");
			frame.dispose();
		}

	}

}
