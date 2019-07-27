package team543.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import team543.entity.Student;
import team543.utils.DBUtils;

 /**
 * 1.学锟斤拷匹锟戒，2.锟斤拷锟斤拷锟斤拷匹锟戒，3.锟斤拷系锟斤拷匹锟戒，4.锟斤拷锟洁级匹锟斤拷
 *	 @author 锟斤拷锟斤拷小锟斤拷
 * 	 @date 2019锟斤拷7锟斤拷24锟斤拷锟斤拷锟斤拷10:38:40
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
		
        //锟斤拷取锟斤拷锟捷匡拷锟斤拷锟斤拷
        Connection connection = DBUtils.getConnection();
        //锟斤拷锟斤拷Statement
        Statement statement = connection.createStatement();
        //执锟斤拷sql锟斤拷锟�
        ResultSet rs = statement.executeQuery(sql);
        //锟斤拷锟斤拷锟斤拷锟斤拷学锟斤拷锟斤拷锟叫憋拷
        ArrayList<Student> arrayList = new ArrayList<Student>();
        
        while(rs.next()) {
        	Student student = new Student();
        	//锟斤拷值
            student.setS_id (rs.getString ("s_id"));
            student.setS_name (rs.getString("s_name"));
            student.setS_sex (rs.getString("s_sex"));
            student.setS_dp (rs.getString ("s_dp"));
            student.setS_major (rs.getString("s_major"));
            student.setS_class (rs.getString  ("s_class"));
            student.setS_state (rs.getString("s_state"));
            student.setEntertime (rs.getString("s_entertime"));
            
            arrayList.add(student);
        	
        }
        
		return arrayList;
	}
	
	/**
	 * 锟斤拷锟斤拷锟街课筹拷锟斤拷锟狡诧拷询锟轿筹拷锟斤拷息
	 * @param className
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<team543.entity.Class> searchClassByClassName(String className) throws ReflectiveOperationException, SQLException{
		
		className = "%"+className+"%";
		
		String sql =  "SELECT * FROM t_class WHERE c_name like '"+className+"';";
		
        //锟斤拷取锟斤拷锟捷匡拷锟斤拷锟斤拷
        Connection connection = DBUtils.getConnection();
        //锟斤拷锟斤拷Statement
        Statement statement = connection.createStatement();
        //执锟斤拷sql锟斤拷锟�
        ResultSet rs = statement.executeQuery(sql);
        //锟斤拷锟斤拷锟斤拷锟斤拷学锟斤拷锟斤拷锟叫憋拷
        
        ArrayList<team543.entity.Class> cls = new ArrayList<team543.entity.Class>();
        
        while(rs.next()) {
        	team543.entity.Class c = new team543.entity.Class();
        	c.setC_id(rs.getString("c_id"));
			c.setC_name(rs.getString("c_name"));
			c.setC_classstate(rs.getString("c_classState"));
			c.setC_source(rs.getString("c_score"));
			c.setC_opendp(rs.getString("c_openDP"));
			c.setC_percentage(rs.getInt("c_percentage"));
			
			cls.add(c);
        }
		
		return cls;
		
	}
	
	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷询
	 * @param student
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<Student> searchStudent(Student student,Date firstDate,Date SecondDate) throws ReflectiveOperationException, SQLException{
		
		
		String sql = "SELECT * FROM t_student WHERE ";
		
		String sql2 = "";
		//锟斤拷锟斤拷student锟斤拷锟捷查看
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
		
		if(null!=student.getEntertime()) {
			sql2+= "AND s_entertime BETWEEN '"+firstDate.toString()+"' AND '"+SecondDate.toString()+"'";
		}
		//锟芥换锟斤拷一锟斤拷AND
		sql2 = sql2.replaceFirst("AND","");
		
		//锟斤拷锟较斤拷锟斤拷锟斤拷;
		sql =sql+sql2+";";
		System.out.println(sql);
        //锟斤拷取锟斤拷锟捷匡拷锟斤拷锟斤拷
        Connection connection = DBUtils.getConnection();
        //锟斤拷锟斤拷Statement
        Statement statement = connection.createStatement();
        //执锟斤拷sql锟斤拷锟�
        ResultSet rs = statement.executeQuery(sql);
        //锟斤拷锟斤拷锟斤拷锟斤拷学锟斤拷锟斤拷锟叫憋拷
        ArrayList<Student> arrayList = new ArrayList<Student>();
        
        while(rs.next()) {
        	Student s = new Student();
        	//锟斤拷值
            s.setS_id (rs.getString ("s_id"));
            s.setS_name (rs.getString("s_name"));
            s.setS_sex (rs.getString("s_sex"));
            s.setS_dp (rs.getString ("s_dp"));
            s.setS_major (rs.getString("s_major"));
            s.setS_class (rs.getString  ("s_class"));
            s.setS_state (rs.getString("s_state"));
            s.setEntertime (rs.getString("s_entertime"));
            
            arrayList.add(s);
        	
        }
		
		
		return arrayList;
	}

}
