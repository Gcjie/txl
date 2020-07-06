package com.txl.Ui;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 登录日志
 * @author DELL
 *
 */
public class LoginInterFrm extends JInternalFrame {
	private JTable table;
	private JTextField s_nameTxt;
	private JTextField nameTxt;
	private JTextField timeTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterFrm frame = new LoginInterFrm();
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
	public LoginInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u767B\u5F55\u65E5\u5FD7");
		setBounds(100, 100, 541, 531);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		s_nameTxt = new JTextField();
		s_nameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = s_nameTxt.getText();
				if(name == null || "".equals(name.trim())) {
					JOptionPane.showMessageDialog(null, "请输入要查找的用户名");
					FillDiary();
					return;
				}
				QueryDiary();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FE1\u606F\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = s_nameTxt.getText();
				if(name == null || "".equals(name.trim())) {
					JOptionPane.showMessageDialog(null, "请输入要修改的用户名");
					return;
				}
				String time=timeTxt.getText();
				if(time == null || "".equals(time.trim())) {
					JOptionPane.showMessageDialog(null, "登录时间不能为空");
					return;
				}
				try {
					ModifyDiary();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton button_2 = new JButton("\u5220\u9664");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = s_nameTxt.getText();
				if(name == null || "".equals(name.trim())) {
					JOptionPane.showMessageDialog(null, "请输入要删除的用户名");
					return;
				}
				try {
					DelDiary();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(119, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(button_1)
							.addGap(50)
							.addComponent(button_2)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(s_nameTxt, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
									.addComponent(button)))
							.addGap(110))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(39)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		JLabel label_2 = new JLabel("\u767B\u5F55\u65F6\u95F4\uFF1A");
		
		nameTxt = new JTextField();
		nameTxt.setEditable(false);
		nameTxt.setColumns(10);
		
		timeTxt = new JTextField();
		timeTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(timeTxt, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addGap(30)
							.addComponent(nameTxt)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(timeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				int row=table.getSelectedRow();
				nameTxt.setText((String)table.getValueAt(row, 0));
				timeTxt.setText((String)table.getValueAt(row, 1));
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237\u540D", "\u767B\u5F55\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		FillDiary();

	}
	/**
	  * 删除日志
	 *@param username	删除的用户名
	 *@param time	删除的时间
	 *@param arr	存放所有日志的集合
	 *@exception Exception
	 */
	@SuppressWarnings("resource")
	private void DelDiary() throws Exception {
		String name = s_nameTxt.getText();
		String time = timeTxt.getText();
		ArrayList<String> arr = new ArrayList<String>();
		BufferedWriter bw = null;
		BufferedReader br = null;
		String s = null;
		br = new BufferedReader(new FileReader("D://1.txt"));
		while((s = br.readLine()) != null) {
				if(s.equals(name+" "+time)) {
					continue;
				}
				arr.add(s);
			}
		bw = new BufferedWriter(new FileWriter("D://1.txt"));
		for(String str : arr) {
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		JOptionPane.showMessageDialog(null, "删除成功！");
		FillDiary();
		resetValue();
	}

	/**
	  * 修改日志
	 *@param username	修改的用户名
	 *@param time	修改的时间
	 *@param arr	存放所有日志的集合
	 *@exception Exception
	 */
	@SuppressWarnings("resource")
	private void ModifyDiary() throws Exception {
		String name = s_nameTxt.getText();
		String time = timeTxt.getText();
		BufferedWriter bw = null;
		BufferedReader br = null;
		ArrayList<String> arr = new ArrayList<String>();
		br = new BufferedReader(new FileReader("D://1.txt"));
		String s = null;
		while((s = br.readLine()) != null) {
				String[] arrstr = s.split(" ");
				if((name.equals(arrstr[0]))) {
					arr.add(name.concat(" "+time));
					continue;
				}
				arr.add(s);
			}
			bw = new BufferedWriter(new FileWriter("D://1.txt"));
			for(String str : arr) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			JOptionPane.showMessageDialog(null, "修改成功");
			FillDiary();
			resetValue();
	}

	/**
	  * 查询日志
	 *@param username	待查询的用户名 
	 *@param dtm	创建一个表
	 *@param arr	存放所有日志的集合
	 *@exception Exception
	 */
	private void QueryDiary() {
		String name = s_nameTxt.getText();
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		ArrayList<String> arr = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("D://1.txt"));
			String s = null;
			try {
				while((s = br.readLine()) != null) {
					arr.add(s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		for(String str : arr) {
			Vector<String> v = new Vector<String>();
			String[] arrstr = str.split(" ");
			if(name.equals(arrstr[0])) {
				v.add(arrstr[0]);
				v.add(arrstr[1]+" "+arrstr[2]);
				dtm.addRow(v);
			}
		}
	}

	/**
	  * 填充日志表
	 *@param dtm	待填充的表
	 *@param arr	存放所有日志的集合
	 *@exception Exception
	 */
	private void FillDiary() {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		ArrayList<String> arr = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("D://1.txt"));
			String s = null;
			try {
				while((s = br.readLine()) != null) {
					arr.add(s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		for(String str : arr) {
			Vector<String> v = new Vector<String>();
			String[] arrstr = str.split(" ");
			v.add(arrstr[0]);
			v.add(arrstr[1]+" "+arrstr[2]);
			dtm.addRow(v);
		}
	}
	
	/**
	 * 重置信息
	 */
	private void resetValue() {
		this.s_nameTxt.setText("");
		this.nameTxt.setText("");
		this.timeTxt.setText("");
	}
}
