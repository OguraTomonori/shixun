package team543.utils;

public class Basic {
	/**
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		  for (int i = str.length();--i>=0;){  
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		}
	
	
}
