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
* 查询学生课程成绩
* 对v_student_grade视图的操作
* */


public class StudentGradeDao {

    /*
    * 查询单个学生成绩
    *  studentId>>>>>StudentGrade(class)
    * */

    public ArrayList<StudentGrade>  getStudentGrade(String studentId)throws SQLException, ReflectiveOperationException{

        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //创建Statement
        Statement statement = connection.createStatement();
        //sql语句
        String sql="SELECT * FROM v_student_grade WHERE s_id='"+studentId+"'";
        //执行sql语句
        ResultSet rs = statement.executeQuery(sql);
        
        ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
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
        return studentGrades;
    }

    /*
    * 查询所有成绩
    * 0>>>>>> list studentGrades
    * 1>>>>>> list classGrades
    * */

    public ArrayList<StudentGrade> getGrades(int i,int sequence) throws ReflectiveOperationException, SQLException{
        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //创建Statement
        Statement statement = connection.createStatement();
        
        String sql = "SELECT * FROM v_student_grade ORDER BY ";
        
        //sql语句
        if (i == 0) {
            sql += " s_id ";

        }else if(i==1){
            sql += " c_id ";
        }
        
        if(sequence==1) {
        	sql+=" DESC ;";
        } else {
        	sql+=" ; ";
        }
//        System.out.println(sql);
        //执行sql语句
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<StudentGrade> studentGrades = new ArrayList<> ();
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
    * 查询单个课程成绩
    * classID>>>>>>>
    * */

    public StudentGrade getClassGrade(String classId)throws SQLException, ReflectiveOperationException{

        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //创建Statement
        Statement statement = connection.createStatement();
        //sql语句
        String sql="SELECT * FROM v_student_grade WHERE s_id="+classId;
        //执行sql语句
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
