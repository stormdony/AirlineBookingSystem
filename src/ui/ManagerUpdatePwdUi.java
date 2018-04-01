package ui;

import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.ManagerUpdatePwdUtils;

public class ManagerUpdatePwdUi implements ActionListener {
	private JLabel jid;
	private JTextField pwd;
	private JFrame frame;
	public ManagerUpdatePwdUi(String id) {
		frame = new JFrame("更改密码");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5, 4, 10, 10));
		JLabel JMid = new JLabel("账号");
		JLabel Jpwd = new JLabel("密码");
		jid = new JLabel(id);
		pwd = new JTextField(20);
		Button back = new Button("返回");
		Button done = new Button("确认");
		done.addActionListener(this);
		back.addActionListener(this);
		pwd.setText("123");
		
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		
		pan.add(new JLabel());
		pan.add(JMid);
		pan.add(jid);
		pan.add(new JLabel());
		
		pan.add(new JLabel());
		pan.add(Jpwd);
		pan.add(pwd);
		pan.add(new JLabel());
		
		pan.add(new JLabel());
		pan.add(back);
		pan.add(done);
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		
		
		container.add(pan);
		frame.setSize(300, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="返回") {
			System.out.println("返回");
			frame.dispose();
		}else if (e.getActionCommand()=="确认") {
			System.out.println("确认");
			boolean checkUpdatePwd =false;
			try {
				 checkUpdatePwd = ManagerUpdatePwdUtils.checkUpdatePwd(jid.getText().trim(), pwd.getText().trim());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if (checkUpdatePwd) {
				new UpdateSuccessUi();
			}else {
				new UpdateFailUi();
			}
			
		}
	}
}
