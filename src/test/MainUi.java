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
 * 主入口界面
 *
 */
public class MainUi implements ActionListener {
	private JTextField tid;
	private JTextField tstart;
	private JTextField tdestination;
	private JTextField tgrade;

	public MainUi() {
		JFrame frame = new JFrame("主界面");
		Container container = frame.getContentPane();
		// 登录下拉菜单
		JMenuBar bar = new JMenuBar();
		JMenuItem cus = new JMenuItem("客户登录");
		cus.addActionListener(this);
		JMenuItem mng = new JMenuItem("管理员登录");
		mng.addActionListener(this);
		JMenu login = new JMenu("登录");
		JMenu reg = new JMenu("注册");
		JMenuItem regm = new JMenuItem("管理员注册");
		JMenuItem regc = new JMenuItem("客户注册");
		reg.addActionListener(this);
		regm.addActionListener(this);
		regc.addActionListener(this);
		reg.add(regc);
		reg.add(regm);
		login.add(cus);
		login.add(mng);
		bar.add(reg);
		bar.add(login);

		// 查询输入
		JLabel Fid = new JLabel("航班编号");
		JLabel start = new JLabel("起点");
		JLabel destination = new JLabel("终点");
		JLabel Fgrade = new JLabel("航班等级");

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
		JButton query = new JButton("查询");
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
		if (e.getActionCommand() == "客户注册") {
			System.out.println("客户注册");
			new CustomerRegisterUi();
		} else if (e.getActionCommand() == "管理员注册") {
			System.out.println("管理员注册");
			new ManagerRegisterUi();
		} else if (e.getActionCommand() == "客户登录") {
			System.out.println("客户登录");
			new CustomerLoginUi();
		} else if (e.getActionCommand() == "管理员登录") {
			System.out.println("管理员登录");
			new ManagerLoginUi();
		}else {
			System.out.println("查询");
			try {
				new MainQueryUi(tid.getText(), tstart.getText(), tdestination.getText(), tgrade.getText());
			} catch (Exception e1) {
				System.out.println("查询失败---");
				e1.printStackTrace();
			}
			
		}

	}
}
