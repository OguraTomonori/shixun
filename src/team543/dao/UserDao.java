package team543.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import team543.entity.Student;
import team543.entity.User;
import team543.utils.DBUtils;

public class UserDao {
	
	/**
	 * 输出所有的用户
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<User> getAllUser() throws ReflectiveOperationException, SQLException{
		String sql = "SELECT * FROM t_user ;";
		//获取连接
		Connection connection = team543.utils.DBUtils.getConnection();
		Statement statement = connection.createStatement();
		//执行sql语句
		ResultSet rs = statement.executeQuery(sql);
		ArrayList<User> users = new ArrayList<User>();
		//将获得的数据输入列表
		while(rs.next()) {
			User user = new User();
			user.setUser_id(rs.getString("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_password(rs.getString("user_password"));
			user.setUser_root(rs.getString("user_root"));
			users.add(user);
		}
		DBUtils.closeConn();
		return users;
	}
	
	/**
	 * 根据用户id获得用户数据
	 * @param userId
	 * @return
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 */
	public User getUserById(String userId) throws SQLException, ReflectiveOperationException {
		String sql = "SELECT * FROM t_user WHERE user_id = '"+userId+"';";
		Connection connection = team543.utils.DBUtils.getConnection();
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery(sql);
		
		User user = new User();
		//判断结果
		if (rs.next()) {
			user.setUser_id(rs.getString("user_id"));
			user.setUser_name(rs.getString("user_name"));
			user.setUser_password(rs.getString("user_password"));
			user.setUser_root(rs.getString("user_root"));
		}
		return user;
	}
	
	public void updataUserInfo(User user) throws ReflectiveOperationException, SQLException {
		String sql = "UPDATE t_user SET user_name = ? , user_password = ? , user_root=?  WHERE user_id=?";
		Connection connection = team543.utils.DBUtils.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, user.getUser_name());
		pst.setString(2, user.getUser_password());
		pst.setString(3, user.getUser_root());
		pst.setString(4, user.getUser_root());
		//提交
		pst.executeUpdate();
		//关闭连接
		DBUtils.closeConn();
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public void addUser(ArrayList<User> users,Connection connection) throws ReflectiveOperationException, SQLException {
		for(User user:users) {
			String sql = "INSERT into  t_user (user_id,user_name,user_password,user_root) VALUES (?,?,?,?,?,?,?);";
		PreparedStatement pst = connection.prepareStatement (sql);
		pst.setString(1, user.getUser_id());
		pst.setString(2, user.getUser_name());
		pst.setString(3, user.getUser_password());
		pst.setString(4, user.getUser_root());
		}
	}
	
//	public void addStudent(ArrayList<User> users ,ArrayList<Student> student) throws ReflectiveOperationException, SQLException {
//		
//		Connection connection = DBUtils.getConnection();
//		
//		StudentDao studentDao = new StudentDao();
//		//取消默认提交
////		connection.setAutoCommit(false);
//		
//		addUser(users, connection);
//		studentDao.addStudent(student, connection);
//		//提交
////		DBUtils.closeConn();
//	}
}
