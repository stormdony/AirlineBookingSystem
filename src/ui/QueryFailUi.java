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
 * 查询失败界面
 *
 */
public class QueryFailUi {
	public QueryFailUi() {
		JFrame frame = new JFrame("查询失败");
		Container container = frame.getContentPane();
		JLabel error = new JLabel("查询信息错误!!!");
		error.setForeground(Color.RED);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
		container.add(error);
		frame.setSize(300, 200);
		frame.setLocation(300, 250);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
}
