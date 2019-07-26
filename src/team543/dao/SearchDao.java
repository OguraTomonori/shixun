package team543.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import entity.Student;
import utils.DBUtils;

 /**
 * 1.ѧ��ƥ�䣬2.������ƥ�䣬3.��ϵ��ƥ�䣬4.���༶ƥ��
 *	 @author ����С��
 * 	 @date 2019��7��24������10:38:40
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
		
        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //ִ��sql���
        ResultSet rs = statement.executeQuery(sql);
        //��������ѧ�����б�
        ArrayList<Student> arrayList = new ArrayList<Student>();
        
        while(rs.next()) {
        	Student student = new Student();
        	//��ֵ
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
	 * �����ֿγ����Ʋ�ѯ�γ���Ϣ
	 * @param className
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<entity.Class> searchClassByClassName(String className) throws ReflectiveOperationException, SQLException{
		
		className = "%"+className+"%";
		
		String sql =  "SELECT * FROM t_class WHERE c_name like '"+className+"';";
		
        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //ִ��sql���
        ResultSet rs = statement.executeQuery(sql);
        //��������ѧ�����б�
        
        ArrayList<entity.Class> cls = new ArrayList<entity.Class>();
        
        while(rs.next()) {
        	entity.Class c = new entity.Class();
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
	 * ������������ѯ
	 * @param student
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<Student> searchStudent(Student student,Date firstDate,Date SecondDate) throws ReflectiveOperationException, SQLException{
		
		
		String sql = "SELECT * FROM t_student WHERE ";
		
		String sql2 = "";
		//����student���ݲ鿴
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
		//�滻��һ��AND
		sql2 = sql2.replaceFirst("AND","");
		
		//���Ͻ�����;
		sql =sql+sql2+";";
		System.out.println(sql);
        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //ִ��sql���
        ResultSet rs = statement.executeQuery(sql);
        //��������ѧ�����б�
        ArrayList<Student> arrayList = new ArrayList<Student>();
        
        while(rs.next()) {
        	Student s = new Student();
        	//��ֵ
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
