package hht.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * The StringUtil class contains utility methods to help with strings.
 */

public class StringUtil {

	/*
	 * Converts today's date into a java.sql.Date object formatted as "yyyy-MM-dd"
	 */
	public static Date convertTodaysDateToSQLDate()
	{
		java.util.Date today = new java.util.Date();
		return new Date(today.getTime());
	}
	
	/*
	 * Converts a string formatted as "yyyy-MM-dd" to a java.sql.Date object
	 */
	public static Date convertStringToSQLDate(String dateString)
	{
		java.util.Date tempDate;

		try 
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			tempDate = sdf.parse(dateString);
			return new Date(tempDate.getTime());
		} 
		catch (ParseException e)
		{
			System.out.println(e);
			return null;
		}
	}
	
}
