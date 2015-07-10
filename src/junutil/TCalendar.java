package junutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TCalendar {

	public static void main(String[] args) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 1); 
		Date refundDate=calendar.getTime();
		System.out.println(refundDate);
	}
	
	
	public static Long getTime(Long l) {
		long day = l / (24 * 60 * 60 * 1000);
		return day;
	}
}
