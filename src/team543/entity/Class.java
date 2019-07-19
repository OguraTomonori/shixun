package team543.entity;

public class Class {
	//课程id
	private String c_id;
	//课程名称
	private String c_name;
	//课程状态
	private String c_classstate;
	//课程学分
	private String c_source;
	//开课院系
	private String c_opendp;
	//平时成绩占比
	private String c_percentage;
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_classstate() {
		return c_classstate;
	}
	public void setC_classstate(String c_classstate) {
		this.c_classstate = c_classstate;
	}
	public String getC_source() {
		return c_source;
	}
	public void setC_source(String c_source) {
		this.c_source = c_source;
	}
	public String getC_opendp() {
		return c_opendp;
	}
	public void setC_opendp(String c_opendp) {
		this.c_opendp = c_opendp;
	}
	public String getC_percentage() {
		return c_percentage;
	}
	public void setC_percentage(String c_percentage) {
		this.c_percentage = c_percentage;
	}
	@Override
	public String toString() {
		return "Class [c_id=" + c_id + ", c_name=" + c_name + ", c_classstate=" + c_classstate + ", c_source="
				+ c_source + ", c_opendp=" + c_opendp + ", c_percentage=" + c_percentage + "]";
	}
	
	

}
