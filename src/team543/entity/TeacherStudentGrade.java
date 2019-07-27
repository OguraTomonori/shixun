package team543.entity;

public class TeacherStudentGrade {
//    教师ID
    private String teacherId;
//    教师姓名
    private String teacherName;
//    学生ID
    private  String studentId;
//    学生姓名
    private String studentName;
//    课程ID
    private String classId;
//    课程名
    private String className;
//    平时成绩
    private String ordTimeGra;
//    考试成绩
    private String exaPapGra;
//    评价
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

