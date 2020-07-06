package com.txl.Ui;

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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

//import com.txl.DaoImpl.LinkmanDaoImpl;
import com.txl.Factory.Daofactory;
import com.txl.Util.StringUtil;
import com.txl.Vo.Linkman;
import com.txl.dbc.DatabaseConnection;
import com.txl.serviceImpl.LinkmanServiceImpl;

/**
 * 联系人删除和修改子窗体
 * @author DELL
 *
 */
public class LinkmanDeleteInterFrm extends JInternalFrame {
	private JTable linkmanTable;
	
	private DatabaseConnection databaseConnection = new DatabaseConnection();
//	private LinkmanDaoImpl linkmanDao = new LinkmanDaoImpl();
	
	private JTextField s_linkmanNameTxt;
	private JTextField s_linkmanPhoneTxt;
	private JTextField l_numberTxt;
	private JTextField nameTxt;
	private JTextField phoneTxt;
	private JTextField qqTxt;
	private JTextField addressTxt;
	private JComboBox sexBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkmanDeleteInterFrm frame = new LinkmanDeleteInterFrm();
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
	public LinkmanDeleteInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5220\u9664\u548C\u4FEE\u6539\u8054\u7CFB\u4EBA");
		setBounds(100, 100, 867, 564);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u8054\u7CFB\u4EBA\u59D3\u540D\uFF1A");
		
		s_linkmanNameTxt = new JTextField();
		s_linkmanNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linkmanSearchActionPerformed(e);
			}
		});
		
		JLabel label_1 = new JLabel("\u8054\u7CFB\u4EBA\u7535\u8BDD\uFF1A");
		
		s_linkmanPhoneTxt = new JTextField();
		s_linkmanPhoneTxt.setColumns(10);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				linkmanUpdateActionPerformed(evt);
			}
		});
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				linkmanDeleteActionPerformed(evt);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8054\u7CFB\u4EBA\u4FE1\u606F\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(172)
					.addComponent(button_1)
					.addGap(50)
					.addComponent(button_2)
					.addContainerGap(503, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(80, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_linkmanNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(label_1)
							.addGap(18)
							.addComponent(s_linkmanPhoneTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button)
							.addGap(179))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE))
							.addGap(73))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_linkmanNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(label_1)
						.addComponent(s_linkmanPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(21))
		);
		
		JLabel label_2 = new JLabel("\u7F16\u53F7\uFF1A");
		
		l_numberTxt = new JTextField();
		l_numberTxt.setEditable(false);
		l_numberTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u59D3\u540D\uFF1A");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u6027\u522B\uFF1A");
		
		JLabel label_5 = new JLabel("\u7535\u8BDD\uFF1A");
		
		phoneTxt = new JTextField();
		phoneTxt.setColumns(10);
		
		JLabel lblQq = new JLabel("QQ\uFF1A");
		
		qqTxt = new JTextField();
		qqTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5730\u5740\uFF1A");
		
		addressTxt = new JTextField();
		addressTxt.setColumns(10);
		
		sexBox = new JComboBox();
		sexBox.addItem("男");
		sexBox.addItem("女");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_6)
							.addGap(18)
							.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addGap(18)
									.addComponent(l_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_5)
									.addGap(18)
									.addComponent(phoneTxt)))
							.addGap(48)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(lblQq))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(qqTxt)
								.addComponent(nameTxt, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
							.addGap(56)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sexBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(l_numberTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(sexBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(phoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQq)
						.addComponent(qqTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(addressTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		linkmanTable = new JTable();
		linkmanTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				linkmanTableMousePressed(met);
			}
		});
		linkmanTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u7535\u8BDD", "QQ", "\u5730\u5740"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		linkmanTable.getColumnModel().getColumn(3).setPreferredWidth(107);
		linkmanTable.getColumnModel().getColumn(4).setPreferredWidth(117);
		linkmanTable.getColumnModel().getColumn(5).setPreferredWidth(145);
		scrollPane.setViewportView(linkmanTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Linkman());
	}
	
	/**
	 * 联系人修改事件处理
	 * @param evt
	 */
	private void linkmanUpdateActionPerformed(ActionEvent evt) {
		String s_name=this.s_linkmanNameTxt.getText();
		String s_phone=this.s_linkmanPhoneTxt.getText();
		int flag;
		String id;
		if(StringUtil.isEmpty(s_name)&&StringUtil.isEmpty(s_phone)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的联系人或电话");
			return;
		}
		if(StringUtil.isNotEmpty(s_name)) {
			flag=0;
			id=s_name;
		}else {
			flag=1;
			id=s_phone;
		}
		
		String l_number=this.l_numberTxt.getText();
		String linkmanName=this.nameTxt.getText();
		String linkmanSex=this.sexBox.getSelectedItem().toString();
		String linkmanPhone=this.phoneTxt.getText();
		String linkmanQq=this.qqTxt.getText();
		String linkmanAddress=this.addressTxt.getText();
		
		if(StringUtil.isEmpty(linkmanName)) {
			JOptionPane.showMessageDialog(null, "联系人姓名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(linkmanPhone)) {
			JOptionPane.showMessageDialog(null, "联系人电话不能为空！");
			return;
		}
		Linkman linkman = new Linkman(l_number,linkmanName,linkmanSex,linkmanPhone,linkmanQq,linkmanAddress);
		
		//Connection conn=null;
		try {
			//连接数据库
//			conn = databaseConnection.getCon();
//			int n = linkmanDao.update(conn, linkman, id ,flag);
			
			//if(n==1) {
			if(new LinkmanServiceImpl().update(linkman, id, flag) > 0) {
				JOptionPane.showMessageDialog(null, "修改成功");
				//重置
				resetValue();
				//刷新表单
				this.fillTable(new Linkman());
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
	private void linkmanTableMousePressed(MouseEvent met) {
		int row = this.linkmanTable.getSelectedRow();
		this.l_numberTxt.setText((String)linkmanTable.getValueAt(row, 0));
		this.nameTxt.setText((String)linkmanTable.getValueAt(row, 1));
		String sex=(String)this.linkmanTable.getValueAt(row, 2);
		int n=this.sexBox.getItemCount();
		for(int i=0;i<n;i++) {
			String item=(String)this.sexBox.getItemAt(i);
			if(item.equals(sex)) {
				this.sexBox.setSelectedIndex(i);
			}
		}
		this.phoneTxt.setText((String)linkmanTable.getValueAt(row, 3));
		this.qqTxt.setText((String)linkmanTable.getValueAt(row, 4));
		this.addressTxt.setText((String)linkmanTable.getValueAt(row, 5));
	}

	/**
	 * 联系人查询事件处理
	 * @param evt
	 */
	private void linkmanSearchActionPerformed(ActionEvent evt) {
		String s_linkmanName=this.s_linkmanNameTxt.getText();
		if(StringUtil.isNotEmpty(s_linkmanName)) {
			Linkman linkman = new Linkman();
			linkman.setName(s_linkmanName);
			this.fillTable(linkman);
		}else {
			String s_linkmanPhone=this.s_linkmanPhoneTxt.getText();
			Linkman linkman = new Linkman();
			linkman.setPhone(s_linkmanPhone);
			this.fillTable(linkman);
		}
	}
	
	/**
	 * 删除联系人事件处理
	 * @param evt
	 */
	private void linkmanDeleteActionPerformed(ActionEvent evt) {
		String s_name=this.s_linkmanNameTxt.getText();
		String s_phone=this.s_linkmanPhoneTxt.getText();
		int flag;
		String id;
		if(StringUtil.isEmpty(s_name)&&StringUtil.isEmpty(s_phone)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的联系人或电话");
			return;
		}
		if(StringUtil.isNotEmpty(s_name)) {
			flag=0;
			id=s_name;
		}else {
			flag=1;
			id=s_phone;
		}
		int p=JOptionPane.showConfirmDialog(null, "确定要删除该联系人吗？");
		if(p==0) {
			//Connection conn=null;
			try {
				//连接数据库
//				conn = databaseConnection.getCon();
//				int n = linkmanDao.delete(conn, id ,flag);
				
				//if(n==1) {
				if(new LinkmanServiceImpl().delete(id, flag) > 0) {
					JOptionPane.showMessageDialog(null, "删除成功");
					//重置
					resetValue();
					//刷新表单
					this.fillTable(new Linkman());
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
		this.s_linkmanNameTxt.setText("");
		this.s_linkmanPhoneTxt.setText("");
		this.l_numberTxt.setText("");
		this.nameTxt.setText("");
		this.phoneTxt.setText("");
		this.qqTxt.setText("");
		this.addressTxt.setText("");
		if(this.sexBox.getItemCount()>0) {
			this.sexBox.setSelectedIndex(0);
		}
	}

	/**
	 * 初始化表格
	 * @param linkman
	 */
	private void fillTable(Linkman linkman) {
		DefaultTableModel dtm =(DefaultTableModel) linkmanTable.getModel();
		dtm.setRowCount(0);		//设置成0行
		//Connection conn=null;
		try {
			//conn=databaseConnection.getCon();
			ResultSet rs=Daofactory.getLinkmanDaoInstance(new DatabaseConnection().getCon()).list(linkman);
//			System.out.println("查询到此一游");
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("l_number"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("phone"));
				v.add(rs.getString("qq"));
				v.add(rs.getString("address"));
//				System.out.println("查询到此一游");
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				new DatabaseConnection().closeCon();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
