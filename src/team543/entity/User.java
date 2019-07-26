package team543.entity;

public class User {
	//使用者id
	private String user_id;
	//用户密码
	private String user_password;
	//用户姓名
	private String user_name;
	//用户权限
	private String user_root;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_root() {
		return user_root;
	}
	public void setUser_root(String user_root) {
		this.user_root = user_root;
	}
	
	
	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_root=" + user_root + "]";
	}
	public User(String user_id, String user_password, String user_name, String user_root) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_root = user_root;
	}
	
	public User() {
		
	}

}
