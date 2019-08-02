package team543.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Basic {
	/**
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		  for (int i = str.length();--i>=0;){  
		   if (!(Character.isDigit(str.charAt(i)) || str.charAt(i)== '.')){
		    return false;
		   }
		  }
		  return true;
		}
	
	public static Date StringToDate(String date) throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		return dateformat.parse(date);
	}
	
	public static String  timeFormat(Date date){
		if(null != date) {
			return DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
		}
		else 
			return null;
	}
}
