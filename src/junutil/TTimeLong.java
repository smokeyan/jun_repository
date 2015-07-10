package junutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TTimeLong {
	
	
	public void aaaa(String c){
		c="2";
	}

	public static void main(String[] args) throws ParseException {
		if(1==1){
			System.out.println(1);
		}else if(1==1){
			System.out.println(2);
		}
	}

	public static String getTime(Long l) {
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		return "" + day + "��" + hour + "Сʱ" + min + "��" + s + "��";

	}
}
