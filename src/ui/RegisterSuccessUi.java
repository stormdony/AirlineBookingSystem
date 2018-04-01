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
 * 注册成功界面
 *
 */
public class RegisterSuccessUi {
	public RegisterSuccessUi() {
		JFrame frame = new JFrame("注册成功");
		Container container = frame.getContentPane();
		JLabel error = new JLabel("注册成功!!!");
		error.setForeground(Color.RED);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
		container.add(error);
		frame.setSize(300, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
