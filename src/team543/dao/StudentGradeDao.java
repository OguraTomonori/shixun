package team543.dao;

import team543.entity.StudentGrade;
import team543.utils.DBUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/*
* ��ѯѧ���γ̳ɼ�
* ��v_student_grade��ͼ�Ĳ���
* */


public class StudentGradeDao {

    /*
    * ��ѯ����ѧ���ɼ�
    *  studentId>>>>>StudentGrade(class)
    * */

    public static StudentGrade getStudentGrade(String studentId)throws SQLException, ReflectiveOperationException{

        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //sql���
        String sql="SELECT * FROM v_student_grade WHERE s_id="+studentId;
        //ִ��sql���
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()) {
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setStudentId (rs.getString ("s_id"));
            studentGrade.setStudentName (rs.getString("s_name"));
            studentGrade.setClassId (rs.getString("c_id"));
            studentGrade.setClassName (rs.getString ("c_name"));
            studentGrade.setRegularGrade (rs.getString("g_OrdTimeGra"));
            studentGrade.setTestGrade (rs.getString  ("g_ExaPapGra"));
            studentGrade.setTotalMark (rs.getString("g_evaluate"));
            return studentGrade;
        }
        return null;
    }

    /*
    * ��ѯ���гɼ�
    * 0>>>>>> list studentGrades
    * 1>>>>>> list classGrades
    * */

    public static List<StudentGrade> getGrades(int i) throws ReflectiveOperationException, SQLException{
        String sql;
        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //sql���
        if (i == 0) {
            sql = "SELECT * FROM v_student_grade ORDER BY s_id";

        }else {
            sql = "SELECT * FROM v_student_grade ORDER BY c_id";
        }
        //ִ��sql���
        ResultSet rs = statement.executeQuery(sql);
        List<StudentGrade> studentGrades = new ArrayList<> ();
        while(rs.next()) {
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setStudentId (rs.getString ("s_id"));
            studentGrade.setStudentName (rs.getString("s_name"));
            studentGrade.setClassId (rs.getString("c_id"));
            studentGrade.setClassName (rs.getString ("c_name"));
            studentGrade.setRegularGrade (rs.getString("g_OrdTimeGra"));
            studentGrade.setTestGrade (rs.getString  ("g_ExaPapGra"));
            studentGrade.setTotalMark (rs.getString("g_evaluate"));
            studentGrades.add(studentGrade);
        }
        DBUtils.closeConn();
        return studentGrades;
    }

    /*
    * ��ѯ�����γ̳ɼ�
    * classID>>>>>>>
    * */

    public static StudentGrade getClassGrade(String classId)throws SQLException, ReflectiveOperationException{

        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //sql���
        String sql="SELECT * FROM v_student_grade WHERE s_id="+classId;
        //ִ��sql���
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()) {
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setStudentId (rs.getString ("s_id"));
            studentGrade.setStudentName (rs.getString("s_name"));
            studentGrade.setClassId (rs.getString("c_id"));
            studentGrade.setClassName (rs.getString ("c_name"));
            studentGrade.setRegularGrade (rs.getString("g_OrdTimeGra"));
            studentGrade.setTestGrade (rs.getString  ("g_ExaPapGra"));
            studentGrade.setTotalMark (rs.getString("g_evaluate"));
            return studentGrade;
        }
        return null;
    }
}
