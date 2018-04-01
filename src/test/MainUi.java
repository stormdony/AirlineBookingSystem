package test;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.*;

import utils.*;
/**
 * 
 * @author stormdony
 * at 2018/03/04
 * ����ڽ���
 *
 */
public class MainUi implements ActionListener {
	private JTextField tid;
	private JTextField tstart;
	private JTextField tdestination;
	private JTextField tgrade;

	public MainUi() {
		JFrame frame = new JFrame("������");
		Container container = frame.getContentPane();
		// ��¼�����˵�
		JMenuBar bar = new JMenuBar();
		JMenuItem cus = new JMenuItem("�ͻ���¼");
		cus.addActionListener(this);
		JMenuItem mng = new JMenuItem("����Ա��¼");
		mng.addActionListener(this);
		JMenu login = new JMenu("��¼");
		JMenu reg = new JMenu("ע��");
		JMenuItem regm = new JMenuItem("����Աע��");
		JMenuItem regc = new JMenuItem("�ͻ�ע��");
		reg.addActionListener(this);
		regm.addActionListener(this);
		regc.addActionListener(this);
		reg.add(regc);
		reg.add(regm);
		login.add(cus);
		login.add(mng);
		bar.add(reg);
		bar.add(login);

		// ��ѯ����
		JLabel Fid = new JLabel("������");
		JLabel start = new JLabel("���");
		JLabel destination = new JLabel("�յ�");
		JLabel Fgrade = new JLabel("����ȼ�");

		tid = new JTextField(20);
	
		
		
		
		
		
		
		tstart = new JTextField(20);
		tstart.setEditable(false);
		tstart.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				tstart.setEditable(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tdestination = new JTextField(20);
		tdestination.setEditable(false);
		tdestination.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				tdestination.setEditable(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		tgrade = new JTextField(20);
		tgrade.setEditable(false);
		tgrade.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				tgrade.setEditable(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JButton query = new JButton("��ѯ");
		query.addActionListener(this);

		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(6, 6, 10, 10));

		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(bar);
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(Fid);
		pan.add(tid);
		pan.add(start);
		pan.add(tstart);
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(destination);
		pan.add(tdestination);
		pan.add(Fgrade);
		pan.add(tgrade);
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(query);
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());

		container.add(pan);
		frame.setSize(545, 260);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new MainUi();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "�ͻ�ע��") {
			System.out.println("�ͻ�ע��");
			new CustomerRegisterUi();
		} else if (e.getActionCommand() == "����Աע��") {
			System.out.println("����Աע��");
			new ManagerRegisterUi();
		} else if (e.getActionCommand() == "�ͻ���¼") {
			System.out.println("�ͻ���¼");
			new CustomerLoginUi();
		} else if (e.getActionCommand() == "����Ա��¼") {
			System.out.println("����Ա��¼");
			new ManagerLoginUi();
		}else {
			System.out.println("��ѯ");
			try {
				new MainQueryUi(tid.getText(), tstart.getText(), tdestination.getText(), tgrade.getText());
			} catch (Exception e1) {
				System.out.println("��ѯʧ��---");
				e1.printStackTrace();
			}
			
		}

	}
}
