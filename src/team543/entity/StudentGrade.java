package team543.entity;

import team543.dao.ClassDao;

/*
 * ѧ���ɼ�ʵ��
 *
 * */

public class StudentGrade {
	ClassDao classDao = new ClassDao();
    //ѧ��ID
    private String studentId;
    //ѧ������
    private String studentName;
    //�γ�ID
    private String classId;
    //�γ�����
    private String className;
    //ƽʱ��
    private String regularGrade;
    //���Գɼ�
    private String testGrade;
    //�ܷ�
    private String totalMark;//= String.valueOf(Integer.valueOf(testGrade).intValue()*(Integer.valueOf(regularGrade).intValue()*Integer.valueOf(classDao.getClassById(classId).getC_percentage()).intValue()*0.01));

    public String getStudentId () {
        return studentId;
    }

    public String getStudentName () {
        return studentName;
    }

    public String getClassId () {
        return classId;
    }

    public String getClassName () {
        return className;
    }

    public String getRegularGrade () {
        return regularGrade;
    }

    public String getTestGrade () {
        return testGrade;
    }

    public String getTotalMark () {
        return totalMark;
    }

    public void setStudentId (String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }

    public void setClassId (String classId) {
        this.classId = classId;
    }

    public void setClassName (String className) {
        this.className = className;
    }

    public void setRegularGrade (String regularGrade) {
        this.regularGrade = regularGrade;
    }

    public void setTestGrade (String testGrade) {
        this.testGrade = testGrade;
    }

    public void setTotalMark (String totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public String toString () {
        return "StudentGrade{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", regularGrade='" + regularGrade + '\'' +
                ", testGrade='" + testGrade + '\'' +
                ", totalMark='" + totalMark + '\'' +
                '}';
    }

	public StudentGrade(ClassDao classDao, String studentId, String studentName, String classId, String className,
			String regularGrade, String testGrade) {
		super();
		this.classDao = classDao;
		this.studentId = studentId;
		this.studentName = studentName;
		this.classId = classId;
		this.className = className;
		this.regularGrade = regularGrade;
		this.testGrade = testGrade;
		double m = (double)Integer.valueOf(regularGrade).intValue();
		double n =  (double)Integer.valueOf(testGrade).intValue();
		double p = (double) (Integer.valueOf(new ClassDao().getClassById(classId).getC_percentage()).intValue()*0.01);
		this.totalMark = String.valueOf(m*p+n*(1-p));
	}
	
	public StudentGrade() {
		
	}
    
}
