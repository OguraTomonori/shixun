package team543.dao;

import team543.entity.Student;
import team543.utils.DBUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/*
* getStudents ��ȡѧ���б�
* getStudentById  ��ѧ�Ų�ѯѧ��
* addStudent �������ѧ��
* deleteStudent  ����ɾ��ѧ��
* updateStudent �����޸�ѧ��
* */

public class StudentDao {

    /*
     * ��ȡѧ���б�
     * @return students(ArrayList)
     * @throws ReflectiveOperationException
     * @throws SQLException
     */
    public  ArrayList<Student> getStudents() throws ReflectiveOperationException, SQLException{
        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //sql���
        String sql="SELECT * FROM t_student";
        //ִ��sql���
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
            student.setEntertime (rs.getDate("s_entertime"));
            students.add(student);
        }
        DBUtils.closeConn();
        return students;
    }


    /*
     * ͨ��ѧ��ID��ѯѧ����Ϣ
     * @param studentId
     * @return student(class)
     * @throws ReflectiveOperationException
     * @throws SQLException
     */
    public  Student getStudentById (String studentId) throws ReflectiveOperationException, SQLException {
        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //sql���
        String sql="SELECT * FROM t_student WHERE s_id="+studentId;
        //ִ��sql���
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
            student.setEntertime (rs.getDate("s_entertime"));
            return student;
        }
        return null;
    }


    /*
     * ���ѧ��(����)
     * ѧ�š��������Ա�ϵ�𡢰༶��״̬����ѧʱ��
     * @param Student[]
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public  void addStudents(ArrayList<Student> s,Connection connection) throws SQLException, ReflectiveOperationException {
        //sql���
        for (Student student:s
        ) {
            String sql = "INSERT into  t_student (s_id, s_name, s_sex, s_dp, s_class, s_state, s_entertime) VALUES (?,?,?,?,?,?,now())";
            //����prepareStatement
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
    public  void addStudent(Student student) throws SQLException, ReflectiveOperationException {
        String sql = "INSERT into  t_student (s_id, s_name, s_sex, s_dp, s_class, s_state, s_entertime) VALUES (?,?,?,?,?,?,?)";
        //����prepareStatement
        Connection connection = DBUtils.getConnection();
        PreparedStatement pst = connection.prepareStatement (sql);
        pst.setString (1, student.getS_id ());
        pst.setString (2, student.getS_name ());
        pst.setString (3, student.getS_sex ());
        pst.setString (4, student.getS_dp ());
        pst.setString (5, student.getS_class ());
        pst.setString (6, student.getS_state ());
        pst.setString (7, student.getEntertime ());
        pst.executeUpdate ();
        DBUtils.closeConn();
   }
 

    /**
     * @param studentId
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public  void deleteStudent(String studentId) throws SQLException, ReflectiveOperationException {
        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
		//sql���
		String sql = "DELETE FROM t_student WHERE s_id=?";
		//����prepareStatement
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, studentId);
		pst.executeUpdate();
        DBUtils.closeConn();
    }

    /**
     * 添加单个学生
     * @param student
     * @throws ReflectiveOperationException
     * @throws SQLException
     * @throws ParseException
     */
    public void updateStudent(Student student) throws ReflectiveOperationException, SQLException, ParseException {
    	  String sql = "UPDATE t_student SET s_name=?,s_sex=?,s_dp=?,s_major=?,s_class=?,s_state=?,s_entertime=? WHERE s_id=?";
    	  Connection connection = DBUtils.getConnection ();
    	  //����prepareStatement
          PreparedStatement pst = connection.prepareStatement (sql);
          pst.setString (1, student.getS_name ());
          pst.setString (2, student.getS_sex ());
          pst.setString (3, student.getS_dp ());
          pst.setString (4, student.getS_major ());
          pst.setString (5, student.getS_class ());
          pst.setString (6, student.getS_state ());
          
          
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          
          java.util.Date utilDate=simpleDateFormat.parse(student.getEntertime());

          java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
          
          pst.setDate (7, sqlDate);
          pst.setString (8, student.getS_id ());
          pst.executeUpdate ();
    }
    
    /*
     * ����ѧ����Ϣ������������
     * s_name,s_sex,s_dp,s_major,s_class,s_state,s_entertime
     * @param  Student[]
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    /**
     * 修改
     */
    public void updateStudent (ArrayList<Student> students) throws SQLException, ReflectiveOperationException, ParseException {

        for (Student student:students
             ) {
        	updateStudent(student);
        }

        //sql���
        DBUtils.closeConn ();
    }
}
