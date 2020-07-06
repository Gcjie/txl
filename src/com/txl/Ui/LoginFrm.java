package com.txl.Ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.txl.Util.StringUtil;
import com.txl.Vo.User;
import com.txl.serviceImpl.UserServiceImpl;

/**
 * 登录主界面
 * @author DELL
 *
 */
public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	
//	private DatabaseConnection databaseConnection = new DatabaseConnection();
//	private UserDaoImpl userDemo=new UserDaoImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setResizable(false);
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u901A\u8BAF\u5F55\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 19));

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");

		JLabel lblNewLabel_2 = new JLabel("\u5BC6 \u7801\uFF1A");

		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);

		JButton button = new JButton("\u767B\u5F55");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
				
			}
		});

		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAddFrm userAddFrm=new UserAddFrm();
				userAddFrm.setVisible(true);
			}
		});

		JButton button_2 = new JButton("\u91CD\u7F6E");
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		passwordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(121)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(button))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordTxt)
						.addComponent(button_1)
						.addComponent(usernameTxt, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_2)
					.addGap(99))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(149)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(191, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
	}

	/**
	 * 添加日志
	 * @param e
	 */
	private void AddDiary() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		BufferedWriter bw = null;
		BufferedReader br = null;
		ArrayList<String> arr = new ArrayList<String>();
		br = new BufferedReader(new FileReader("D://1.txt"));
		String s = null;
		boolean flag = false;	//用来标识用户日志存在不存在
		while((s = br.readLine()) != null) {
				String[] arrstr = s.split(" ");
				if((usernameTxt.getText().equals(arrstr[0]))) {
					arr.add(usernameTxt.getText().concat(" "+time));
					flag = true;
					continue;
				}
				arr.add(s);
			}
		if(flag) {
			bw = new BufferedWriter(new FileWriter("D://1.txt"));
			for(String str : arr) {
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		}else {
			bw = new BufferedWriter(new FileWriter("D://1.txt",true));
			bw.write(usernameTxt.getText().concat(" "+time));
			bw.newLine();
			bw.flush();
			bw.close();
		}
	}

	/**
	 * 登录事件处理
	 * @param e
	 */
	protected void loginActionPerformed(ActionEvent evt) {
		String username = this.usernameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		User user = new User(username,password);
		try {
			User currentUser=new UserServiceImpl().login(user);
			if(currentUser!=null) {
				AddDiary();
				dispose();
				new MainFrm().setVisible(true);
//				JOptionPane.showMessageDialog(null, "登录成功！");
			}else {
				JOptionPane.showMessageDialog(null,"用户名或密码错误！");
				resetValueActionPerformed(evt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.usernameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
