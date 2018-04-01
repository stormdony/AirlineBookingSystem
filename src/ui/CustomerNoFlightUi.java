package ui;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author stormdony 
 * at 2018/03/07 
 * 没有订单专用页面
 */
public class CustomerNoFlightUi {

	public CustomerNoFlightUi() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame("我的订单");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3, 3, 10, 10));

		for (int i = 0; i < 4; i++) {
			pan.add(new JLabel());
		}
		JLabel jLabel = new JLabel("你还没有下过单哦~赶快去下单吧!");
		pan.add(jLabel);
		for (int i = 0; i < 4; i++) {
			pan.add(new JLabel());
		}

		container.add(pan);
		frame.setSize(650, 200);
		frame.setLocation(300, 250);
		frame.setResizable(true);
		frame.dispose();
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
