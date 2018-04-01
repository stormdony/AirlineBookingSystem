package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author stormdony
 * at 2018/03/14
 * ≤È—Ø ß∞‹ΩÁ√Ê
 *
 */
public class FailUi {
	public FailUi(String len) {
		JFrame frame = new JFrame(" ß∞‹");
		Container container = frame.getContentPane();
		JLabel error = new JLabel(len);
		error.setForeground(Color.RED);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
		container.add(error);
		frame.setSize(300, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
