package ui;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Flight;
import utils.CustomerOrderUtils;
import utils.MainQueryUtils;

public class CustomerOrder implements ActionListener {
	private List<Flight> list=new ArrayList<>();
	private JFrame frame;
	private JLabel jcid;
	private String fid;
	public CustomerOrder(String Fid,String Cid) {
		fid=Fid;
		frame = new JFrame("ȷ�϶���");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		
	//	����(������(����),�ɻ�����,���,�յ�,����ȼ�,Ʊ��,�ۿ�)
		JLabel Jid = new JLabel("������");
		JLabel Jname = new JLabel("�ɻ�����");
		JLabel Jstart = new JLabel("���");
		JLabel Jdestination = new JLabel("�յ�");
		JLabel Jgrade = new JLabel("����ȼ�");
		JLabel Jprice = new JLabel("Ʊ��");
		JLabel Jdiscount = new JLabel("�ۿ�");
		JLabel Jbegin = new JLabel("���ʱ��");
		JLabel Jend = new JLabel("����ʱ��");
		jcid = new JLabel(Cid);
		Button back = new Button("����");
		Button done = new Button("ȷ��");
		back.addActionListener(this);
		done.addActionListener(this);
		
		pan.setLayout(new GridLayout(5, 9, 10, 10));
		
		try {
			list = MainQueryUtils.QueryFlight(Fid, "", "", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�µ�ʧ��");
		}
		pan.add(jcid);
		for (int i = 0; i < 9; i++) {
			pan.add(new JLabel());
		}
		
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(Jid);
		pan.add(Jname);
		pan.add(Jstart);
		pan.add(Jdestination);
		pan.add(Jgrade);
		pan.add(Jprice);
		pan.add(Jdiscount);
		pan.add(Jbegin);
		pan.add(Jend);
		pan.add(Jname);
		pan.add(new JLabel());
		
		
		for (int i = 0; i < list.size(); i++) {
			Flight flight = list.get(i);
			String id = flight.getFid();
			String Fname = flight.getFname();
			String Fstart =flight.getStart();
			String Fdestination = flight.getDestination();
			String Fgrade = flight.getFgrade();
			String price = flight.getPrice();
			String begin = flight.getBegin();
			String end = flight.getEnd();
			String discount = flight.getDiscount();
			System.out.println(Fid+"---"+Fname+"--"+Fstart+
					"--"+Fdestination+"---"+begin+"--"+end+"--"+Fgrade+"--"+price+"--"+discount);
			//������Ϣ��
			JLabel tid = new JLabel();
			JLabel tname = new JLabel();
			JLabel tstart = new JLabel();
			JLabel tdestination = new JLabel();
			JLabel tgrade = new JLabel();
			JLabel tprice = new JLabel();
			JLabel tbegin = new JLabel();
			JLabel tend = new JLabel();
			JLabel tdiscount = new JLabel();
			tid.setText(id);
			tname.setText(Fname);
			tstart.setText(Fstart);
			tdestination.setText(Fdestination);
			tgrade.setText(Fgrade);
			tprice.setText(price);
			tbegin.setText(begin);
			tend.setText(end);
			tdiscount.setText(discount);
			
			pan.add(new JLabel());
			pan.add(tid);
			pan.add(tstart);
			pan.add(tdestination);
			pan.add(tgrade);
			pan.add(tprice);
			pan.add(tdiscount);
			pan.add(tbegin);
			pan.add(tend);
			pan.add(tname);
			pan.add(new JLabel());
			
		}
		for (int i = 0; i < 4; i++) {
			pan.add(new JLabel());
		}
		pan.add(back);
		pan.add(done);
		for (int i = 0; i < 14; i++) {
			pan.add(new JLabel());
		}
		
		
		container.add(pan);
		frame.setSize(900, 250);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="����") {
			System.out.println("����");
			frame.dispose();
		} else if (e.getActionCommand()=="ȷ��") {
			System.out.println("ȷ��");
			 boolean order = CustomerOrderUtils.CustomerOrder(jcid.getText().trim(), fid);
			 if (order) {
				new OrderSuccessUi();
				frame.dispose();
			} else {
				new OrderFailUi();
			}
		} 
	}
}
