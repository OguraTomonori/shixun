package team543.entity;

public class TeacherStudentGrade {
//    ��ʦID
    private String teacherId;
//    ��ʦ����
    private String teacherName;
//    ѧ��ID
    private  String studentId;
//    ѧ������
    private String studentName;
//    �γ�ID
    private String classId;
//    �γ���
    private String className;
//    ƽʱ�ɼ�
    private String ordTimeGra;
//    ���Գɼ�
    private String exaPapGra;
//    ����
    private  String evaluate;

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

    public String getOrdTimeGra () {
        return ordTimeGra;
    }

    public void setOrdTimeGra (String ordTimeGra) {
        this.ordTimeGra = ordTimeGra;
    }

    public String getExaPapGra () {
        return exaPapGra;
    }

    public void setExaPapGra (String exaPapGra) {
        this.exaPapGra = exaPapGra;
    }

    public String getEvaluate () {
        return evaluate;
    }

    public void setEvaluate (String evaluate) {
        this.evaluate = evaluate;
    }

    @Override
    public String toString () {
        return "TeacherStudentGrade{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", ordTimeGra='" + ordTimeGra + '\'' +
                ", exaPapGra='" + exaPapGra + '\'' +
                ", evaluate='" + evaluate + '\'' +
                '}';
    }
}

