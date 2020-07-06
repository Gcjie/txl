package com.txl.Ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Button;

/**
 * 主界面
 * @author DELL
 *
 */
public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 552);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u8054\u7CFB\u4EBA\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem_1 = new JMenuItem("\u6DFB\u52A0\u8054\u7CFB\u4EBA");
		
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkmanAddInterFrm linkmanAddFrm=new LinkmanAddInterFrm();
				linkmanAddFrm.setVisible(true);
				table.add(linkmanAddFrm);
			}
		});
		mnNewMenu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5220\u9664\u548C\u4FEE\u6539\u8054\u7CFB\u4EBA");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkmanDeleteInterFrm linkmanDeleteInterFrm=new LinkmanDeleteInterFrm();
				linkmanDeleteInterFrm.setVisible(true);
				table.add(linkmanDeleteInterFrm);
			}
		});
		mnNewMenu.add(menuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("\u5206\u7EC4\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u6DFB\u52A0\u5206\u7EC4");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroupAddInterFrm groupAddInterFrm=new GroupAddInterFrm();
				groupAddInterFrm.setVisible(true);
				table.add(groupAddInterFrm);
			}
		});
		mnNewMenu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5220\u9664\u548C\u4FEE\u6539\u5206\u7EC4");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroupDeleteInterFrm groupDeleteInterFrm=new GroupDeleteInterFrm();
				groupDeleteInterFrm.setVisible(true);
				table.add(groupDeleteInterFrm);
			}
		});
		mnNewMenu_1.add(menuItem_4);
		
		JMenu menu = new JMenu("\u8054\u7CFB\u4EBA\u5206\u7EC4\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u521B\u5EFA\u5173\u8054");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnAddInterFrm ownAddInterFrm=new OwnAddInterFrm();
				ownAddInterFrm.setVisible(true);
				table.add(ownAddInterFrm);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_5 = new JMenuItem("\u67E5\u8BE2\u8054\u7CFB\u4EBA\u6240\u5728\u5206\u7EC4");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OwnListInterFrm ownListInterFrm=new OwnListInterFrm();
				ownListInterFrm.setVisible(true);
				table.add(ownListInterFrm);
			}
		});
		menu.add(menuItem_5);
		
		JMenu menu_1 = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_6 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserPasswordUpdateInterFrm userPasswordUpdateInterFrm=new UserPasswordUpdateInterFrm();
				userPasswordUpdateInterFrm.setVisible(true);
				table.add(userPasswordUpdateInterFrm);
			}
		});
		menu_1.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u5220\u9664\u7528\u6237");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDeleteInterFrm userDeleteInterFrm=new UserDeleteInterFrm();
				userDeleteInterFrm.setVisible(true);
				table.add(userDeleteInterFrm);
			}
		});
		menu_1.add(menuItem_7);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(Color.CYAN);
		contentPane.add(table, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 229, 27);
		table.add(toolBar);
		
		JButton button = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				if(result == 0) {
					dispose();
				}
			}
		});
		toolBar.add(button);
		
		Button button_1 = new Button("\u767B\u5F55\u65E5\u5FD7");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginInterFrm loginInterFrm=new LoginInterFrm();
				loginInterFrm.setVisible(true);
				table.add(loginInterFrm);
			}
		});
		toolBar.add(button_1);
		
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
