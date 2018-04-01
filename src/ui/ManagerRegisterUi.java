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

import utils.ManagerRegisterUtils;

/**
 * 
 * @author stormdony 
 * at 2018/03/04 
 * ����Աע�����
 *
 */

public class ManagerRegisterUi implements ActionListener {
	private JTextField tid;
	private JTextField tpwd;

	public ManagerRegisterUi() {
		JFrame frame = new JFrame("����Աע��");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5, 4, 10, 10));
		JLabel id = new JLabel("�˺�");
		JLabel pwd = new JLabel("����");

		tid = new JTextField(20);
		tpwd = new JTextField(20);

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
		pan.add(new JLabel());
		pan.add(reg);
		pan.add(new JLabel());

		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());
		pan.add(new JLabel());

		container.add(pan);
		frame.setSize(400, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="ע��") {
			try {
				if (ManagerRegisterUtils.ManagerRegister(tid.getText(), tpwd.getText())) {
					System.out.println("ע��ɹ�");
					new RegisterSuccessUi();
				}
			} catch (Exception e1) {
				new RegisterFailUi();
				System.out.println("ע��ʧ��");
			}
		}
	}


}
