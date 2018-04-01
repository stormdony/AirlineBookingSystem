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
 * 失败界面
 *
 */
public class SuccessUi {
	public SuccessUi(String len) {
		JFrame frame = new JFrame("成功");
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
