package com.txl.Ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

//import com.txl.DaoImpl.LinkmanDaoImpl;
import com.txl.Util.StringUtil;
import com.txl.Vo.Linkman;
import com.txl.dbc.DatabaseConnection;
import com.txl.serviceImpl.LinkmanServiceImpl;

/**
 * 联系人增加子窗体
 * @author DELL
 *
 */
public class LinkmanAddInterFrm extends JInternalFrame {
	private JTextField l_numberTxt;
	private JTextField linkmanNameTxt;
	private JTextField linkmanPhoneTxt;
	private JTextField linkmanQqTxt;
	private JTextField linkmanAddressTxt;
	private JComboBox linkmanSexBox;
	
//	private DatabaseConnection databaseConnection = new DatabaseConnection();
//	private LinkmanDaoImpl linkmanDao = new LinkmanDaoImpl();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkmanAddInterFrm frame = new LinkmanAddInterFrm();
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
	public LinkmanAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u8054\u7CFB\u4EBA\u6DFB\u52A0");
		setBounds(100, 100, 666, 429);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		
		JLabel label_3 = new JLabel("\u7535\u8BDD\uFF1A");
		
		JLabel lblQq = new JLabel("QQ\uFF1A");
		
		JLabel label_4 = new JLabel("\u5730\u5740\uFF1A");
		
		l_numberTxt = new JTextField();
		l_numberTxt.setColumns(10);
		
		linkmanNameTxt = new JTextField();
		linkmanNameTxt.setColumns(10);
		
		linkmanPhoneTxt = new JTextField();
		linkmanPhoneTxt.setColumns(10);
		
		linkmanQqTxt = new JTextField();
		linkmanQqTxt.setColumns(10);
		
		linkmanAddressTxt = new JTextField();
		linkmanAddressTxt.setColumns(10);
		
		linkmanSexBox = new JComboBox();
		linkmanSexBox.addItem("男");
		linkmanSexBox.addItem("女");
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linkmanAddActionPerformed(e);
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
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(linkmanSexBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(lblQq)
								.addComponent(label_4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button)
									.addGap(49)
									.addComponent(button_1))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(linkmanQqTxt, Alignment.LEADING)
									.addComponent(linkmanPhoneTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
								.addComponent(linkmanAddressTxt, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(linkmanNameTxt))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_1)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(l_numberTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(l_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(linkmanNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(linkmanSexBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(linkmanPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQq)
						.addComponent(linkmanQqTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addComponent(linkmanAddressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	/**
	  * 联系人添加事件处理
	 * @param evt
	 */
	private void linkmanAddActionPerformed(ActionEvent evt) {
		String l_number=this.l_numberTxt.getText();
		String linkmanName=this.linkmanNameTxt.getText();
		String linkmanPhone=this.linkmanPhoneTxt.getText();
		String linkmanQq=this.linkmanQqTxt.getText();
		String linkmanAddress=this.linkmanAddressTxt.getText();
		String linkmanSex=this.linkmanSexBox.getSelectedItem().toString();
		if(StringUtil.isEmpty(l_number)) {
			JOptionPane.showMessageDialog(null, "联系人编号不能为空！");
			return;
		}else if(StringUtil.isEmpty(linkmanName)) {
			JOptionPane.showMessageDialog(null, "联系人姓名不能为空！");
			return;
		}else if(StringUtil.isEmpty(linkmanPhone)) {
			JOptionPane.showMessageDialog(null, "联系人电话不能为空！");
			return;
		}
		Linkman linkman = new Linkman(l_number,linkmanName,linkmanSex,linkmanPhone,linkmanQq,linkmanAddress);
		//Connection conn=null;
		try {
			//连接数据库
			//conn = databaseConnection.getCon();
			//int n = linkmanDao.add(conn, linkman);
			
			//if(n==1) {
			if(new LinkmanServiceImpl().add(linkman) >0 ) {
				JOptionPane.showMessageDialog(null, "添加成功");
				//重置
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
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
		this.l_numberTxt.setText("");
		this.linkmanAddressTxt.setText("");
		this.linkmanNameTxt.setText("");
		this.linkmanPhoneTxt.setText("");
		this.linkmanQqTxt.setText("");
		if(this.linkmanSexBox.getItemCount()>0) {
			this.linkmanSexBox.setSelectedIndex(0);
		}
	}
}
