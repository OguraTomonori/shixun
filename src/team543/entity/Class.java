package team543.entity;

public class Class {
	//课程id
	private String c_id;
	//课程名称
	private String c_name;
	//课程状态
	private String c_classstate;
	//课程学分
	private String c_score;
	//开课院系
	private String c_opendp;
	//平时成绩占比
	private Integer c_percentage;
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
	public String getC_score() {
		return c_score;
	}
	public void setC_score(String c_score) {
		this.c_score = c_score;
	}
	public String getC_opendp() {
		return c_opendp;
	}
	public void setC_opendp(String c_opendp) {
		this.c_opendp = c_opendp;
	}
	public Integer getC_percentage() {
		return c_percentage;
	}
	public void setC_percentage(Integer c_percentage) {
		this.c_percentage = c_percentage;
	}
	@Override
	public String toString() {
		return "Class [c_id=" + c_id + ", c_name=" + c_name + ", c_classstate=" + c_classstate + ", c_score="
				+ c_score + ", c_opendp=" + c_opendp + ", c_percentage=" + c_percentage + "]";
	}
	public Class(String c_id, String c_name, String c_classstate, String c_score, String c_opendp,
			Integer c_percentage) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_classstate = c_classstate;
		this.c_score = c_score;
		this.c_opendp = c_opendp;
		this.c_percentage = c_percentage;
	}
	
	public Class() {
		
	}

}
