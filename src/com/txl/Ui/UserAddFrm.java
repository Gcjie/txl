package com.txl.Ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.txl.Util.StringUtil;
import com.txl.Vo.User;
import com.txl.serviceImpl.UserServiceImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;

/**
 * 注册用户
 * @author DELL
 *
 */
public class UserAddFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userIdTxt;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAddFrm frame = new UserAddFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserAddFrm() {
		setTitle("\u6CE8\u518C\u7528\u6237");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		
		userIdTxt = new JTextField();
		userIdTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userAddPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValuePerformed(e);
			}
		});
		
		passwordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button_1)
						.addComponent(userIdTxt, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addComponent(userNameTxt)
						.addComponent(passwordTxt))
					.addContainerGap(161, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(userIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}
	
	private void userAddPerformed(ActionEvent evt) {
		String userId=this.userIdTxt.getText();
		String username=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());;
		if(StringUtil.isEmpty(userId)) {
			JOptionPane.showMessageDialog(null, "用户编号不能为空！");
			return;
		}else if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "分组名不能为空！");
			return;
		}else if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "分组名不能为空！");
			return;
		}
		User user = new User(userId,username,password);
//		Connection conn=null;
		try {
			//连接数据库
//			conn = databaseConnection.getCon();
//			int n = userDao.add(conn, user);
//			
//			if(n==1) {
			if(new UserServiceImpl().add(user) > 0 ) {
				JOptionPane.showMessageDialog(null, "注册成功");
				//重置
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "注册失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "注册失败");
		}
//		finally {
//			try {
//				databaseConnection.closeCon(conn);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
	
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValuePerformed(ActionEvent e) {
		this.resetValue();
	}

	/**
	 * 重置信息
	 */
	private void resetValue() {
		this.userIdTxt.setText("");
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
