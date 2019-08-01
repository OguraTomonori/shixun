package team543.dao;

import team543.entity.Teacher;
import team543.utils.DBUtils;
import team543.utils.MyException;

import java.sql.*;
import java.util.ArrayList;

/*
 * getTeachers ��ȡ��ʦ�б�
 * getTeacherById �ɽ�ʦId��ѯ��ʦ��Ϣ
 * addTeacher �����ʦ
 * deleteTeacher ɾ����ʦ
 * updateTeacher �޸���ʦ
 */



public class TeacherDao {
 
	/*
	 *  ��ȡ��ʦ�б�
	 * @return teachers(ArrayList)
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
    public ArrayList<Teacher> getTeachers() throws ReflectiveOperationException,SQLException{
    	
    	
    	//��ȡ���ݿ�����
    	Connection connection = DBUtils.getConnection();
    	//����Statement
    	Statement statement = connection.createStatement();
    	//sql���
    	String sql="SELECT * FROM t_teacher";
    	//ִ��sql���
    	ResultSet rs = statement.executeQuery(sql);
    	ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    	while(rs.next()) {
    		Teacher teacher = new Teacher();
    		teacher.setT_id(rs.getString("t_id"));
    		teacher.setT_name(rs.getString("t_name"));
    		teacher.setT_dp(rs.getString("t_dp"));
    		teacher.setT_jobtitle(rs.getString("t_jobtitle"));
    		teacher.setT_salary(rs.getString("t_salary"));
    		teacher.setT_phonenum(rs.getString("t_phonenum"));
    		teacher.setT_email(rs.getString("t_email"));
    		teacher.setT_office(rs.getString("t_office"));
    		teacher.setT_state(rs.getString("t_state"));
    		teacher.setT_entertime(rs.getDate("t_entertime"));
    		teachers.add(teacher);
        }
    	DBUtils.closeConn();
    	return teachers;
     }
    
     /*
      * ͨ����ʦID��ѯ��ʦ��Ϣ
      * @param teacherId
      * @return teacher(class@)
      * @throws ReflectiveOperationException
      * @throws SQLException
      */
     public Teacher getTeacherById (String teacherId) throws ReflectiveOperationException,SQLException{
    	 //��ȡ���ݿ�����
    	 Connection connection = DBUtils.getConnection();
    	 //����Statement
    	 Statement statement = connection.createStatement();
    	 //sql���
    	 String sql="SELECT * FROM t_teacher WHERE t_id= '"+teacherId+"' ";
    	 //ִ��sql���
    	 ResultSet rs = statement.executeQuery(sql);
    	 if(rs.next()) {
             Teacher teacher = new Teacher();
             teacher.setT_id(rs.getString("t_id"));
             teacher.setT_name(rs.getString("t_name"));
     		 teacher.setT_dp(rs.getString("t_dp"));
     		 teacher.setT_jobtitle(rs.getString("t_jobtitle"));
     		 teacher.setT_salary(rs.getString("t_salary"));
     		 teacher.setT_phonenum(rs.getString("t_phonenum"));
     		 teacher.setT_email(rs.getString("t_email"));
     		 teacher.setT_office(rs.getString("t_office"));
     		 teacher.setT_state(rs.getString("t_state"));
     		 teacher.setT_entertime(rs.getDate("t_entertime"));
     		 return teacher;
     }
     return null;
  }   
    
   /*
    * �����ʦ��������
    * ��ʦid��������Ժϵ��ְ�ƣ�нˮ���绰���룬�������䣬�칫�ң�״̬����ְʱ��
    * @param Teacher
    * @throws SQLException
    * @throws ReflectiveOperationException
    */
    public void addTeacher(Teacher teacher) throws ReflectiveOperationException,SQLException, MyException{
    	
    	if(!(team543.utils.Basic.isNumeric(teacher.getT_id())&&team543.utils.Basic.isNumeric(teacher.getT_salary()))) {
			throw new MyException();
		}
    	
    	//������ݿ�����
    	Connection connection = DBUtils.getConnection();
    	//sql���
    	String sql="INSERT INTO t_teacher(t_id,t_name,t_dp,t_jobtitle,t_salary,t_phonenum,t_email,t_office,t_state,t_entertime) VALUES (?,?,?,?,?,?,?,?,?,?);";
    	//����prepareStatement
    	
//    	System.out.println(sql);
    	
    	PreparedStatement pst = connection.prepareStatement(sql);
    	pst.setString(1, teacher.getT_id());
    	pst.setString(2, teacher.getT_name());
    	pst.setString(3, teacher.getT_dp());
    	pst.setString(4, teacher.getT_jobtitle());
    	pst.setString(5, teacher.getT_salary());
    	pst.setString(6, teacher.getT_phonenum());
    	pst.setString(7, teacher.getT_email());
    	pst.setString(8, teacher.getT_office());
    	pst.setString(9, teacher.getT_state());
    	pst.setString(10, teacher.getT_entertime());
    	DBUtils.closeConn();
    }
    
    
    /*
     * ͨ����ʦIDɾ����ʦ��������
     * @param teacherId
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public void deleteTeacher(Integer teacherId) throws ReflectiveOperationException,SQLException{
    	//��ȡ���ݿ�����
    	Connection connection = DBUtils.getConnection();
    	//sql���
    	String sql="DELETE FROM t_teacher WHERE t_id=?";
    	//����prepareStatement
    	PreparedStatement pst = connection.prepareStatement(sql);
    	pst.setInt(1, teacherId);
    	pst.executeUpdate();
    	DBUtils.closeConn();
    }
    
    
    /*
     * ������ʦ��Ϣ������������
     * @param teacher
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public void updateTeacher(Teacher teacher) throws ReflectiveOperationException,SQLException{
    	//��ȡ���ݿ�����
    	Connection connection = DBUtils.getConnection();
    	//sql���
    	String sql="UPDATE t_teacher SET t_name=?,t_dp=?,t_jobtitle=?,t_salary=?,t_phonenum=?,t_email=?,t_office=?,t_state=?,t_entertime=? WHERE t_id=?";
    	//����prepeareStatement
    	PreparedStatement pst = connection.prepareStatement(sql);
    	pst.setString(1, teacher.getT_name());
    	pst.setString(2, teacher.getT_dp());
    	pst.setString(3, teacher.getT_jobtitle());
    	pst.setString(4, teacher.getT_salary());
    	pst.setString(5, teacher.getT_phonenum());
    	pst.setString(6, teacher.getT_email());
    	pst.setString(7, teacher.getT_office());
    	pst.setString(8, teacher.getT_state());
    	pst.setString(9, teacher.getT_entertime());
    	pst.setString(10, teacher.getT_id());
    	pst.executeUpdate();
    	DBUtils.closeConn();
    }
}