package ui;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.Query;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.CustomerInfoUtils;
import utils.CustomerMyorderUtils;
import utils.JdbcUtils;
import wbui.CustomerFlightInfoUi;

/**
 * 
 * @author stormdony
 * at 2018/03/05
 * �û���¼�ɹ���������
 *
 */
public class CustomerMainUi implements ActionListener{
	
	private String id;//�ͻ�id
	private JTextField begin;
	private JTextField end;
	private JTextField start;
	private JTextField destination;
	JMenuBar bar;
	JMenu menu;
	JMenuItem item ;
	JMenuItem Myitem;
	public CustomerMainUi(String tid) {
		 JFrame frame = new JFrame("�ͻ�����");
		Container container = frame.getContentPane();
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(6, 6, 10, 10));
		id = tid;
		 bar = new JMenuBar();
		 menu = new JMenu(id);
		 item = new JMenuItem("������Ϣ");
		 Myitem = new JMenuItem("�ҵĶ���");
		JMenuItem logout = new JMenuItem("�˳�");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand()=="������Ϣ") {
//					��id����,��ѯ�ͻ���Ϣ
					System.out.println("������Ϣ");
					try {
						new CustomerInfoUi(CustomerInfoUtils.getInfo(id));
					} catch (Exception e1) {
						e1.printStackTrace();
						System.out.println("ϵͳ��æ,�Ժ�����!");
					}
				}
			}
		});
		Myitem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�ҵĶ���");
				//��id��ȥ,��ticket�в���Ftid,����resultset ���ݲ鵽��������ʾ���µĽ���
				try {
					new CustomerFlightInfoUi(CustomerMyorderUtils.getCusFlight(id));
				} catch (SQLException e1) {
//					e1.printStackTrace();
					new FailUi("ϵͳ��æ,�Ժ�����!");
					System.out.println("ϵͳ��æ,�Ժ�����!");
				}
			}
		});
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
//				new MainUi();
				
			}
		});
		menu.add(item);
		menu.add(Myitem);
		menu.add(logout);
		bar.add(menu);
		Button query = new Button("��ѯ");
		query.addActionListener(this);
		begin = new JTextField(20);
		begin.setEditable(false);
		begin.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				begin.setEditable(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		end = new JTextField(20);
		
		start = new JTextField(20);
		start.setEditable(false);
		start.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				start.setEditable(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		destination = new JTextField(20);
		destination.setEditable(false);
		destination.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				destination.setEditable(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JLabel Jbegin = new JLabel("���ʱ��");
		JLabel Jend = new JLabel("������");
		JLabel Jstart = new JLabel("���");
		JLabel Jdestination = new JLabel("�յ�");
		
		pan.add(bar);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		
		pan.add(new Label());
		pan.add(Jstart);
		pan.add(start);
		pan.add(Jdestination);
		pan.add(destination);
		pan.add(new Label());
		
		pan.add(new Label());
		pan.add(Jbegin);
		pan.add(begin);
		pan.add(Jend);
		pan.add(end);
		pan.add(new Label());
		
		pan.add(new Label());
		pan.add(new Label());
		pan.add(query);
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		
		
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		pan.add(new Label());
		
		
		container.add(pan);
		frame.setSize(450, 250);
		frame.setLocation(300, 250);
		frame.setResizable(false);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="��ѯ") {
			System.out.println("��ѯ");
			try {
				new CustomerMainQueryUi(id, begin.getText().trim(), start.getText().trim(), destination.getText().trim(), end.getText().trim());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
