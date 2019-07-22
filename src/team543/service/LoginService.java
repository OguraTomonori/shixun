package team543.service;

import team543.service.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

 /**
 * 	登陆函数 
 *	接收输入的userId password
 *  返回list
 *  登陆成功返回  0， 用户权限 ， md5加密后的用户id
 *  登陆失败返回 1：用户密码错误
 *  		 2：没有此用户
 */
public class LoginService {

	
	public static List login(String userId, String password) {
		List list = new LinkedList<>();
		try {
			Connection con = team543.utils.DBUtils.getConnection();
			Statement createStatement = con.createStatement();
			String sql = "select user_password,user_root from t_user where user_id ='"+userId+"';";
			
			//执行sql语句
			ResultSet re = createStatement.executeQuery(sql);
			//判断结果中是否有值
			if(re.next()==true) {
				//判断密码是否输入正确
				if(re.getString("user_password").equals(password)) {
					//密码正确
					list.add(0);      
					list.add(re.getString("user_root"));
					list.add(team543.utils.MyMD5Util.encrypt(userId));
				} else list.add(1);
			} else list.add(2);
			//关闭连接
			team543.utils.DBUtils.closeConn();
		} catch (ReflectiveOperationException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
