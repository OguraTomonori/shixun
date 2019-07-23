package team543.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Grade;
import entity.Student;

public class studentAction {
	/**
	 * ��ȡѧ����Ϣ
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public static Student getStudentInfo(String id) throws ReflectiveOperationException, SQLException {
		if(utils.Basic.isNumeric(id)) {
			return dao.StudentDao.getStudentById(id);
			//
		}else {
			return null;
		}
	}
	
	/**
	 * ��ȡѧ��ѡ����Ϣ
	 * @param c_id
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public static ArrayList<entity.Class> getStudentClass(String c_id) throws ReflectiveOperationException, SQLException{
		String sql = "SELECT * FROM t_electiveclass WHERE s_id='"+c_id+"'";
		Connection connection = utils.DBUtils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		ArrayList<entity.Class> cl = new ArrayList<entity.Class>();
		
		//rs��ѧ��ѡ�γ̵�id
		while(rs.next()) {
			String sql1 = "SELECT * FROM t_class WHERE c_id='"+rs.getString("c_id")+"';";
			Statement statement1 = connection.createStatement();
			ResultSet rs1 = statement1.executeQuery(sql1);
			//rs1���ݿγ�idѡ���Ŀγ���Ϣ
			while (rs1.next()) {
				entity.Class c = new entity.Class();
				c.setC_id(rs1.getString("c_id"));
				c.setC_name(rs1.getString("c_name"));
				c.setC_classstate(rs1.getString("c_classState"));
				c.setC_source(rs1.getString("c_score"));
				c.setC_opendp(rs1.getString("c_openDP"));
				c.setC_percentage(rs1.getInt("c_percentage"));
				cl.add(c);
			}
		}
		
		return cl;
	}
	
	/**
	 * ��ȡѧ���ɼ��б�
	 * @param s_id
	 * @return
	 */
	public ArrayList<Grade> getGrade(String s_id){
		
		return null;
	}

}
