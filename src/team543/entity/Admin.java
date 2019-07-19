package team543.entity;

public class Admin {
	//管理员账号
	private String admin_id;
	//管理员姓名
	private String admin_name;
	
	//get,set函数
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	//输出
	@Override
	public String toString() {
		return "admin [admin_id=" + admin_id + ", admin_name=" + admin_name + "]";
	}

}
