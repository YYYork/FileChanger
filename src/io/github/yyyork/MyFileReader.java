package io.github.yyyork;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class MyFileReader {
	static List<File> list =new ArrayList<File>();
	public static List<File> readfile(File file1) throws FileNotFoundException, IOException {
		try {
                File file = file1;
                if (!file.isDirectory()) {
                	list.add(file);
                } else if (file.isDirectory()) {
                        File filelist[] = file.listFiles();
                        for (int i = 0; i < filelist.length; i++) {
                                if (!filelist[i].isDirectory()) {
                                	list.add(filelist[i]);
                                } else if (filelist[i].isDirectory()) {
                                        readfile(filelist[i]);
                                }
                        }

                }

        } catch (FileNotFoundException e) {
                System.out.println("readfile()   Exception:" + e.getMessage());
        }
		MyFrame.getArea3().append(MyTool.getTimeMessage());
		MyFrame.getArea3().append("\n----��ʼ����----\n");
		for(File f:list) {
		MyFrame.getArea3().append(f.getName()+" ���ӳɹ�\n");
		}
		MyFrame.getArea3().append("----�������----\n");
		MyFrame.getArea3().setCaretPosition(MyFrame.getArea3().getText().length());   
		
        return list;
}
}