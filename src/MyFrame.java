import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	public static void main(String[] args) {
		new MyFrame();
	}
	private File f;
	private JButton btn1;
	private JFileChooser filechooser;
	private JTextField area1;
	private JTextField area2;
	private static JTextArea area3 = new JTextArea();;
	private String preStr;
	private String nextStr;
	private JLabel label;
	public MyFrame() {
		setBounds(300,300,1000,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,5,20,20));
		
		label = new JLabel("---->");
		area1 = new JTextField();
		area2 = new JTextField();
		area3.append("����״̬��");
		area3.setEditable(false);
		btn1 = new JButton("ѡ���ļ�����ʼ�滻");
		filechooser = new JFileChooser();
		filechooser.setMultiSelectionEnabled(false);
		filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i =filechooser.showOpenDialog(c);
				if (i == JFileChooser.APPROVE_OPTION) {
					f = filechooser.getSelectedFile();
					JOptionPane.showMessageDialog(MyFrame.this, "ѡ��ɹ���");//����С�Ի���
				}
				preStr = area1.getText();
				nextStr = area2.getText();
				Demo.Change(f, preStr, nextStr);
			}
		});
		
		c.add(area1);
		c.add(label);
		c.add(area2);
		c.add(btn1);
		c.add(area3);
		
		setVisible(true);
	}
	public static JTextArea getArea3() {
		return area3;
	}
}
