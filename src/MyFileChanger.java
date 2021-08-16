import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileChanger implements Runnable{
	private File f;
	private String str1;
	private String str2;
	public MyFileChanger(File file,String str1,String str2) {
		f=file;
		this.str1 = str1;
		this.str2 = str2;
	}

	@Override
	public void run() {
		FileWriter out= null;
		BufferedWriter writer= null;
		FileReader in = null;
		BufferedReader reader = null;
		int count = 0;
		int count2 = 0;
		String str = null;
		List<String> l = new ArrayList<String>();
		try {
			in = new FileReader(f);
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
		}
		
		try {
			out = new FileWriter(f);
			writer = new BufferedWriter(out);
			for(String s:l) {
				if(count2==0) {
					writer.write(s+"\n");
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
		}
		
		
	}

}
