package com.lqr.logcut.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import com.lqr.logcut.execlogs.RAndWHugeFileNIOCut;

public class LogAnalysGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel logLabel;
	private JTextField logTextField;
	private JButton logButton;
	private JLabel keyworldLabel;
	private JTextField keywordTextField;
	private JLabel beforeKeyWorldlabel;
	private JTextField beforeKeyWordTextField;
	private JLabel afterKeyWorldLabel;
	private JTextField afterKeyWordTextField;
	private JButton execButton;
	private JLabel selectOutputLabel;
	private JTextField selectOutputTextField;
	private JButton selectOutputButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//创建JFrame对象之前加进去
					LogAnalysGUI frame = new LogAnalysGUI();
					frame.setResizable(false);
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
	public LogAnalysGUI() {
		setFont(new Font("幼圆", Font.PLAIN, 12));
		setTitle("日志截取");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int windowsWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int windowsHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds(windowsWidth/4, windowsHeight/4, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		logLabel = new JLabel("选择日志:");
		logLabel.setFont(new Font("幼圆", Font.PLAIN, 12));
		logLabel.setBounds(10, 20, 86, 29);
		contentPane.add(logLabel);
		
		logTextField = new JTextField();
		logTextField.setToolTipText("");
		logTextField.setBounds(125, 22, 431, 25);
		logTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(logTextField);
		logTextField.setColumns(10);
		
		logButton = new JButton("日志浏览");
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("D:\\");
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jfc.showDialog(new JLabel(), "选择日志文件");
				
				File selectedFile = jfc.getSelectedFile();
				
				if(selectedFile!=null){
					System.out.println(selectedFile.getAbsolutePath());
					logTextField.setText(selectedFile.getAbsolutePath());
				}
				
			}
		});
		logButton.setFont(new Font("幼圆", Font.PLAIN, 12));
		logButton.setToolTipText("");
		logButton.setBounds(587, 23, 93, 23);
		contentPane.add(logButton);
		
		selectOutputLabel = new JLabel("选择输出路径:");
		selectOutputLabel.setFont(new Font("幼圆", Font.PLAIN, 12));
		selectOutputLabel.setToolTipText("");
		selectOutputLabel.setBounds(10, 70, 86, 25);
		contentPane.add(selectOutputLabel);
		
		selectOutputTextField = new JTextField();
		selectOutputTextField.setToolTipText("可以将日志路径复制到此");
		selectOutputTextField.setColumns(10);
		selectOutputTextField.setBounds(125, 72, 431, 25);
		selectOutputTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(selectOutputTextField);
		
		selectOutputButton = new JButton("输出路径浏览");
		selectOutputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("输出路径浏览");
				JFileChooser jfc = new JFileChooser("D:\\");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.showDialog(new JLabel(), "选择输出路径");
				File selectedFile = jfc.getSelectedFile();
				if(selectedFile!=null){
					System.out.println(selectedFile.getAbsolutePath());
					selectOutputTextField.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		selectOutputButton.setFont(new Font("幼圆", Font.PLAIN, 12));
		selectOutputButton.setToolTipText("");
		selectOutputButton.setBounds(587, 71, 129, 23);
		contentPane.add(selectOutputButton);
		
		keyworldLabel = new JLabel("要查寻的关键字*:");
		keyworldLabel.setFont(new Font("幼圆", Font.BOLD, 12));
		keyworldLabel.setToolTipText("");
		keyworldLabel.setForeground(Color.RED);
		keyworldLabel.setBounds(10, 110, 105, 25);
		contentPane.add(keyworldLabel);
		
		keywordTextField = new JTextField();
		keywordTextField.setBounds(125, 110, 431, 25);
		keywordTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(keywordTextField);
		keywordTextField.setColumns(10);
		
		beforeKeyWorldlabel = new JLabel("关键字前多少行:");
		beforeKeyWorldlabel.setFont(new Font("幼圆", Font.PLAIN, 12));
		beforeKeyWorldlabel.setToolTipText("");
		beforeKeyWorldlabel.setBounds(10, 162, 105, 25);
		contentPane.add(beforeKeyWorldlabel);
		
		beforeKeyWordTextField = new JTextField();
		beforeKeyWordTextField.setText("1000");
		beforeKeyWordTextField.setBounds(125, 164, 86, 21);
		beforeKeyWordTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(beforeKeyWordTextField);
		beforeKeyWordTextField.setColumns(10);
		
		afterKeyWorldLabel = new JLabel("关键字后多少行:");
		afterKeyWorldLabel.setFont(new Font("幼圆", Font.PLAIN, 12));
		afterKeyWorldLabel.setToolTipText("");
		afterKeyWorldLabel.setBounds(285, 162, 105, 25);
		contentPane.add(afterKeyWorldLabel);
		
		afterKeyWordTextField = new JTextField();
		afterKeyWordTextField.setText("1000");
		afterKeyWordTextField.setColumns(10);
		afterKeyWordTextField.setBounds(400, 164, 86, 21);
		afterKeyWordTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(afterKeyWordTextField);
		
		execButton = new JButton("执行截取关键字前后行数");
		execButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("执行截取关键字前后行数");
				execButton.setEnabled(false);
				
				SwingWorker<Integer, Integer> swingWorker = new SwingWorker<Integer, Integer>(){
					@Override
					protected Integer doInBackground() throws Exception {
//						Thread.sleep(5000);
//						execButton.setEnabled(true);
						String logFileAbsPath = logTextField.getText().trim();
						String outputFilePath = selectOutputTextField.getText().trim();
						String preLineNoStr = beforeKeyWordTextField.getText().trim();
						String sufLineNoStr = afterKeyWordTextField.getText().trim();
						int preLineNo = Integer.valueOf(preLineNoStr);
						int sufLineNo = Integer.valueOf(sufLineNoStr);
						String keyWorld = keywordTextField.getText().trim();
						String result = "";
						try {
							execButton.setEnabled(false);
							result= RAndWHugeFileNIOCut.cutTheKeyWorldLogs(logFileAbsPath, outputFilePath, preLineNo, sufLineNo+1, keyWorld);
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(contentPane, ex.getMessage());
						}
						
						if("success".equals(result)) {
							execButton.setEnabled(true);
						}
						return 0;
					}
					
				};
				swingWorker.execute();
			}
		});
		execButton.setFont(new Font("幼圆", Font.PLAIN, 12));
		execButton.setToolTipText("");
		execButton.setBounds(260, 219, 267, 62);
		contentPane.add(execButton);
	}
}
