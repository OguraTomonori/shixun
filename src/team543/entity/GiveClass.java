package team543.entity;

public class GiveClass {
	//授课编号
	private String g_id;
	//课程id
	private String c_id;
	//教师id
	private String t_id;
	//上课时间
	private String c_time;
	//上课地点
	private String t_site;
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
	public String getT_site() {
		return t_site;
	}
	public void setT_site(String t_site) {
		this.t_site = t_site;
	}
	public String getG_id() {
		return g_id;
	}
	public void setG_id(String g_id) {
		this.g_id = g_id;
	}
	@Override
	public String toString() {
		return "GiveClass [g_id=" + g_id + ", c_id=" + c_id + ", t_id=" + t_id + ", c_time=" + c_time + ", t_site="
				+ t_site + "]";
	}
	public GiveClass(String g_id, String c_id, String t_id, String c_time, String t_site) {
		super();
		this.g_id = g_id;
		this.c_id = c_id;
		this.t_id = t_id;
		this.c_time = c_time;
		this.t_site = t_site;
	}
	
	public GiveClass() {
		
	}
}
