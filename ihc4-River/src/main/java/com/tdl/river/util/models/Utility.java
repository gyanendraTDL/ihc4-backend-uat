package com.tdl.river.util.models;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utility {

	public static String getNowDate() {
		String pattern = "dd MMM yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String sdate = simpleDateFormat.format(new Date());
		return sdate;
	}

	public String getStartDate() {
		LocalDateTime currentDate = LocalDateTime.now().minusWeeks(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		String formatDateTime = currentDate.format(formatter);
		return formatDateTime;
	}

	public String getEndDate() {
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		String formatDateTime = currentDate.format(formatter);
		return formatDateTime;
	}

	public static LocalDateTime convertString2Date(String inDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		if (inDate != null)
			dateTime = LocalDateTime.parse(inDate + " 00:00:00", formatter);
		return dateTime;
	}

	public static LocalDateTime convertString2_EndDate(String inDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		if (inDate != null)
			dateTime = LocalDateTime.parse(inDate + " 23:59:59", formatter);
		return dateTime;
	}

	public static LocalDateTime convertStringDate() {
		LocalDateTime dateTime = LocalDateTime.now();
		return dateTime;
	}

	public static LocalDateTime convertString22Date(String inDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		if (inDate != null)
			dateTime = LocalDateTime.parse(inDate + " 00:00:00", formatter);
		return dateTime;
	}

	public static LocalDateTime convertString222Date(String inDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		if (inDate != null)
			dateTime = LocalDateTime.parse(inDate + " 00:00:00", formatter);
		return dateTime;
	}

	public static LocalDateTime startDate() {
		LocalDateTime currentDate = LocalDateTime.now().minusMonths(1);
		return currentDate;
	}

	public static LocalDateTime endDate() {
		LocalDateTime currentDate = LocalDateTime.now();
		return currentDate;
	}

	public static LocalDateTime getLocalTime() {
		LocalDateTime ldt = LocalDateTime.now().plusHours(5);
		ldt = ldt.plusMinutes(30);// Local date time
		return ldt;
	}

	public static LocalDateTime getSimpleTime() {
		LocalDateTime ldt = LocalDateTime.now();
		return ldt;
	}

	public static String dateToString(LocalDateTime currentDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formatDateTime = currentDate.format(formatter);
		return formatDateTime;
	}

	public static LocalDateTime getLocalTime(int countryID, int companyID) {
		LocalDateTime ldt = null;
		if (companyID == 122 || companyID == 137) {
			ZoneId zoneId = ZoneId.of("Asia/Kuala_Lumpur");
			ldt = ldt.now(zoneId);
			// ldt = ldt.plusHours(8);

		}

		else {
			ldt = LocalDateTime.now().plusHours(5);
			ldt = ldt.plusMinutes(30);// Local date time
			String timeZone = "Asia/Calcutta";
			if (countryID == 2 || (companyID == 133 && countryID == 8))
				timeZone = "Asia/Kuala_Lumpur";// malaysia
			else if (countryID == 3)
				timeZone = "Asia/Ho_Chi_Minh";// vitename
			else if (countryID == 4)
				timeZone = "Asia/Jakarta";// indonesiya
			else if (countryID == 8 && companyID != 133)
				timeZone = "Asia/Muscat"; // Oman
			else if (countryID == 9)
				timeZone = "Asia/Bahrain"; // Baharin
			ZoneId zoneId = ZoneId.of(timeZone);
			ldt = ldt.now(zoneId);
		}
		return ldt;
	}

	public static String localDateToString(LocalDateTime currentDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = currentDate.format(formatter);
		return formatDateTime;
	}
}
