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
 * ×¢²áÊ§°Ü½çÃæ
 *
 */
public class RegisterFailUi {
	public RegisterFailUi() {
		JFrame frame = new JFrame("×¢²áÊ§°Ü");
		Container container = frame.getContentPane();
		JLabel error = new JLabel("×¢²á´íÎó!!!");
		error.setForeground(Color.RED);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
		container.add(error);
		frame.setSize(300, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
