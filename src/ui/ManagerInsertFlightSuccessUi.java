package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ManagerInsertFlightSuccessUi {
	public ManagerInsertFlightSuccessUi() {
		JFrame frame = new JFrame("���³ɹ�");
		Container container = frame.getContentPane();
		JLabel error = new JLabel("���³ɹ�");
		error.setForeground(Color.BLACK);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
		container.add(error);
		frame.setSize(300, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
