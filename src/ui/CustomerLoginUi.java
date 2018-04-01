package ui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utils.CustomerLoginUtils;
import utils.ManagerLoginUtils;

/**
 * 
 * @author stormdony
 * at 2018/03/04
 * 客户登录界面
 *
 */

public class CustomerLoginUi implements ActionListener {

	private JTextField tid;
	private JTextField tpwd;
	private JFrame frame;

	public CustomerLoginUi() {
		frame = new JFrame("客户登陆");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5, 4,10,10));
		JLabel id = new JLabel("账号");
		JLabel pwd = new JLabel("密码");

		tid = new JTextField(20);
		tpwd = new JPasswordField(20);
		
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(id);
		pan.add(tid);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(pwd);
		pan.add(tpwd);
		pan.add(new Label());

		JButton done = new JButton("登录");
		pan.add(new Label());
		pan.add(done);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());

		done.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (CustomerLoginUtils.checkLogin(tid.getText(), tpwd.getText())) {
						frame.dispose();
//						传用户的账号进去,用于显示
						new CustomerMainUi(tid.getText());
					}
					else {
						System.out.println("fail");
						new LoginFailUi();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		container.add(pan);
		frame.setSize(400, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="登录") {
//			try {
//				if (CustomerLoginUtils.checkLogin(tid.getText(), tpwd.getText())) {
//					frame.dispose();
////					传用户的账号进去,用于显示
//					new CustomerMainUi(tid.getText());
//				}
//				else {
//					System.out.println("fail");
//					new LoginFailUi();
//				}
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
		}
	}
	
	public CustomerLoginUi(String Fid) {
		frame = new JFrame("客户登陆");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5, 4,10,10));
		JLabel id = new JLabel("账号");
		JLabel pwd = new JLabel("密码");

		tid = new JTextField(20);
		tpwd = new JPasswordField(20);
		
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(id);
		pan.add(tid);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(pwd);
		pan.add(tpwd);
		pan.add(new Label());

		JButton done = new JButton("登录");
		pan.add(new Label());
		pan.add(done);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());

		done.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean checkLogin =false;
				try {
					checkLogin = CustomerLoginUtils.checkLogin(tid.getText().trim(), tpwd.getText().trim());
					if (checkLogin) {
						new CustomerOrder(Fid, tid.getText().trim());
					}else {
						new LoginFailUi();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});

		container.add(pan);
		frame.setSize(400, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

}
