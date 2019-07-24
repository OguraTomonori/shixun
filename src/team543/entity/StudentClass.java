package team543.entity;

/*
选课表中无教师id
* 学生选课无法找到老师
*查询不到授课老师
存在多值依赖
* */

public class StudentClass {
//    学生ID
    private String studentID;
//    学生姓名
    private String studentName;
//    课程ID
    private String classId;
//    课程名称
    private String className;

}
