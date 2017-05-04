package myproject.java8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class DateTime1 {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.toInstant());
		System.out.println(Instant.now());
		Instant now = Instant.now();
		
		ZonedDateTime dateTime1 = ZonedDateTime.ofInstant(now, ZoneId.of("Asia/Singapore"));
		ZonedDateTime dateTime2 = ZonedDateTime.ofInstant(now, ZoneId.of("Asia/Bangkok"));
		 
		System.out.println(dateTime1);
		System.out.println(dateTime2);
		
		String[] availableIDs = TimeZone.getAvailableIDs();
		Arrays.stream(availableIDs)
		    .filter(id -> id.startsWith("Asia"))
			.forEach(System.out::println);
		
		LocalDateTime party = LocalDateTime.of(
		        LocalDate.of(2016, Month.DECEMBER, 25),
		        LocalTime.of(20, 0, 0)
		);
		
		System.out.println(party);

	}
}
