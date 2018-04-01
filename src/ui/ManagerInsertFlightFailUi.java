package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ManagerInsertFlightFailUi {
	public ManagerInsertFlightFailUi() {
		JFrame frame = new JFrame("插入失败");
		Container container = frame.getContentPane();
		JLabel error = new JLabel("插入错误!!!请检查信息是否正确");
		error.setForeground(Color.RED);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
		container.add(error);
		frame.setSize(300, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
