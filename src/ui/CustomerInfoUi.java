package ui;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.CustomerInfoUtils;
import utils.CustomerUpdateInfoUtils;
/**
 * 
 * @author stormdony
 * at 2018/03/05
 * 修改个人信息
 *
 */
public class CustomerInfoUi implements ActionListener{
	private String cid;
	private String cpassword;
	private String cname;
	private String cphone;
	private String cpaperwork;
	private JTextField jpwd;
	private JTextField jname;
	private JTextField jphone;
	private JTextField jpaper;

	public CustomerInfoUi(ResultSet rs) {
		try {
			while (rs.next()) {
				cid = rs.getString("Cid");
				cpassword = rs.getString("Cpassword");
				cname = rs.getString("Cname");
				cphone = rs.getString("phone");
				cpaperwork = rs.getString("Cpaperwork");
			}
		} catch (Exception e) {
			System.out.println("系统异常,稍后重试");
		}
		
		 JFrame frame = new JFrame("个人信息");
			Container container = frame.getContentPane();
			JPanel pan = new JPanel();
			pan.setLayout(new GridLayout(8, 4, 10, 10));
			JLabel id = new JLabel("账号");
			JLabel tid = new JLabel(cid);
			JLabel pwd = new JLabel("密码");
			JLabel name = new JLabel("姓名");
			JLabel phone = new JLabel("联系电话");
			JLabel paper = new JLabel("证件号");
			                                                    
			jpwd = new JTextField(cpassword);   
			jname = new JTextField(cname);  
			jphone = new JTextField(cphone);    
			jpaper = new JTextField(cpaperwork);   
			Button back = new Button("返回");
			back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					frame.dispose();
				}
			});
			Button update = new Button("更改");
			update.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
//					传数据进去,在把跟新后的数据进行对比,如果有一个不一样就进行更新操作
					if (CustomerUpdateInfoUtils.updateInfo(cpassword,cname,cphone,cpaperwork,cid,jpwd.getText(),jname.getText(),jphone.getText(),jpaper.getText())) {
						new UpdateSuccessUi();
						frame.dispose();
					}else {
						new UpdateFailUi();
					}
					
				}
			});
			
			pan.add(new JLabel());
			pan.add(new JLabel());
			pan.add(new JLabel());
			pan.add(new JLabel());
			
			pan.add(new JLabel());
			pan.add(id);
			pan.add(tid);
			pan.add(new JLabel());
			
			pan.add(new JLabel());
			pan.add(pwd);
			pan.add(jpwd);
			pan.add(new JLabel());
			
			pan.add(new JLabel());
			pan.add(name);
			pan.add(jname);
			pan.add(new JLabel());
			
			pan.add(new JLabel());
			pan.add(phone);
			pan.add(jphone);
			pan.add(new JLabel());
			
			pan.add(new JLabel());
			pan.add(paper);
			pan.add(jpaper);
			pan.add(new JLabel());
			
			
			pan.add(new JLabel());
			pan.add(back);
			pan.add(update);
			pan.add(new JLabel());
			
			pan.add(new JLabel());
			pan.add(new JLabel());
			pan.add(new JLabel());
			pan.add(new JLabel());
			
			container.add(pan);
			frame.setSize(450, 250);
			frame.setLocation(300, 250);
			frame.setResizable(false);
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
	}
//	public static void main(String[] args) {
//		try {
//			new CustomerInfoUi(CustomerInfoUtils.getInfo("1001"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
