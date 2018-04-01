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

import utils.ManagerLoginUtils;

/**
 * 
 * @author stormdony
 * at 2018/03/04
 * ����Ա��¼����
 *
 */

public class ManagerLoginUi implements ActionListener {

	private JTextField tid;
	private JTextField tpwd;
	private JFrame frame;

	public ManagerLoginUi() {
		frame = new JFrame("����Ա��½");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5, 4,10,10));
		JLabel id = new JLabel("�˺�");
		JLabel pwd = new JLabel("����");

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

		JButton done = new JButton("��¼");
		JButton cancel = new JButton("�˳�");
		pan.add(new Label());
		pan.add(cancel);
		pan.add(done);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());

		done.addActionListener(this);
		cancel.addActionListener(this);
		container.add(pan);
		frame.setSize(400, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand()=="��¼") {
			try {
				if (ManagerLoginUtils.checkLogin(tid.getText(), tpwd.getText())) {
					frame.dispose();
					new ManagerMainUi(tid.getText());
				}
				else {
					System.out.println("fail");
					new LoginFailUi();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}else if (e.getActionCommand()=="�˳�") {
			System.out.println("�˳�");
			frame.dispose();
		}
	}
	

}
