package team543.entity;

public class StudentTeacher {
    /*
    * 教师所教学生关系
    * */
//    教师ID
    private String teacherId;
//    教师姓名
    private String teacherName;
//    课程号
    private String classId;
//    课程名
    private String className;
//    学号
    private String studentId;
//    学生姓名
    private String studentName;
//    学生系别
    private String studentDp;
//    学生专业
    private String studentMajor;
//    学生班级
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
