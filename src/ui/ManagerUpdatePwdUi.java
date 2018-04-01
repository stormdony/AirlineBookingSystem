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
		frame = new JFrame("��������");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5, 4, 10, 10));
		JLabel JMid = new JLabel("�˺�");
		JLabel Jpwd = new JLabel("����");
		jid = new JLabel(id);
		pwd = new JTextField(20);
		Button back = new Button("����");
		Button done = new Button("ȷ��");
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
		if (e.getActionCommand()=="����") {
			System.out.println("����");
			frame.dispose();
		}else if (e.getActionCommand()=="ȷ��") {
			System.out.println("ȷ��");
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
