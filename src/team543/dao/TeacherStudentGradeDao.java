package team543.dao;

import team543.entity.TeacherStudentGrade;
import team543.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
* 教师角度查询学生成绩等信息
* */
public class TeacherStudentGradeDao {

    /*
    * 根据teacherID查询教师授课的成绩
    * String teacherId>>>>>>>>arrayList<TeacherStudentGrade.
    * */
    public List<TeacherStudentGrade> gradeByTaecherId(String teacherId)throws ReflectiveOperationException, SQLException{
        //????????????
        Connection connection = DBUtils.getConnection();
        //????Statement
        Statement statement = connection.createStatement();
        String sql="SELECT * FROM v_grade_from_teacher WHERE t_id="+teacherId;
        //???sql???
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<TeacherStudentGrade> teacherStudentGrades = new ArrayList<>();
        while(rs.next()) {
            TeacherStudentGrade teacherStudentGrade = new TeacherStudentGrade ();
            teacherStudentGrade.setTeacherId (rs.getString ("t_id"));
            teacherStudentGrade.setTeacherName (rs.getString("t_name"));
            teacherStudentGrade.setStudentId (rs.getString("s_id"));
            teacherStudentGrade.setStudentName (rs.getString ("s_name"));
            teacherStudentGrade.setClassId (rs.getString("c_id"));
            teacherStudentGrade.setClassName (rs.getString  ("c_name"));
            teacherStudentGrade.setOrdTimeGra (rs.getString("g_OrdTimeGra"));
            teacherStudentGrade.setExaPapGra (rs.getString ("g_ExaPapGra"));
            teacherStudentGrade.setEvaluate (rs.getString("g_evaluate"));
            teacherStudentGrades.add(teacherStudentGrade);
        }
        DBUtils.closeConn();
        return teacherStudentGrades;

    }


    /*
    * 查询所有教师的课程及选课学生成绩
    * >>>>>>arrayList<TeacherStudentGrade>
    * */
    public List<TeacherStudentGrade> gradeByTaechers()throws ReflectiveOperationException, SQLException{
        //????????????
        Connection connection = DBUtils.getConnection();
        //????Statement
        Statement statement = connection.createStatement();
        String sql="SELECT * FROM v_grade_from_teacher";
        //???sql???
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<TeacherStudentGrade> teacherStudentGrades = new ArrayList<>();
        while(rs.next()) {
            TeacherStudentGrade teacherStudentGrade = new TeacherStudentGrade ();
            teacherStudentGrade.setTeacherId (rs.getString ("t_id"));
            teacherStudentGrade.setTeacherName (rs.getString("t_name"));
            teacherStudentGrade.setStudentId (rs.getString("s_id"));
            teacherStudentGrade.setStudentName (rs.getString ("s_name"));
            teacherStudentGrade.setClassId (rs.getString("c_id"));
            teacherStudentGrade.setClassName (rs.getString  ("c_name"));
            teacherStudentGrade.setOrdTimeGra (rs.getString("g_OrdTimeGra"));
            teacherStudentGrade.setExaPapGra (rs.getString ("g_ExaPapGra"));
            teacherStudentGrade.setEvaluate (rs.getString("g_evaluate"));
            teacherStudentGrades.add(teacherStudentGrade);
        }
        DBUtils.closeConn();
        return teacherStudentGrades;

    }


}
