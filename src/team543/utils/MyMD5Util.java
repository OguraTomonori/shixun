package team543.utils;

import java.security.MessageDigest;

/**
 * MD5���ܹ�����
 * @author pibigstar
 *
 */
public class MyMD5Util {
	//�Σ����ڻ콻md5
	private static final String slat = "!!!@@@###$$$%%%^^^&&& Q^Q"+String.valueOf(System.currentTimeMillis()) ;
	
	public static String encrypt(String dataStr) {
		try {
//			System.out.println(slat);
			dataStr = dataStr + slat;
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(dataStr.getBytes("UTF8"));
			byte s[] = m.digest();
			String result = "";
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}

