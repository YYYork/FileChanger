import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Demo {
	public static void Change(File f,String pre,String next) {
		List<File> files;
		try {
			files = MyFileReader.readfile(f);
			MyFrame.getArea3().append("��ʼ�޸�\n");
			for (File tmp:files) {
				MyFrame.getArea3().append(tmp.getAbsolutePath()+"�޸����\n");
					Thread t = new Thread(new MyFileChanger(tmp,pre,next));
					t.start();
			}
			MyFrame.getArea3().append("�޸����\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
