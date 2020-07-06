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
import com.txl.Vo.Grouping;
import com.txl.serviceImpl.GroupingServiceImpl;

/**
 * 分组添加子窗体
 * @author DELL
 *
 */
public class GroupAddInterFrm extends JInternalFrame {
	private JTextField g_numberTxt;
	private JTextField groupingNameTxt;
	
//	private DatabaseConnection databaseConnection = new DatabaseConnection();
//	private GroupingDaoImpl groupingDao = new GroupingDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupAddInterFrm frame = new GroupAddInterFrm();
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
	public GroupAddInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u6DFB\u52A0\u5206\u7EC4");
		setBounds(100, 100, 362, 300);
		
		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		
		JLabel label_1 = new JLabel("\u540D\u79F0\uFF1A");
		
		g_numberTxt = new JTextField();
		g_numberTxt.setColumns(10);
		
		groupingNameTxt = new JTextField();
		groupingNameTxt.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupAddActionPerformed(e);
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
					.addGap(75)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addGap(18)
							.addComponent(groupingNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(g_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(g_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(groupingNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 添加分组事件处理
	 * @param e
	 */
	private void groupAddActionPerformed(ActionEvent evt) {
		String g_number=this.g_numberTxt.getText();
		String groupingName=this.groupingNameTxt.getText();
		if(StringUtil.isEmpty(g_number)) {
			JOptionPane.showMessageDialog(null, "分组编号不能为空！");
			return;
		}else if(StringUtil.isEmpty(groupingName)) {
			JOptionPane.showMessageDialog(null, "分组名不能为空！");
			return;
		}
		Grouping grouping = new Grouping(g_number,groupingName);
//		Connection conn=null;
		try {
			//连接数据库
//			conn = databaseConnection.getCon();
//			int n = groupingDao.add(conn, grouping);
//			
//			if(n==1) {
			if(new GroupingServiceImpl().add(grouping) > 0 ) {
				JOptionPane.showMessageDialog(null, "添加成功");
				//重置
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "已存在，请重新输入");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败");
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
		this.groupingNameTxt.setText("");
	}
}
