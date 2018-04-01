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
 * �ͻ�ע�����
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
		frame = new JFrame("�ͻ�ע��");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(8, 4, 10, 10));
		JLabel id = new JLabel("�˺�");
		JLabel pwd = new JLabel("����");
		JLabel name = new JLabel("����");
		JLabel phone = new JLabel("�绰");
		JLabel paperwork = new JLabel("֤������");

		tid = new JTextField(20);
		tpwd = new JTextField(20);
		tname = new JTextField(20);
		tpaperwork = new JTextField(20);
		tphone = new JTextField(20);

		Button reg = new Button("ע��");
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
		if (e.getActionCommand()=="ע��") {
			try {
				if (CustomerRegisterUtils.CustomerRegister(tid.getText(), tpwd.getText(), tname.getText(), tphone.getText(), tpaperwork.getText())) {
					System.out.println("ע��ɹ�");
					new RegisterSuccessUi();
					frame.dispose();
				}
			} catch (Exception e1) {
				new RegisterFailUi();
				System.out.println("ע��ʧ��");
			}
		}
	}


}
