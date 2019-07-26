package team543.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.ElectiveClass;
import utils.DBUtils;

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
		
		Connection connection = utils.DBUtils.getConnection();
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
	public void updateElectiveClass(String StudentId , String ClassId) throws ReflectiveOperationException, SQLException {
		String sql = "UPDATE t_electiveclass SET c_id=? WHERE s_id = ?; ";
		Connection connection = utils.DBUtils.getConnection();
		//预编译
		PreparedStatement pst = connection.prepareStatement(sql);
		//设置参数
		pst.setString(1, ClassId);
		pst.setString(2, StudentId);
		//执行
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
}
