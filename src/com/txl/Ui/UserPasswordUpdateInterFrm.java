package com.txl.Ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.txl.Util.StringUtil;
import com.txl.Vo.User;
import com.txl.serviceImpl.UserServiceImpl;

/**
 * 修改密码
 * @author DELL
 *
 */
public class UserPasswordUpdateInterFrm extends JInternalFrame {
	private JTextField s_nameTxt;
	private JPasswordField newPasswordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPasswordUpdateInterFrm frame = new UserPasswordUpdateInterFrm();
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
	public UserPasswordUpdateInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u7528\u6237\u540D\uFF1A");
		
		s_nameTxt = new JTextField();
		s_nameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		
		newPasswordTxt = new JPasswordField();
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordUpdateActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValuePerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(button)
							.addComponent(label_1)))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(newPasswordTxt)
							.addComponent(s_nameTxt, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
						.addComponent(button_1))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(newPasswordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void PasswordUpdateActionPerformed(ActionEvent evt) {
		String s_name=this.s_nameTxt.getText();
		String newPassword=this.newPasswordTxt.getText();
		if(StringUtil.isEmpty(s_name)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的用户");
			return;
		}else if(StringUtil.isEmpty(newPassword)) {
			JOptionPane.showMessageDialog(null, "请输入新密码");
			return;
		}
		
		User user = new User(s_name,newPassword);
		
		//Connection conn=null;
		try {
			//连接数据库
//			conn = databaseConnection.getCon();
//			int n = linkmanDao.update(conn, linkman, id ,flag);
			
			//if(n==1) {
			if(new UserServiceImpl().update(user, s_name) > 0) {
				JOptionPane.showMessageDialog(null, "修改成功");
				//重置
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
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
		this.s_nameTxt.setText("");
		this.newPasswordTxt.setText("");
	}
}
