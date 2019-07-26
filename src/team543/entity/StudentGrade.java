package team543.entity;


/*
 * 学生成绩实体
 *
 * */

public class StudentGrade {
    //学生ID
    private String studentId;
    //学生姓名
    private String studentName;
    //课程ID
    private String classId;
    //课程名称
    private String className;
    //平时分
    private String regularGrade;
    //考试成绩
    private String testGrade;
    //总分
    private String totalMark;

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
}
