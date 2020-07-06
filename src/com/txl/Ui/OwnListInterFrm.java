package com.txl.Ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.txl.Factory.Daofactory;
import com.txl.Vo.Grouping;
import com.txl.Vo.Own;
import com.txl.dbc.DatabaseConnection;
import java.awt.event.ActionListener;

/**
 * 根据联系人查找分组
 * @author DELL
 *
 */
public class OwnListInterFrm extends JInternalFrame {
	private JTextField s_linkNameTxt;
	private JTable table;
	
	private DatabaseConnection databaseConnection = new DatabaseConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnListInterFrm frame = new OwnListInterFrm();
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
	public OwnListInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u67E5\u627E\u7684\u8054\u7CFB\u4EBA\u540D\u5B57\uFF1A");
		
		s_linkNameTxt = new JTextField();
		s_linkNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ownSearchActionPerformed(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(label)
							.addGap(18)
							.addComponent(s_linkNameTxt, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(146)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(126)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_linkNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(button)
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6240\u5728\u5206\u7EC4"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
	
	
	private void ownSearchActionPerformed(ActionEvent evt) {
		String s_linkName=this.s_linkNameTxt.getText();
//		Grouping grouping = new Grouping();
//		grouping.setG_name(s_groupingName);
		this.fillTable(s_linkName);
	}
	
	/**
	 * 初始化表格
	 * @param l_name
	 */
	private void fillTable(String l_name) {
		DefaultTableModel dtm =(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);		//设置成0行
		//Connection conn=null;
		try {
			//conn=databaseConnection.getCon();
			ResultSet rs=Daofactory.getOwnDaoInstance(new DatabaseConnection().getCon()).list(l_name);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("g_name"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
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
}
