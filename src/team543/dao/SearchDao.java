package team543.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import team543.entity.Student;
import team543.entity.Teacher;
import team543.utils.DBUtils;

 /**
 * 1.学号匹配，2.按姓名匹配，3.按系别匹配，4.按班级匹配
 *	 @author 公子小白
 * 	 @date 2019年7月24日上午10:38:40
 *
 */
public class SearchDao {
	
	public ArrayList<Student> searchStudent(int num , String str) throws ReflectiveOperationException, SQLException {
		
		str = "%"+str+"%";
		String sql = null;
		switch (num) {
		case 1: sql = "SELECT * FROM t_student WHERE s_id like '"+str+"';";
			break;
		case 2: sql = "SELECT * FROM t_student WHERE s_name like '"+str+"';";
			break;
		case 3: sql = "SELECT * FROM t_student WHERE s_dp like '"+str+"';";
			break;
		case 4: sql = "SELECT * FROM t_student WHERE s_class like '"+str+"';";

		default:
			break;
		}
		
        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //创建Statement
        Statement statement = connection.createStatement();
        //执行sql语句
        ResultSet rs = statement.executeQuery(sql);
        //创建保存学生的列表
        ArrayList<Student> arrayList = new ArrayList<Student>();
        
        while(rs.next()) {
        	Student student = new Student();
        	//赋值
            student.setS_id (rs.getString ("s_id"));
            student.setS_name (rs.getString("s_name"));
            student.setS_sex (rs.getString("s_sex"));
            student.setS_dp (rs.getString ("s_dp"));
            student.setS_major (rs.getString("s_major"));
            student.setS_class (rs.getString  ("s_class"));
            student.setS_state (rs.getString("s_state"));
            student.setEntertime (rs.getDate("s_entertime"));
            
            arrayList.add(student);
        	
        }
        
		return arrayList;
	}
	
	/**
	 * 按部分课程名称查询课程信息
	 * @param className
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<team543.entity.Class> searchClassByClassName(String className) throws ReflectiveOperationException, SQLException{
		
		className = "%"+className+"%";
		
		String sql =  "SELECT * FROM t_class WHERE c_name like '"+className+"';";
		
        //获取数据库连接
        Connection connection = DBUtils.getConnection();	
        //创建Statement
        Statement statement = connection.createStatement();
        //执行sql语句
        ResultSet rs = statement.executeQuery(sql);
        //创建保存学生的列表
        
        ArrayList<team543.entity.Class> cls = new ArrayList<team543.entity.Class>();
        
        while(rs.next()) {
        	team543.entity.Class c = new team543.entity.Class();
        	c.setC_id(rs.getString("c_id"));
			c.setC_name(rs.getString("c_name"));
			c.setC_classstate(rs.getString("c_classState"));
			c.setC_score(rs.getString("c_score"));
			c.setC_opendp(rs.getString("c_openDP"));
			c.setC_percentage(rs.getInt("c_percentage"));
			
			cls.add(c);
        }
		
		return cls;
	}
	
	/**
	 * 按各种条件查询，不能全为空
	 * @param student
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<Student> searchStudent(Student student,Date firstDate,Date secondDate) throws ReflectiveOperationException, SQLException{
		
		
		String sql = "SELECT * FROM t_student WHERE ";
		
		String sql2 = "";
		//根据student内容查看
		if(null!=student.getS_id()) {
			sql2 += "AND s_id LIKE '%"+student.getS_id()+"%' ";
		}
		
		if (null!=student.getS_name()) {
			sql2+="AND s_name LIKE '%"+student.getS_name()+"%' ";
		}
		
		if(null!=student.getS_sex()) {
			sql2+="AND s_sex LIKE  '%"+student.getS_sex()+"%' ";
		}
		
		if(null!=student.getS_class()) {
			sql2+="AND s_class  LIKE '%"+student.getS_class()+"%' ";
		}
		
		if(null!=student.getS_state()) {
			sql2+="AND s_state LIKE '%"+student.getS_state()+"%' ";
		}
		
		if(null!=student.getS_dp()) {
			sql2+="AND s_dp LIKE   '%"+student.getS_dp()+"%' ";
		}
		
		if(null!=student.getS_major()) {
			sql2+="AND s_major LIKE '%"+student.getS_major()+"%' ";
		}
		
		if(null!=firstDate&&null!=secondDate) {
			sql2+= "AND s_entertime BETWEEN '"+timeFormat(firstDate)+"' AND '"+timeFormat(secondDate)+"'";
		}
		//替换第一个AND
		sql2 = sql2.replaceFirst("AND","");
		
		//加上结束的;
		sql =sql+sql2+";";
//		System.out.println(sql);
        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //创建Statement
        Statement statement = connection.createStatement();
        //执行sql语句
        ResultSet rs = statement.executeQuery(sql);
        //创建保存学生的列表
        ArrayList<Student> arrayList = new ArrayList<Student>();
        
        while(rs.next()) {
        	Student s = new Student();
        	//赋值
            s.setS_id (rs.getString ("s_id"));
            s.setS_name (rs.getString("s_name"));
            s.setS_sex (rs.getString("s_sex"));
            s.setS_dp (rs.getString ("s_dp"));
            s.setS_major (rs.getString("s_major"));
            s.setS_class (rs.getString  ("s_class"));
            s.setS_state (rs.getString("s_state"));
            
            java.util.Date utilDate = new java.util.Date (rs.getDate("s_entertime").getTime());
            
//            System.out.println(utilDate);
            
            s.setEntertime (utilDate);
            
//            s.setEntertime (rs.getDate("s_entertime"));
            
            arrayList.add(s);
        	
        }
		
		return arrayList;
	}
	
	/**
	 * 返回格式化后的时间
	 * @param date
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	
	public ArrayList<Teacher> searchTeacher(Teacher teacher , Date firstDate,Date secondDate) throws SQLException, ReflectiveOperationException{

		String sql = "SELECT * FROM t_teacher WHERE ";
		
		String sql2 = "";
		//根据student内容查看
		if(null!=teacher.getT_id()) {
			sql2 += "AND t_id LIKE '%"+teacher.getT_id()+"%' ";
		}
		
		if (null!=teacher.getT_name()) {
			sql2+="AND t_name LIKE '%"+teacher.getT_name()+"%' ";
		}
		
		if(null!=teacher.getT_dp()) {
			sql2+="AND t_dp LIKE  '%"+teacher.getT_dp()+"%' ";
		}
		
		if(null!=teacher.getT_jobtitle()) {
			sql2+="AND t_jobtitle  LIKE '%"+teacher.getT_jobtitle()+"%' ";
		}
		
		if(null!=teacher.getT_office()) {
			sql2+="AND t_office LIKE '%"+teacher.getT_office()+"%' ";
		}
		
		if(null!=teacher.getT_state()) {
			sql2+="AND t_state LIKE   '%"+teacher.getT_state()+"%' ";
		}
		
		if(null!=firstDate&&null!=secondDate) {
			sql2+= "AND t_entertime BETWEEN '"+timeFormat(firstDate)+"' AND '"+timeFormat(secondDate)+"'";
		}
		//替换第一个AND
		sql2 = sql2.replaceFirst("AND","");
		//加上结束的;
		sql =sql+sql2+";";
//		System.out.println(sql);
        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //创建Statement
        Statement statement = connection.createStatement();
        //执行sql语句
        ResultSet rs = statement.executeQuery(sql);
        //创建保存学生的列表
        ArrayList<Teacher> arrayList = new ArrayList<Teacher>();
        
        while(rs.next()) {
        	Teacher t = new Teacher();
        	//赋值
            t.setT_id(rs.getString ("t_id"));
            t.setT_name(rs.getString("t_name"));
            t.setT_dp(rs.getString("t_jobtitle"));
            t.setT_salary(rs.getString("t_salary"));
            t.setT_phonenum(rs.getString("t_phonenum"));
            t.setT_email(rs.getString("t_email"));
            t.setT_office(rs.getString("t_office"));
            t.setT_state(rs.getString("t_state"));
            t.setT_entertime(rs.getDate("t_entertime"));
//            java.util.Date utilDate = new java.util.Date (rs.getDate("s_entertime").getTime());
//            
////            System.out.println(utilDate);
//            
//            s.setEntertime (utilDate);
            
//            s.setEntertime (rs.getDate("s_entertime"));
            arrayList.add(t);
        }
		return arrayList;
	}
	
	public ArrayList<team543.entity.Class> searchClass(team543.entity.Class cl) throws ReflectiveOperationException, SQLException{
		String sql = "SELECT * FROM t_class WHERE ";
		
		String sql2 = "";
		//根据student内容查看
		if(null!=cl.getC_id()) {
			sql2 += "AND c_id LIKE '%"+cl.getC_id()+"%' ";
		}
		
		if (null!=cl.getC_name()) {
			sql2+="AND c_name LIKE '%"+cl.getC_name()+"%' ";
		}
		
		if(null!=cl.getC_classstate()) {
			sql2+="AND c_classstate LIKE  '%"+cl.getC_classstate()+"%' ";
		}
		
		if(null!=cl.getC_score()) {
			sql2+="AND c_score  LIKE '%"+cl.getC_score()+"%' ";
		}
		
		if(null!=cl.getC_opendp()) {
			sql2+="AND c_opendp LIKE '%"+cl.getC_opendp()+"%' ";
		}
		//替换第一个AND
		sql2 = sql2.replaceFirst("AND","");
		//加上结束的;
		sql =sql+sql2+";";
//		System.out.println(sql);
        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //创建Statement
        Statement statement = connection.createStatement();
        //执行sql语句
        ResultSet rs = statement.executeQuery(sql);
        //创建保存学生的列表
        ArrayList<team543.entity.Class> arrayList = new ArrayList<team543.entity.Class>();
        
        while(rs.next()) {
        	team543.entity.Class  c = new team543.entity.Class ();
        	//赋值
            c.setC_id(rs.getString("c_id"));
            c.setC_name(rs.getString("c_name"));
            c.setC_classstate(rs.getString("c_classState"));
            c.setC_opendp(rs.getString("c_opendp"));
            c.setC_score(rs.getString("c_score"));
            c.setC_percentage(Integer.valueOf(rs.getString("c_percentage")).intValue());
//            java.util.Date utilDate = new java.util.Date (rs.getDate("s_entertime").getTime());
//            
////            System.out.println(utilDate);
//            
//            s.setEntertime (utilDate);
            
//            s.setEntertime (rs.getDate("s_entertime"));
            arrayList.add(c);
        }
		return arrayList;
	}

	public static String  timeFormat(Date date){
		return DateFormat.getDateInstance(DateFormat.MEDIUM).format(date);
	}
//	public static void main(String[] args) {
//		String timeFormat = timeFormat(new Date());
//		System.out.println(timeFormat);
//	}
}
