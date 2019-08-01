package team543.dao;


import team543.entity.StudentTeacher;
import team543.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentTeacherDao {

    /*
    * ���ݽ�ʦID��ѯ��ʦ����ѧ��
    * */
    public ArrayList<StudentTeacher> getStudentByTeacherId(String teacherId) throws ReflectiveOperationException, SQLException{
        //????????????
        Connection connection = DBUtils.getConnection();
        //????Statement
        Statement statement = connection.createStatement();
        String sql="SELECT * FROM v_student_from_teacher WHERE t_id="+teacherId;
        //???sql???
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<StudentTeacher> studentTeachers = new ArrayList<> ();
        while(rs.next()) {
            StudentTeacher studentTeacher = new StudentTeacher ();
            studentTeacher.setTeacherId (rs.getString ("t_id"));
            studentTeacher.setTeacherName (rs.getString("t_name"));
            studentTeacher.setClassId (rs.getString("c_id"));
            studentTeacher.setClassName (rs.getString  ("c_name"));
            studentTeacher.setStudentId (rs.getString("s_id"));
            studentTeacher.setStudentName (rs.getString ("s_name"));
            studentTeacher.setStudentDp (rs.getString("s_dp"));
            studentTeacher.setStudentMajor (rs.getString ("s_major"));
            studentTeacher.setStudentClass (rs.getString("s_class"));
            studentTeachers.add(studentTeacher);
        }
        DBUtils.closeConn();
        return studentTeachers;

    }


    /*
     * ��ѯ������ʦ����ѧ��
     * */
//    public ArrayList<StudentTeacher> getStudentByTeachers() throws ReflectiveOperationException, SQLException{
//        //????????????
//        Connection connection = DBUtils.getConnection();
//        //????Statement
//        Statement statement = connection.createStatement();
//        String sql="SELECT * FROM v_student_from_teacher";
//        //???sql???
//        ResultSet rs = statement.executeQuery(sql);
//        ArrayList<StudentTeacher> studentTeachers = new ArrayList<> ();
//        while(rs.next()) {
//            StudentTeacher studentTeacher = new StudentTeacher ();
//            studentTeacher.setTeacherId (rs.getString ("t_id"));
//            studentTeacher.setTeacherName (rs.getString("t_name"));
//            studentTeacher.setClassId (rs.getString("c_id"));
//            studentTeacher.setClassName (rs.getString  ("c_name"));
//            studentTeacher.setStudentId (rs.getString("s_id"));
//            studentTeacher.setStudentName (rs.getString ("s_name"));
//            studentTeacher.setStudentDp (rs.getString("s_dp"));
//            studentTeacher.setStudentMajor (rs.getString ("s_major"));
//            studentTeacher.setStudentClass (rs.getString("s_class"));
//            studentTeachers.add(studentTeacher);
//        }
//        DBUtils.closeConn();
//        return studentTeachers;
//    }

}
