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
			// ����û�ж����Ļ���
			new CustomerNoFlightUi();
		} else {
			frame = new JFrame("��ѯ���");
			Container container = frame.getContentPane();
			JPanel pan = new JPanel();
			// ����(������(����),�ɻ�����,���,�յ�,����ȼ�,Ʊ��,�ۿ�)
			JLabel Jid = new JLabel("������");
			JLabel Jname = new JLabel("��������");
			JLabel Jstart = new JLabel("���");
			JLabel Jdestination = new JLabel("�յ�");
			JLabel Jgrade = new JLabel("����ȼ�");
			JLabel Jprice = new JLabel("Ʊ��");
			JLabel Jbegin = new JLabel("���ʱ��");
			JLabel Jend = new JLabel("����ʱ��");
			JLabel Jdiscount = new JLabel("�ۿ�");
			JLabel Jpayment = new JLabel("�Ƿ񸶿�");
			JLabel Jbook = new JLabel("�Ƿ��˶�");
			JLabel Jsele = new JLabel("ѡ��");
			JButton topay = new JButton("����");
			JButton tobook = new JButton("�˶�");
			
			topay.addActionListener(this);
			tobook.addActionListener(this);
			ButtonGroup group = new ButtonGroup();

			pan.setLayout(new GridLayout(i + 3, 14, 10, 10));
			// ���пհ���
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
					System.out.println("������");
					new FailUi("ϵͳ��æ,�Ժ�����!");
					// e.printStackTrace();
				}
				pay = ticket.getPayment();
				rebook = ticket.getRebook();
				if ("1".equals(pay)) {
					payment.setText("��֧��");
				} else if ("0".equals(pay)) {
					payment.setText("������");
				}
				if ("1".equals(rebook)) {
					book.setText("���˶�");
				} else if ("0".equals(rebook)) {
					book.setText("δ�˶�");
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
		if (e.getActionCommand() == "����") {
			if ("0".equals(pay)) {
				try {
					boolean topay = CustomerMyorderUtils.topay(fid);
					if (topay) {
						new SuccessUi("����ɹ�������");
						frame.dispose();
					} else {
						new FailUi("ϵͳ��æ�����Ժ����ԣ�");
						frame.dispose();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else {
				new FailUi("���Ѹ�������ظ�������");
			}
		} else if (e.getActionCommand() == "�˶�") {
			if ("0".equals(rebook)) {
				try {
					boolean rebook = CustomerMyorderUtils.tobook(fid);
					if (rebook) {
						new SuccessUi("�˶��ɹ�������");
						frame.dispose();
					} else {
						new FailUi("ϵͳ��æ�����Ժ����ԣ�");
						frame.dispose();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}else {
				new FailUi("�����˶��������ظ�������");
			}
		}
	}

}
