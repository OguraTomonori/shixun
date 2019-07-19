package team543.entity;

public class Grade {
	//学生id
	private String s_id;
	//课程id
	private String c_id;
	//平时成绩
	private String g_OrdTimGra;
	//试卷成绩
	private String g_ExaPopGra;
	//成绩评价
	private String g_evaluate;
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getG_OrdTimGra() {
		return g_OrdTimGra;
	}
	public void setG_OrdTimGra(String g_OrdTimGra) {
		this.g_OrdTimGra = g_OrdTimGra;
	}
	public String getG_ExaPopGra() {
		return g_ExaPopGra;
	}
	public void setG_ExaPopGra(String g_ExaPopGra) {
		this.g_ExaPopGra = g_ExaPopGra;
	}
	public String getG_evaluate() {
		return g_evaluate;
	}
	public void setG_evaluate(String g_evaluate) {
		this.g_evaluate = g_evaluate;
	}
	@Override
	public String toString() {
		return "Grade [s_id=" + s_id + ", c_id=" + c_id + ", g_OrdTimGra=" + g_OrdTimGra + ", g_ExaPopGra="
				+ g_ExaPopGra + ", g_evaluate=" + g_evaluate + "]";
	}
	
}
