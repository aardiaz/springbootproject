package java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateTest {
	
	/*
	 * 1> LocalDate
	 * 2> LocalDateTime
	 * 3> LocalTime
	 */
	
	public static void main(String[] args) throws ParseException {
		
		System.out.println(Calendar.getAvailableCalendarTypes());
		
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		DateTimeFormatter  formt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(date.format(formt));
		System.out.println(date.plusYears(2));

		
		LocalDateTime  dt = LocalDateTime.now();
		System.out.println(dt.now(ZoneId.of("America/Chicago")));
		System.out.println(ZoneId.getAvailableZoneIds());
		
		LocalTime  lt = LocalTime.now(ZoneId.of("Africa/Nairobi"));
		System.out.println(lt);
	}

}
