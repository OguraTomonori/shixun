package team543.entity;

import java.util.Date;

public class Student {
	//学生id
	private String s_id;
	//学生姓名
	private String s_name;
	//学生性别
	private String s_sex;
	//学生系别
	private String s_dp;
	//学生专业
	private String s_major;
	//学生班级
	private String s_class;
	//学生状态
	private String s_state;
	//入学时间
	private Date Entertime;
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	public String getS_dp() {
		return s_dp;
	}
	public void setS_dp(String s_dp) {
		this.s_dp = s_dp;
	}
	public String getS_major() {
		return s_major;
	}
	public void setS_major(String s_major) {
		this.s_major = s_major;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public String getS_state() {
		return s_state;
	}
	public void setS_state(String s_state) {
		this.s_state = s_state;
	}
	public String getEntertime() {
		return team543.dao.SearchDao.timeFormat(Entertime);
	}
	public void setEntertime(Date Entertime) {
		this.Entertime = Entertime;
	}
	@Override
	public String toString() {
		return "student [s_id=" + s_id + ", s_name=" + s_name + ", s_sex=" + s_sex + ", s_dp=" + s_dp + ", s_major="
				+ s_major + ", s_class=" + s_class + ", s_state=" + s_state + ", Entertime=" + Entertime + "]";
	}
	
	public Student(String s_id, String s_name, String s_sex, String s_dp, String s_major, String s_class,
			String s_state, Date entertime) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_sex = s_sex;
		this.s_dp = s_dp;
		this.s_major = s_major;
		this.s_class = s_class;
		this.s_state = s_state;
		Entertime = entertime;
	}
	
	public Student() {
		
	}
}
