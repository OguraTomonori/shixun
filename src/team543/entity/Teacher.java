package team543.entity;

import java.util.Date;

public class Teacher {
	//教师id
	private String t_id;
	//教师姓名
	private String t_name;
	//教师院系
	private String t_dp;
	//教师职称
	private String t_jobtitle;
	//教师薪水
	private String t_salay;
	//教师电话号码
	private String t_phonenum;
	//教师电子邮箱
	private String t_email;
	//教师办公室
	private String t_office;
	//教师状态
	private String t_state;
	//教师入职时间
	private Date t_entertime;
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_dp() {
		return t_dp;
	}
	public void setT_dp(String t_dp) {
		this.t_dp = t_dp;
	}
	public String getT_jobtitle() {
		return t_jobtitle;
	}
	public void setT_jobtitle(String t_jobtitle) {
		this.t_jobtitle = t_jobtitle;
	}
	public String getT_salay() {
		return t_salay;
	}
	public void setT_salay(String t_salay) {
		this.t_salay = t_salay;
	}
	public String getT_phonenum() {
		return t_phonenum;
	}
	public void setT_phonenum(String t_phonenum) {
		this.t_phonenum = t_phonenum;
	}
	public String getT_email() {
		return t_email;
	}
	public void setT_email(String t_email) {
		this.t_email = t_email;
	}
	public String getT_office() {
		return t_office;
	}
	public void setT_office(String t_office) {
		this.t_office = t_office;
	}
	public String getT_state() {
		return t_state;
	}
	public void setT_state(String t_state) {
		this.t_state = t_state;
	}
	public Date getT_entertime() {
		return t_entertime;
	}
	public void setT_entertime(Date t_entertime) {
		this.t_entertime = t_entertime;
	}
	@Override
	public String toString() {
		return "teacher [t_id=" + t_id + ", t_name=" + t_name + ", t_dp=" + t_dp + ", t_jobtitle=" + t_jobtitle
				+ ", t_salay=" + t_salay + ", t_phonenum=" + t_phonenum + ", t_email=" + t_email + ", t_office="
				+ t_office + ", t_state=" + t_state + ", t_entertime=" + t_entertime + "]";
	}
	public Teacher(String t_id, String t_name, String t_dp, String t_jobtitle, String t_salay, String t_phonenum,
			String t_email, String t_office, String t_state, Date t_entertime) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_dp = t_dp;
		this.t_jobtitle = t_jobtitle;
		this.t_salay = t_salay;
		this.t_phonenum = t_phonenum;
		this.t_email = t_email;
		this.t_office = t_office;
		this.t_state = t_state;
		this.t_entertime = t_entertime;
	}
	
	public Teacher() {
		
	}
}
