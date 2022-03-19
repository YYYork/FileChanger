package io.github.yyyork;
import java.io.File;
import java.util.List;

public class Demo {
	public static void Change(List<File> fileList,String pre,String next,String codeStyle) {
		List<File> files = fileList;
		MyFrame.getArea3().append(MyTool.getTimeMessage());
		MyFrame.getArea3().append("\n----开始修改----\n");
		for (File tmp:files) {
			MyFrame.getArea3().append(tmp.getName()+" 修改完成\n");
				Thread t = new Thread(new MyFileChanger(tmp,pre,next,codeStyle));
				t.start();
		}
		MyFrame.getArea3().append("----修改完成----\n");
		MyFrame.getArea3().setCaretPosition(MyFrame.getArea3().getText().length());  
	}
}
