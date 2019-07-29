package team543.dao;

import team543.entity.Teacher;
import team543.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * getTeachers 获取老师列表
 * getTeacherById 由教师Id查询教师信息
 * addTeacher 添加老师
 * deleteTeacher 删除老师
 * updateTeacher 修改老师
 */



public class TeacherDao {
 
	/*
	 *  获取老师列表
	 * @return teachers(ArrayList)
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
    public ArrayList<Teacher> getTeachers() throws ReflectiveOperationException,SQLException{
    	//获取数据库连接
    	Connection connection = DBUtils.getConnection();
    	//创建Statement
    	Statement statement = connection.createStatement();
    	//sql语句
    	String sql="SELECT * FROM t_teacher";
    	//执行sql语句
    	ResultSet rs = statement.executeQuery(sql);
    	ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    	while(rs.next()) {
    		Teacher teacher = new Teacher();
    		teacher.setT_id(rs.getString("t_id"));
    		teacher.setT_name(rs.getString("t_name"));
    		teacher.setT_dp(rs.getString("t_dp"));
    		teacher.setT_jobtitle(rs.getString("t_jobtitle"));
    		teacher.setT_salay(rs.getString("t_salary"));
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
      * 通过老师ID查询老师信息
      * @param teacherId
      * @return teacher(class@)
      * @throws ReflectiveOperationException
      * @throws SQLException
      */
     public Teacher getTeacherById (String teacherId) throws ReflectiveOperationException,SQLException{
    	 //获取数据库连接
    	 Connection connection = DBUtils.getConnection();
    	 //创建Statement
    	 Statement statement = connection.createStatement();
    	 //sql语句
    	 String sql="SELECT * FROM t_teacher WHERE t_id= '"+teacherId+"' ";
    	 //执行sql语句
    	 ResultSet rs = statement.executeQuery(sql);
    	 if(rs.next()) {
             Teacher teacher = new Teacher();
             teacher.setT_id(rs.getString("t_id"));
             teacher.setT_name(rs.getString("t_name"));
     		 teacher.setT_dp(rs.getString("t_dp"));
     		 teacher.setT_jobtitle(rs.getString("t_jobtitle"));
     		 teacher.setT_salay(rs.getString("t_salary"));
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
    * 添加老师（批量）
    * 教师id，姓名，院系，职称，薪水，电话号码，电子邮箱，办公室，状态，入职时间
    * @param Teacher
    * @throws SQLException
    * @throws ReflectiveOperationException
    */
    public void addTeacher(Teacher teacher) throws ReflectiveOperationException,SQLException{
    	//获得数据库连接
    	Connection connection = DBUtils.getConnection();
    	//sql语句
    	String sql="INSERT INTO t_teacher(t_id,t_name,t_dp,t_jobtitle,t_salay,t_phonenum,t_email,t_office,t_state,t_entertime) VALUES (?,?,?,?,?,?,?,?,?,?)";
    	//创建prepareStatement
    	PreparedStatement pst = connection.prepareStatement(sql);
    	pst.setString(1, teacher.getT_id());
    	pst.setString(2, teacher.getT_name());
    	pst.setString(3, teacher.getT_dp());
    	pst.setString(4, teacher.getT_jobtitle());
    	pst.setString(5, teacher.getT_salay());
    	pst.setString(6, teacher.getT_phonenum());
    	pst.setString(7, teacher.getT_email());
    	pst.setString(8, teacher.getT_office());
    	pst.setString(9, teacher.getT_state());
    	pst.setString(10, teacher.getT_entertime());
    	DBUtils.closeConn();
    }
    
    
    /*
     * 通过老师ID删除老师（批量）
     * @param teacherId
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public void deleteTeacher(Integer teacherId) throws ReflectiveOperationException,SQLException{
    	//获取数据库连接
    	Connection connection = DBUtils.getConnection();
    	//sql语句
    	String sql="DELETE FROM t_teacher WHERE t_id=?";
    	//创建prepareStatement
    	PreparedStatement pst = connection.prepareStatement(sql);
    	pst.setInt(1, teacherId);
    	pst.executeUpdate();
    	DBUtils.closeConn();
    }
    
    
    /*
     * 更新老师信息（批量操作）
     * @param teacher
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public void updateTeacher(Teacher teacher) throws ReflectiveOperationException,SQLException{
    	//获取数据库连接
    	Connection connection = DBUtils.getConnection();
    	//sql语句
    	String sql="UPDATE t_teacher SET t_name=?,t_dp=?,t_jobtitle=?,t_salary=?,t_phonenum=?,t_email=?,t_office=?,t_state=?,t_entertime=? WHERE t_id=?";
    	//创建prepeareStatement
    	PreparedStatement pst = connection.prepareStatement(sql);
    	pst.setString(1, teacher.getT_name());
    	pst.setString(2, teacher.getT_dp());
    	pst.setString(3, teacher.getT_jobtitle());
    	pst.setString(4, teacher.getT_salay());
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