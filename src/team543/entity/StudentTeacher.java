package team543.entity;

public class StudentTeacher {
    /*
    * ��ʦ����ѧ����ϵ
    * */
//    ��ʦID
    private String teacherId;
//    ��ʦ����
    private String teacherName;
//    �γ̺�
    private String classId;
//    �γ���
    private String className;
//    ѧ��
    private String studentId;
//    ѧ������
    private String studentName;
//    ѧ��ϵ��
    private String studentDp;
//    ѧ��רҵ
    private String studentMajor;
//    ѧ���༶
    private String StudentClass;

    public String getTeacherId () {
        return teacherId;
    }

    public void setTeacherId (String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName () {
        return teacherName;
    }

    public void setTeacherName (String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassId () {
        return classId;
    }

    public void setClassId (String classId) {
        this.classId = classId;
    }

    public String getClassName () {
        return className;
    }

    public void setClassName (String className) {
        this.className = className;
    }

    public String getStudentId () {
        return studentId;
    }

    public void setStudentId (String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName () {
        return studentName;
    }

    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDp () {
        return studentDp;
    }

    public void setStudentDp (String studentDp) {
        this.studentDp = studentDp;
    }

    public String getStudentMajor () {
        return studentMajor;
    }

    public void setStudentMajor (String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentClass () {
        return StudentClass;
    }

    public void setStudentClass (String studentClass) {
        StudentClass = studentClass;
    }

    @Override
    public String toString () {
        return "StudentTeacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentDp='" + studentDp + '\'' +
                ", studentMajor='" + studentMajor + '\'' +
                ", StudentClass='" + StudentClass + '\'' +
                '}';
    }
}
