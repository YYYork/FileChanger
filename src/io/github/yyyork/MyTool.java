package io.github.yyyork;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTool {
	public static String getTimeMessage() {
		Date now = new Date(); // ����һ��Date���󣬻�ȡ��ǰʱ��
		// ָ����ʽ����ʽ
		SimpleDateFormat format = new SimpleDateFormat("[yyyy��MM��dd��/E/HH��mm��ss��]");
		String message ="\n" +format.format(now)+" :\n";
		return message;
	}
}
