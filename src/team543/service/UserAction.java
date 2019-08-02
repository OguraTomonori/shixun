package team543.service;

import java.sql.SQLException;
import java.util.ArrayList;

import team543.dao.UserDao;
import team543.entity.User;

/**
 *	 @author 鍏瓙灏忕櫧
 * 	 @date 2019骞�7鏈�30鏃ヤ笂鍗�9:43:20
 *
 */
public class UserAction {
	
	/**
	 * @param user
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public static String updateUser(String id, String oldpw ,String newpw) {
		ArrayList res = new LoginAction().login(id, oldpw);
		String b = "success";
		if ((Integer) res.get(0) == 0) {
			try {
				UserDao userDao = new UserDao();
				userDao.updataUserInfo(new User(
					id, newpw, (String) res.get(3), (String) res.get(1)
						));
			} catch (ReflectiveOperationException | SQLException e) {
				b = "failed";
			}
		}
		else {
			b = "failed";
		}
		return b ;
	}
	public static void main(String[] args) {
		System.out.println(updateUser("110603","110603","111111"));
	}
}
