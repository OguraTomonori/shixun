package team543.service;

public class UserCheckAction {
	public static boolean userCheck(String userName ,String sessionID ,String permission) {
		boolean b = false;
		if(team543.utils.MyMD5Util.encrypt(userName+permission).equals(sessionID)) {
			b = true;
		}
		return b;
	}
}
