package ui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OrderFailUi {
	public OrderFailUi() {
		JFrame frame = new JFrame("����ʧ��");
		Container container = frame.getContentPane();
		JLabel error = new JLabel("����ʧ��!!!�Ժ�����");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
		container.add(error);
		frame.setSize(300, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
