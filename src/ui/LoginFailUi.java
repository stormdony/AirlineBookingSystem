package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author stormdony
 * at 2018/03/04
 * ��¼ʧ�ܽ���
 *
 */
public class LoginFailUi {
	public LoginFailUi() {
		JFrame frame = new JFrame("��½ʧ��");
		Container container = frame.getContentPane();
		JLabel error = new JLabel("��¼�������������!!!");
		error.setForeground(Color.RED);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
		container.add(error);
		frame.setSize(300, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
