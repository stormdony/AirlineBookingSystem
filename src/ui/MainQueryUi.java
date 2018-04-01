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

/**
 * 
 * @author stormdony at 2018/03/04 �������ѯ���صĽ��������չʾ����
 *
 */
public class MainQueryUi implements ActionListener {

	private JRadioButton tbook;
	private JRadioButton[] jr;
	private List<Flight> flightList = new ArrayList<>();
	private JFrame frame;
	// private String buyId;//ѡ�������ĺ���id

	public MainQueryUi(String Fid, String start, String destination, String Fgrade) throws Exception {

		ResultSet rs = MainQueryUtils.QueryAll(Fid, start, destination, Fgrade);
		int i = 0;
		try {
			while (rs.next()) {
				i++;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (i > 0) {
			frame = new JFrame("��ѯ���");
			Container container = frame.getContentPane();
			JPanel pan = new JPanel();

			// ����(������(����),�ɻ�����,���,�յ�,����ȼ�,Ʊ��,�ۿ�)
			JLabel Jid = new JLabel("������");
			JLabel Jname = new JLabel("�ɻ�����");
			JLabel Jstart = new JLabel("���");
			JLabel Jdestination = new JLabel("�յ�");
			JLabel Jgrade = new JLabel("����ȼ�");
			JLabel Jprice = new JLabel("Ʊ��");
			JLabel Jdiscount = new JLabel("�ۿ�");
			JLabel Jbegin = new JLabel("���ʱ��");
			JLabel Jend = new JLabel("����ʱ��");
			JLabel Jbook = new JLabel("�Ƿ񶩹�");

			ButtonGroup group = new ButtonGroup();

			pan.setLayout(new GridLayout(i + 4, 12, 10, 10));
			// ���пհ���
			for (int j = 0; j < 12; j++) {
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

			flightList = MainQueryUtils.QueryFlight(Fid, start, destination, Fgrade);
			int k = 0;
			// while (Set.next()) {
			for (int j = 0; j < flightList.size(); j++) {
				Flight flight = flightList.get(j);
				String id = flight.getFid();
				String Fname = flight.getFname();
				String Fstart = flight.getStart();
				String Fdestination = flight.getDestination();
				String grade = flight.getFgrade();
				String price = flight.getPrice();
				String begin = flight.getBegin();
				String end = flight.getEnd();
				String discount = flight.getDiscount();
				System.out.println(id + "---" + Fname + "--" + Fstart + "--" + Fdestination + "---" + begin + "--" + end
						+ "--" + grade + "--" + price + "--" + discount);
				// ������Ϣ��
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
				tbegin.setText(begin);
				tend.setText(end);
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
			Button buy = new Button("ȷ�϶���");
			Button back = new Button("����");
			buy.addActionListener(this);
			back.addActionListener(this);
			pan.add(back);
			pan.add(buy);
			for (int j = 0; j < 16; j++) {
				pan.add(new Label());
			}

			container.add(pan);
			frame.setSize(900, 100 + 50 * i);
			frame.setLocation(300, 250);
			frame.setVisible(true);
		}else {
			System.out.println("��ѯʧ��---");
			new QueryFailUi();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ȷ�϶���") {
			System.out.println("ȷ�϶���");
			// ������¼����,��¼��չʾѡ�е���Ϣ,�����µ�����,��Ӻ�����Ϣ�����ݿ�,����ʾ�µ��ɹ�
			// ���ݺ���ı��,�ͻ�id
			for (int i = 0; i < jr.length; i++) {
				if (jr[i].isSelected()) {
					System.out.println(i);
					String fid = flightList.get(i).getFid().trim();
					new CustomerLoginUi(fid);
					frame.dispose();
				}
			}
		} else if (e.getActionCommand() == "����") {
			frame.dispose();
		}

	}

}
