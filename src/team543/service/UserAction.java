package team543.service;

import java.sql.SQLException;

import team543.dao.UserDao;
import team543.entity.User;

/**
 *	 @author 公子小白
 * 	 @date 2019年7月30日上午9:43:20
 *
 */
public class UserAction {
	
	/**
	 * @param user
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public String updateUser(User user) {
		UserDao userDao = new UserDao();
		String b = "success";
		try {
			userDao.updataUserInfo(user);
		} catch (ReflectiveOperationException | SQLException e) {
			b = "failed";
		}
		return b ;
	}
}
