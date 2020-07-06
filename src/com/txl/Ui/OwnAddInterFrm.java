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
import javax.swing.LayoutStyle.ComponentPlacement;

import com.txl.Util.StringUtil;
import com.txl.Vo.Own;
import com.txl.serviceImpl.OwnServiceImpl;

/**
 * 创建关联
 * @author DELL
 *
 */
public class OwnAddInterFrm extends JInternalFrame {
	private JTextField l_numberTxt;
	private JTextField g_numberTxt;

//	private DatabaseConnection databaseConnection = new DatabaseConnection();
//	private OwnDaoImpl ownDao = new OwnDaoImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnAddInterFrm frame = new OwnAddInterFrm();
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
	public OwnAddInterFrm() {
		setTitle("\u521B\u5EFA\u5173\u8054");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 391, 300);
		
		JLabel label = new JLabel("\u8054\u7CFB\u4EBA\u7F16\u53F7\uFF1A");
		
		JLabel label_1 = new JLabel("\u5206\u7EC4\u7F16\u53F7\uFF1A");
		
		l_numberTxt = new JTextField();
		l_numberTxt.setColumns(10);
		
		g_numberTxt = new JTextField();
		g_numberTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ownAddActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(91)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(g_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(l_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(l_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(g_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(44))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 添加事件处理
	 * @param e
	 */
	private void ownAddActionPerformed(ActionEvent evt) {
		String l_number=this.l_numberTxt.getText();
		String g_number=this.g_numberTxt.getText();
		if(StringUtil.isEmpty(l_number)) {
			JOptionPane.showMessageDialog(null, "联系人编号不能为空！");
			return;
		}else if(StringUtil.isEmpty(g_number)) {
			JOptionPane.showMessageDialog(null, "分组编号不能为空！");
			return;
		}
		Own own=new Own(l_number,g_number);
//		Connection conn=null;
		try {
//			//连接数据库
//			conn = databaseConnection.getCon();
//			int n = ownDao.add(conn, own);
//			
//			if(n==1) {
			if(new OwnServiceImpl().add(own) > 0) {
				JOptionPane.showMessageDialog(null, "添加成功");
				//重置
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "不存在此联系人或分组");
				resetValue();
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "不存在此联系人或分组");
			resetValue();
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
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}

	/**
	 * 重置信息
	 */
	private void resetValue() {
		this.g_numberTxt.setText("");
		this.l_numberTxt.setText("");
	}
}
