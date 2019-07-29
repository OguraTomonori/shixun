package team543.utils;
/**
 * 数据库操作工具类
 * @author Administrator
 *
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	private static String url="";
	private static String user="";
	private static String password="";
	private static Connection conn = null;
	static {
		try {
			
			InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties p = new Properties();
			p.load(in);
			url = p.getProperty("jdbc.url");
			user = p.getProperty("jdbc.user");
			password = p.getProperty("jdbc.password");
			/*System.out.println(url);
			System.out.println(user);
			System.out.println(password);*/
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ReflectiveOperationException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	/**
	 * 关闭数据库连接
	 */
	public static void closeConn() {
		if(null!=conn) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	
	public static void main(String[] args) throws ReflectiveOperationException, SQLException {
		
		Connection conn = getConnection();
		System.out.println(conn);
		
		
	}
	
	
}
