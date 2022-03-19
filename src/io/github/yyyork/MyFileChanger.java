package io.github.yyyork;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MyFileChanger implements Runnable{
	private File f;
	private String str1;
	private String str2;
	private String codeStyle;
	public MyFileChanger(File file,String str1,String str2,String codeStyle) {
		this.f=file;
		this.str1 = str1;
		this.str2 = str2;
		this.codeStyle = codeStyle;
	}

	@Override
	public void run() {
		BufferedWriter writer= null;
		OutputStreamWriter out = null;
		FileOutputStream fileout = null;
		FileInputStream filein = null;
		InputStreamReader in = null;
		BufferedReader reader = null;
		int count = 0;
		int count2 = 0;
		String str = null;
		List<String> l = new ArrayList<String>();
		try {
			filein = new FileInputStream(f);
			in = new InputStreamReader(filein,codeStyle);
			reader = new BufferedReader(in);
			while((str=reader.readLine()) != null) {
				l.add(str);
			}
			
			for(String s:l) {
				String changed = s.replaceAll(str1, str2);
				l.set(count, changed);
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(filein!=null)
				try {
					filein.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		try {
			fileout = new FileOutputStream(f);
			out = new OutputStreamWriter(fileout, codeStyle);
			writer = new BufferedWriter(out);
			for(String s:l) {
				if(count2==0&&(count2+1)==l.size()) {
					writer.write(s);
				}else if(count2==0&&(count2+1)!=l.size()){
					writer.write(s+"\n");
				}
				else if(count2==l.size()){
					writer.append(s);
				}else {
					writer.append(s+"\n");
				}
			count2++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(out!=null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(fileout!=null)
				try {
					fileout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
