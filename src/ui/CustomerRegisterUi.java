package ui;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.CustomerRegisterUtils;

/**
 * 
 * @author stormdony 
 * at 2018/03/04 
 * 客户注册界面
 *
 */

public class CustomerRegisterUi implements ActionListener {
	private JTextField tid;
	private JTextField tpwd;
	private JTextField tname;
	private JTextField tpaperwork;
	private JTextField tphone;
	private JFrame frame;

	public CustomerRegisterUi() {
		frame = new JFrame("客户注册");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(8, 4, 10, 10));
		JLabel id = new JLabel("账号");
		JLabel pwd = new JLabel("密码");
		JLabel name = new JLabel("姓名");
		JLabel phone = new JLabel("电话");
		JLabel paperwork = new JLabel("证件号码");

		tid = new JTextField(20);
		tpwd = new JTextField(20);
		tname = new JTextField(20);
		tpaperwork = new JTextField(20);
		tphone = new JTextField(20);

		Button reg = new Button("注册");
		reg.addActionListener(this);

		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(id);
		pan.add(tid);
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(pwd);
		pan.add(tpwd);
		pan.add(new JLabel());
		
		pan.add(new JLabel());
		pan.add(name);
		pan.add(tname);
		pan.add(new JLabel());
		
		pan.add(new JLabel());
		pan.add(phone);
		pan.add(tphone);
		pan.add(new JLabel());
		
		pan.add(new JLabel());
		pan.add(paperwork);
		pan.add(tpaperwork);
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(reg);
		pan.add(new JLabel());

		container.add(pan);
		frame.setSize(500,400);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="注册") {
			try {
				if (CustomerRegisterUtils.CustomerRegister(tid.getText(), tpwd.getText(), tname.getText(), tphone.getText(), tpaperwork.getText())) {
					System.out.println("注册成功");
					new RegisterSuccessUi();
					frame.dispose();
				}
			} catch (Exception e1) {
				new RegisterFailUi();
				System.out.println("注册失败");
			}
		}
	}


}
