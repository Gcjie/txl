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
import javax.swing.JTextField;

import com.txl.Util.StringUtil;
import com.txl.serviceImpl.UserServiceImpl;

/**
 * 删除用户
 * @author DELL
 *
 */
public class UserDeleteInterFrm extends JInternalFrame {
	private JTextField userNameTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDeleteInterFrm frame = new UserDeleteInterFrm();
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
	public UserDeleteInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5220\u9664\u7528\u6237");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDeleteActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addComponent(label)
							.addGap(18)
							.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(153)
							.addComponent(button)))
					.addContainerGap(157, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(button)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void userDeleteActionPerformed(ActionEvent evt) {
		String name=this.userNameTxt.getText();
//		int flag;
//		String id;
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的用户");
			return;
		}
		int p=JOptionPane.showConfirmDialog(null, "确定要删除该用户吗？");
		if(p==0) {
			//Connection conn=null;
			try {
				//连接数据库
//				conn = databaseConnection.getCon();
//				int n = linkmanDao.delete(conn, id ,flag);
				
				//if(n==1) {
				if(new UserServiceImpl().delete(name) > 0) {
					JOptionPane.showMessageDialog(null, "删除成功");
					//重置
					resetValue();
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败");
			}
//			finally {
//				try {
//					databaseConnection.closeCon(conn);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
	}
	
	/**
	 * 重置信息
	 */
	private void resetValue() {
		this.userNameTxt.setText("");
	}
}
