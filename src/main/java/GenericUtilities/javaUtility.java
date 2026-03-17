package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtility {

	
	public String getExpDate() {
		
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-mm-dd");
		simple.format(date);
		Calendar cal = simple.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String selectDate = simple.format(cal.getTime());
		return selectDate;
	}
	
	public int getRandomCount() {
		
		Random random = new Random();
		int count = random.nextInt(500);
		return count;
	}
	
	
	
}
