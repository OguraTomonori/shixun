package team543.entity;

public class Student {
	//ѧ��id
	private String s_id;
	//ѧ������
	private String s_name;
	//ѧ���Ա�
	private String s_sex;
	//ѧ��ϵ��
	private String s_dp;
	//ѧ��רҵ
	private String s_major;
	//ѧ���༶
	private String s_class;
	//ѧ��״̬
	private String s_state;
	//��ѧʱ��
	private String entertame;
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
	public String getEntertame() {
		return entertame;
	}
	public void setEntertame(String entertame) {
		this.entertame = entertame;
	}
	@Override
	public String toString() {
		return "student [s_id=" + s_id + ", s_name=" + s_name + ", s_sex=" + s_sex + ", s_dp=" + s_dp + ", s_major="
				+ s_major + ", s_class=" + s_class + ", s_state=" + s_state + ", entertame=" + entertame + "]";
	}

}
