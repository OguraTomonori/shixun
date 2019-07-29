package team543.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import team543.entity.ElectiveClass;
import team543.utils.DBUtils;

public class ElectiveClassDao {
	
	/**
	 * 根据学生Id查询课程
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
	 * 更新选课信息
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void updateElectiveClass(String id , String studentId , String classId) throws ReflectiveOperationException, SQLException {
		String sql = "UPDATE t_electiveclass SET c_id=? , s_id = ? WHERE e_id = ?; ";
		Connection connection = team543.utils.DBUtils.getConnection();
		//预编译
		PreparedStatement pst = connection.prepareStatement(sql);
		//设置参数
		pst.setString(1, classId);
		pst.setString(2, studentId);
		pst.setString(3, id);
		//执行
//		System.out.println(pst.toString());
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
	/**
	 * 插入选课
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
	
}
