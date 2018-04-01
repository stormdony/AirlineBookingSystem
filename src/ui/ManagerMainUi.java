package ui;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import domain.Flight;
import utils.ManagerUDUtils;

public class ManagerMainUi implements ActionListener {

	private JMenu menu;
	private String Mid;

	public ManagerMainUi(String id) {
		Mid = id;
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("管理员界面");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(4, 3, 10, 10));
		JMenuBar bar = new JMenuBar();
		menu = new JMenu(id);
		JMenuItem item = new JMenuItem("更改密码");
		JMenuItem logout = new JMenuItem("退出");
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("更改密码");
				new ManagerUpdatePwdUi(id);
			}
		});
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("退出");
				frame.dispose();
			}
		});
		menu.add(item);
		menu.add(logout);
		bar.add(menu);
		Button update = new Button("更改航班信息");
		Button insert = new Button("插入航班");
		update.addActionListener(this);
		insert.addActionListener(this);
		pan.add(bar);
		pan.add(new JLabel());
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(update);
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(insert);
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());

		container.add(pan);
		frame.setSize(350, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "更改航班信息") {
			System.out.println("更改航班信息");
			List<Flight> queryFlightByMid = null;
			try {
				queryFlightByMid = ManagerUDUtils.QueryFlightByMid(Mid);
				if (queryFlightByMid.size() > 0) {
					try {
						new ManagerUDUi(menu.getText().trim(), Mid);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					System.out.println("没有航班信息");
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} else if (e.getActionCommand() == "插入航班") {
			System.out.println("插入航班");
			new ManagerInsertUi(menu.getText().trim());
		}
	}
}
