package team543.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import team543.entity.ElectiveClass;
import team543.utils.DBUtils;
import team543.utils.MyException;

public class ElectiveClassDao {
	
	/**
	 * ����ѧ��Id��ѯ�γ�
	 * @param StudentId
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<ElectiveClass> getClassId(String StudentId) throws ReflectiveOperationException, SQLException{
		String sql = "SELECT * FROM t_electiveclass WHERE s_id='"+StudentId+"'";
		
		Connection connection = team543.utils.DBUtils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		ArrayList<ElectiveClass> list = new ArrayList<ElectiveClass>();
		
		while(rs.next()) {
			ElectiveClass electiveClass = new ElectiveClass();
			electiveClass.setE_id(rs.getString("e_id"));
			electiveClass.setC_id(rs.getString("c_id"));
			electiveClass.setS_id(rs.getString("s_id"));
			list.add(electiveClass);
		}
		DBUtils.closeConn();
		return list;
	}
	
	/**
	 * @param classtId
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<ElectiveClass> getStudentId(String classtId) throws ReflectiveOperationException, SQLException{
		String sql = "SELECT * FROM t_electiveclass WHERE c_id='"+classtId+"'";
		
		Connection connection = team543.utils.DBUtils.getConnection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		ArrayList<ElectiveClass> list = new ArrayList<ElectiveClass>();
		
		while(rs.next()) {
			ElectiveClass electiveClass = new ElectiveClass();
			electiveClass.setE_id(rs.getString("e_id"));
			electiveClass.setC_id(rs.getString("c_id"));
			electiveClass.setS_id(rs.getString("s_id"));
			list.add(electiveClass);
		}
		DBUtils.closeConn();
		return list;
	}
	
	/**
	 * ����ѡ����Ϣ
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * @throws MyException 
	 * 
	 */
	public void updateElectiveClass(String id , String studentId , String classId) throws ReflectiveOperationException, SQLException, MyException {
		
		if(!(team543.utils.Basic.isNumeric(id)&&team543.utils.Basic.isNumeric(studentId)&&team543.utils.Basic.isNumeric(classId))) {
			throw new MyException();
		}
		
		String sql = "UPDATE t_electiveclass SET c_id=? , s_id = ? WHERE e_id = ?; ";
		
		Connection connection = team543.utils.DBUtils.getConnection();
		//Ԥ����
		PreparedStatement pst = connection.prepareStatement(sql);
		//���ò���
		pst.setString(1, classId);
		pst.setString(2, studentId);
		pst.setString(3, id);
		//ִ��
//		System.out.println(pst.toString());
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
	/**
	 * ����ѡ��
	 * @param studentId
	 * @param classId
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void addElectiveClass(String studentId , String classId) throws ReflectiveOperationException, SQLException {
		String sql = "INSERT INTO t_electiveclass(s_id , c_id) VALUES(?,?); ";
		Connection connection = team543.utils.DBUtils.getConnection();
		
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, studentId);
		pst.setString(2, classId);
		
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
	/**
	 * @param eId
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 */
	public void deleteElectiveClass(String eId) throws SQLException, ReflectiveOperationException {
		String sql = "DELETE FROM  t_electiveclass WHERE e_id = ?; ";
		Connection connection = team543.utils.DBUtils.getConnection();
		
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, eId);
		
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
}
