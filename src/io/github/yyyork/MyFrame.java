package io.github.yyyork;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;

public class MyFrame extends JFrame{
	/**
	 * ���ߴ�Ѽ�� QQ 2264117533
	 * �汾v1.1.1
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comBox;
	private File f;
	private JButton btn1;
	private JButton btn2;
	private JFileChooser filechooser;
	private JTextField area1;
	private JTextField area2;
	private static JTextArea area3 = new JTextArea();;
	private String preStr;
	private String nextStr;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JPanel panel_all;
	private JPanel panel_up;
	private JPanel panel_down;
	private JScrollPane panle_sco_right;
	private List<File> fileList;
	public static JFrame frame;
	public static void main(String[] args) {
		frame = new MyFrame();
	}
	public MyFrame() {
		setBounds(300,300,500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,2));
		
		label1 = new JLabel("ԭ�ı���");
		label2 = new JLabel("ת��Ϊ��");
		label3 = new JLabel("���룺");
		area1 = new JTextField();
		area2 = new JTextField();
		area3.append("����״̬��");
		area3.setEditable(false);
		area3.setBackground(Color.LIGHT_GRAY);
		btn1 = new JButton("ѡ���ļ���");
		btn2 = new JButton("��ʼ�滻");
		filechooser = new JFileChooser();
		filechooser.setMultiSelectionEnabled(false);
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		panel_up = new JPanel();
		panel_up.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel_up.setLayout(new GridLayout(3,2));
		panel_down = new JPanel();
		panel_down.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel_down.setLayout(new GridLayout(2,1));
		panel_all = new JPanel();
		panel_all.setLayout(new GridLayout(2,1));
		panle_sco_right = new JScrollPane(area3);
		panle_sco_right.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		comBox = new JComboBox<String>();
		comBox.addItem("ASCII");
		comBox.addItem("ISO-8859-1");
		comBox.addItem("GB2312");
		comBox.addItem("GB18030");
		comBox.addItem("UTF-8");
		comBox.addItem("UTF-16");
		setTitle("�ı������޸�������������Ѽ��");
		
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyFileReader.list = new ArrayList<File>();
				int i =filechooser.showOpenDialog(c);
				if (i == JFileChooser.APPROVE_OPTION) {
					f = filechooser.getSelectedFile();
					frame.setTitle("��ѡ���ļ���: "+f.getName());
					try {
						fileList = MyFileReader.readfile(f);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(MyFrame.this, "ѡ��ɹ���");//����С�Ի���
				}
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(f == null) {
					JOptionPane.showMessageDialog(MyFrame.this, "����δѡ���ļ���");//����С�Ի���
					MyFileReader.list = new ArrayList<File>();
					int i =filechooser.showOpenDialog(c);
					if (i == JFileChooser.APPROVE_OPTION) {
						f = filechooser.getSelectedFile();
						frame.setTitle("��ѡ���ļ���: "+f.getName());
						try {
							fileList = MyFileReader.readfile(f);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(MyFrame.this, "ѡ��ɹ���");//����С�Ի���
					}
					return;
				}
				preStr = area1.getText();
				nextStr = area2.getText();
				Demo.Change(fileList, preStr, nextStr,comBox.getSelectedItem().toString());
			}});
		
		panel_up.add(label1);
		panel_up.add(area1);
		panel_up.add(label2);
		panel_up.add(area2);
		panel_up.add(label3);
		panel_up.add(comBox);
		panel_down.add(btn1);
		panel_down.add(btn2);
		panel_all.add(panel_up);
		panel_all.add(panel_down);
		c.add(panel_all);
		c.add(panle_sco_right);
		
		
		setVisible(true);
	}
	public static JTextArea getArea3() {
		return area3;
	}
}
