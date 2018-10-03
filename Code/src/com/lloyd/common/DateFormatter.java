/**
 * @author lloyd.brian.v.dagoc
 */

package com.lloyd.common;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateFormatter {

	private static String dateToFormat = "";
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd h:mm a";

	private static String preferredDateFormat = "";
	
	SimpleDateFormat f = null;
	
	public DateFormatter (String date)  {
		this(date, DEFAULT_DATE_FORMAT);
	}
	
	public DateFormatter (String date, String format) {
		dateToFormat = date;
		preferredDateFormat = format;
		
		f = new SimpleDateFormat (preferredDateFormat);
	}
	
	public long longDateValue () throws ParseException {
		
		long milliseconds = 0;
		
		try {
			Date d = f.parse (dateToFormat);
			milliseconds = d.getTime();
		} catch (ParseException e) {	
			//e.printStackTrace();
			System.out.println("Date/time chosen is unparsable. Setting time to default.");
			milliseconds = 0;
		}
		
		return milliseconds;
	}
}
