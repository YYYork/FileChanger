package io.github.yyyork;
import java.io.File;
import java.util.List;

public class Demo {
	public static void Change(List<File> fileList,String pre,String next,String codeStyle) {
		List<File> files = fileList;
		MyFrame.getArea3().append(MyTool.getTimeMessage());
		MyFrame.getArea3().append("\n----��ʼ�޸�----\n");
		for (File tmp:files) {
			MyFrame.getArea3().append(tmp.getName()+" �޸����\n");
				Thread t = new Thread(new MyFileChanger(tmp,pre,next,codeStyle));
				t.start();
		}
		MyFrame.getArea3().append("----�޸����----\n");
		MyFrame.getArea3().setCaretPosition(MyFrame.getArea3().getText().length());  
	}
}
