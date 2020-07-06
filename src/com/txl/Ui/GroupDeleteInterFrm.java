package com.txl.Ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

//import com.txl.DaoImpl.GroupingDaoImpl;
import com.txl.Factory.Daofactory;
import com.txl.Util.StringUtil;
import com.txl.Vo.Grouping;
import com.txl.Vo.Linkman;
import com.txl.dbc.DatabaseConnection;
import com.txl.serviceImpl.GroupingServiceImpl;
import com.txl.serviceImpl.LinkmanServiceImpl;

/**
 * 分组删除和修改子窗体
 * @author DELL
 *
 */
public class GroupDeleteInterFrm extends JInternalFrame {
	private JTable groupingTable;

	private DatabaseConnection databaseConnection = new DatabaseConnection();
//	private GroupingDaoImpl groupingDao =new GroupingDaoImpl();
	private JTextField s_groupNameTxt;
	private JTextField g_numberTxt;
	private JTextField g_nameTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupDeleteInterFrm frame = new GroupDeleteInterFrm();
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
	public GroupDeleteInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5206\u7EC4\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 450, 405);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u5206\u7EC4\u540D\uFF1A");
		
		s_groupNameTxt = new JTextField();
		s_groupNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupingSearchActionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5206\u7EC4\u4FE1\u606F\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupingUpdateActionPerformed(e);
			}
		});
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				groupingDeleteActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(button_1)
							.addGap(64)
							.addComponent(button_2)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(s_groupNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(20)
										.addComponent(button))
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
							.addContainerGap(93, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(button)
						.addComponent(s_groupNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button_1))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u5206\u7EC4\u540D\uFF1A");
		
		g_numberTxt = new JTextField();
		g_numberTxt.setEditable(false);
		g_numberTxt.setColumns(10);
		
		g_nameTxt = new JTextField();
		g_nameTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(g_nameTxt)
						.addComponent(g_numberTxt, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(g_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(g_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		groupingTable = new JTable();
		groupingTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				groupingTableMousePressed(met);
			}
		});
		groupingTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5206\u7EC4\u540D"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(groupingTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Grouping());
		
	}
	
	/**
	 * 分组修改事件处理
	 * @param evt
	 */
	private void groupingUpdateActionPerformed(ActionEvent evt) {
		String s_name=this.s_groupNameTxt.getText();
		if(StringUtil.isEmpty(s_name)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的分组");
			return;
		}
		String g_number=this.g_numberTxt.getText();
		String g_name=this.g_nameTxt.getText();
		
		if(StringUtil.isEmpty(g_name)) {
			JOptionPane.showMessageDialog(null, "分组姓名不能为空！");
			return;
		}
		Grouping grouping = new Grouping(g_number,g_name);
		
//		Connection conn=null;
		try {
			//连接数据库
//			conn = databaseConnection.getCon();
//			int n = groupingDao.update(conn, grouping,s_name);
//			
//			if(n==1) {
			if(new GroupingServiceImpl().update(grouping, s_name) >0 ) {
				JOptionPane.showMessageDialog(null, "修改成功");
				//重置
				resetValue();
				//刷新表单
				this.fillTable(new Grouping());
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
	 * 表格行点击事件处理
	 * @param met
	 */
	private void groupingTableMousePressed(MouseEvent met) {
		int row = this.groupingTable.getSelectedRow();
		this.g_numberTxt.setText((String)groupingTable.getValueAt(row, 0));
		this.g_nameTxt.setText((String)groupingTable.getValueAt(row, 1));
	}

	/**
	 * 分组查询事件处理
	 * @param e
	 */
	private void groupingSearchActionPerformed(ActionEvent evt) {
		String s_groupingName=this.s_groupNameTxt.getText();
		Grouping grouping = new Grouping();
		grouping.setG_name(s_groupingName);
		this.fillTable(grouping);
	}
	
	/**
	 * 删除分组事件处理
	 * @param evt
	 */
	private void groupingDeleteActionPerformed(ActionEvent evt) {
		String s_name=this.s_groupNameTxt.getText();
		if(StringUtil.isEmpty(s_name)) {
			JOptionPane.showMessageDialog(null, "请输入要删除的分组");
			return;
		}
		int p=JOptionPane.showConfirmDialog(null, "确定要删除该分组吗？");
		if(p==0) {
			//Connection conn=null;
			try {
				//连接数据库
//				conn = databaseConnection.getCon();
//				int n = linkmanDao.delete(conn, id ,flag);
				
				//if(n==1) {
				if(new GroupingServiceImpl().delete(s_name) > 0) {
					JOptionPane.showMessageDialog(null, "删除成功");
					//重置
					resetValue();
					//刷新表单
					this.fillTable(new Grouping());
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
	 * 初始化表格
	 * @param grouping
	 */
	private void fillTable(Grouping grouping) {
		DefaultTableModel dtm =(DefaultTableModel) groupingTable.getModel();
		dtm.setRowCount(0);		//设置成0行
		//Connection conn=null;
		try {
			//conn=databaseConnection.getCon();
			ResultSet rs=Daofactory.getGroupingDaoInstance(new DatabaseConnection().getCon()).list(grouping);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("g_number"));
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
	
	/**
	 * 重置信息
	 */
	private void resetValue() {
		this.s_groupNameTxt.setText("");
		this.g_numberTxt.setText("");
		this.g_nameTxt.setText("");
	}
}
