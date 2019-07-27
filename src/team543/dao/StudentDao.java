package team543.dao;

import team543.entity.Student;
import team543.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;


/*
* getStudents 获取学生列表
* getStudentById  由学号查询学生
* addStudent 批量添加学生
* deleteStudent  批量删除学生
* updateStudent 批量修改学生
* */

public class StudentDao {

    /*
     * 获取学生列表
     * @return students(ArrayList)
     * @throws ReflectiveOperationException
     * @throws SQLException
     */
    public  ArrayList<Student> getStudents() throws ReflectiveOperationException, SQLException{
        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //创建Statement
        Statement statement = connection.createStatement();
        //sql语句
        String sql="SELECT * FROM t_student";
        //执行sql语句
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<Student> students = new ArrayList<Student> ();
        while(rs.next()) {
            Student student = new Student();
            student.setS_id (rs.getString ("s_id"));
            student.setS_name (rs.getString("s_name"));
            student.setS_sex (rs.getString("s_sex"));
            student.setS_dp (rs.getString ("s_dp"));
            student.setS_major (rs.getString("s_major"));
            student.setS_class (rs.getString ("s_class"));
            student.setS_state (rs.getString("s_state"));
            student.setEntertime (rs.getString("s_entertime"));
            students.add(student);
        }
        DBUtils.closeConn();
        return students;
    }


    /*
     * 通过学生ID查询学生信息
     * @param studentId
     * @return student(class)
     * @throws ReflectiveOperationException
     * @throws SQLException
     */
    public  Student getStudentById (String studentId) throws ReflectiveOperationException, SQLException {
        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //创建Statement
        Statement statement = connection.createStatement();
        //sql语句
        String sql="SELECT * FROM t_student WHERE s_id="+studentId;
        //执行sql语句
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()) {
            Student student = new Student();
            student.setS_id (rs.getString ("s_id"));
            student.setS_name (rs.getString("s_name"));
            student.setS_sex (rs.getString("s_sex"));
            student.setS_dp (rs.getString ("s_dp"));
            student.setS_major (rs.getString("s_major"));
            student.setS_class (rs.getString  ("s_class"));
            student.setS_state (rs.getString("s_state"));
            student.setEntertime (rs.getString("s_entertime"));
            return student;
        }
        return null;
    }


    /*
     * 添加学生(批量)
     * 学号、姓名、性别、系别、班级、状态、入学时间
     * @param Student[]
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public  void addStudent(ArrayList<Student> s,Connection connection) throws SQLException, ReflectiveOperationException {
        //sql语句
        for (Student student:s
<<<<<<< HEAD
        ) {  String sql = "INSERT into  t_student (s_id, s_name, s_sex, s_dp, s_class, s_state, s_entertime) VALUES (?,?,?,?,?,?,?)";
=======
        ) {
            String sql = "INSERT into  t_student (s_id, s_name, s_sex, s_dp, s_class, s_state, s_entertime) VALUES (?,?,?,?,?,?,now())";
>>>>>>> d0c0f999e0272ab26dec4ef3bda76dc874fcbf8c
            //创建prepareStatement
            PreparedStatement pst = connection.prepareStatement (sql);
            pst.setString (1, student.getS_id ());
            pst.setString (2, student.getS_name ());
            pst.setString (3, student.getS_sex ());
            pst.setString (4, student.getS_dp ());
            pst.setString (5, student.getS_class ());
            pst.setString (6, student.getS_state ());
//            pst.setString (7, student.getEntertime ());
            pst.executeUpdate ();
        }
    }



    /*
     * 通过学生ID删除学生（批量）
     * @param id[]
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public static void deleteStudent(int[] id) throws SQLException, ReflectiveOperationException {
        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        for (int i=0;i<id.length;i++
             ) {
            //sql语句
            String sql="DELETE FROM t_student WHERE s_id=?";
            //创建prepareStatement
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id[i]);
            pst.executeUpdate();
        }

        DBUtils.closeConn();
    }


    /*
     * 更新学生信息（批量操作）
     * s_name,s_sex,s_dp,s_major,s_class,s_state,s_entertime
     * @param  Student[]
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public static void updateStudent (Student[] s) throws SQLException, ReflectiveOperationException {
        //获取数据库连接
        Connection connection = DBUtils.getConnection ();

        for (Student student:s
             ) {
            String sql = "UPDATE t_student SET s_name=?,s_sex=?,s_dp=?,s_major=?,s_class=?,s_state=?,s_entertime=? WHERE s_id=?";
            //创建prepareStatement
            PreparedStatement pst = connection.prepareStatement (sql);
            pst.setString (1, student.getS_name ());
            pst.setString (2, student.getS_sex ());
            pst.setString (3, student.getS_dp ());
            pst.setString (4, student.getS_major ());
            pst.setString (5, student.getS_class ());
            pst.setString (6, student.getS_state ());
            pst.setString (7, student.getEntertime ());
            pst.setString (8, student.getS_id ());
            pst.executeUpdate ();
        }

        //sql语句
        DBUtils.closeConn ();
    }
}
