package team543.entity;

public class ElectiveClass {
	//ѡ�����
	private String e_id;
	//ѡ��ѧ��
	private String s_id;
	//ѡ�ογ�id
	private String c_id;

	public String getE_id() {
		return e_id;
	}

	public void setE_id(String e_id) {
		this.e_id = e_id;
	}

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

	public String toString() {
		return "ElectiveClass [e_id=" + e_id + ", s_id=" + s_id + ", c_id=" + c_id + "]";
	}

	public ElectiveClass(String s_id, String c_id) {
		super();
		this.s_id = s_id;
		this.c_id = c_id;
	}
	
	public ElectiveClass() {
		
	}
}
