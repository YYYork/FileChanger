package io.github.yyyork;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTool {
	public static String getTimeMessage() {
		Date now = new Date(); // 创建一个Date对象，获取当前时间
		// 指定格式化格式
		SimpleDateFormat format = new SimpleDateFormat("[yyyy年MM月dd日/E/HH点mm分ss秒]");
		String message ="\n" +format.format(now)+" :\n";
		return message;
	}
}
