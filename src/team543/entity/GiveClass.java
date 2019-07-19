package team543.entity;

public class GiveClass {
	//课程id
	private String c_id;
	//教师id
	private String t_id;
	//上课时间
	private String c_time;
	//上课地点
	private String t_stite;
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
	public String getT_state() {
		return t_stite;
	}
	public void setT_state(String t_stite) {
		this.t_stite = t_stite;
	}
	@Override
	public String toString() {
		return "GiveClass [c_id=" + c_id + ", t_id=" + t_id + ", c_time=" + c_time + ", t_stite=" + t_stite + "]";
	}
}
