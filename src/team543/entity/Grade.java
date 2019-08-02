package team543.entity;

import team543.dao.ClassDao;

public class Grade {
    ClassDao classDao = new ClassDao();
	//ѧ��id
	private String s_id;
	//�γ�id
	private String c_id;
	//ƽʱ�ɼ�
	private String g_OrdTimGra;
	//�Ծ�ɼ�
	private String g_ExaPopGra;
	//�ɼ�����
	private String g_evaluate;
	//���ճɼ�
	private String totalMark;
	
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
	public String getTotalMark() {
		return totalMark;
	}
	public void setTotalMark(String totalMark) {
		this.totalMark = totalMark;
	}
	@Override
	public String toString() {
		return "Grade [s_id=" + s_id + ", c_id=" + c_id + ", g_OrdTimGra=" + g_OrdTimGra + ", g_ExaPopGra="
				+ g_ExaPopGra + ", g_evaluate=" + g_evaluate + ", totalMark=" + totalMark + "]";
	}

	
	public Grade(String s_id, String c_id, String g_OrdTimGra, String g_ExaPopGra, String g_evaluate) {
		super();
		this.s_id = s_id;
		this.c_id = c_id;
		this.g_OrdTimGra = g_OrdTimGra;
		this.g_ExaPopGra = g_ExaPopGra;
		this.g_evaluate = g_evaluate;
		this.totalMark = g_evaluate;
//		if (null != g_OrdTimGra||null !=g_ExaPopGra) {
//			double m = (double) Integer.valueOf(g_OrdTimGra).intValue();
//			double n = (double) Integer.valueOf(g_ExaPopGra).intValue();
//			double p = (double) (Integer.valueOf(new ClassDao().getClassById(c_id).getC_percentage()).intValue()
//					* 0.01);
//			this.totalMark = String.valueOf(m * p + n * (1 - p));
			//this.totalMark = String.valueOf(Integer.valueOf(g_ExaPopGra).intValue()*(Integer.valueOf(g_OrdTimGra).intValue()*Integer.valueOf(classDao.getClassById(s_id).getC_percentage()).intValue()*0.01));
//		}
	}
	public Grade() {
		
	}
}
