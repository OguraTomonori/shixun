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
	 * ����ѡ����Ϣ
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void updateElectiveClass(String StudentId , String ClassId) throws ReflectiveOperationException, SQLException {
		String sql = "UPDATE t_electiveclass SET c_id=? WHERE s_id = ?; ";
		Connection connection = team543.utils.DBUtils.getConnection();
		//Ԥ����
		PreparedStatement pst = connection.prepareStatement(sql);
		//���ò���
		pst.setString(1, ClassId);
		pst.setString(2, StudentId);
		//ִ��
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
}
