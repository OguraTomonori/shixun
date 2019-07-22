package team543.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClassDao {
	/**
	 * @param c_id
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void deleteClass(String c_id) throws ReflectiveOperationException, SQLException {
		String sql = "DELETE FROM t_class WHERE c_id=?";
		Connection connection = team543.utils.DBUtils.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, c_id);
		pst.executeUpdate();
	}
	
	/**
	 * @param c
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 */
	public void updateClass(team543.entity.Class c) throws SQLException, ReflectiveOperationException {
		String sql = "UPDATE t_class SET c_name=? , c_classState=? , c_score = ?, c_openDP=? , c_percentage=?  WHERE c_id=?";
		Connection connection = team543.utils.DBUtils.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, c.getC_name());
		pst.setString(2, c.getC_classstate());
		pst.setString(3, c.getC_source());
		pst.setString(4, c.getC_opendp());
		pst.setInt(5, c.getC_percentage());
		pst.setString(6, c.getC_id());
		pst.executeUpdate();
		
	}
	
	/**
	 * @param c
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void addClass(team543.entity.Class c) throws ReflectiveOperationException, SQLException {
		String sql="INSERT INTO t_giveclass(c_id,c_name,c_classState,c_score,c_openDP,c_percentage) VALUES(?,?,?,?,?,?)";
		
		Connection connection = team543.utils.DBUtils.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, c.getC_id());
		pst.setString(2, c.getC_name());
		pst.setString(3, c.getC_classstate());
		pst.setString(4, c.getC_source());
		pst.setString(5, c.getC_opendp());
		pst.setInt(6, c.getC_percentage());
		pst.executeUpdate();
	}
	/**
	 * ����γ�id�Ŀγ���Ϣ
	 * @param id
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public team543.entity.Class getClassById(String id) throws ReflectiveOperationException, SQLException {
		String sql = "SELECT * FROM t_class where t_id = '"+ id +"';";
		
		Connection connection = team543.utils.DBUtils.getConnection();
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery(sql);
		team543.entity.Class c = null;
		
		if(rs.next()) {
			c.setC_id(rs.getString("c_id"));
			c.setC_name(rs.getString("c_name"));
			c.setC_classstate(rs.getString("c_classState"));
			c.setC_source(rs.getString("c_source"));
			c.setC_opendp(rs.getString("c_openDP"));
			c.setC_percentage(rs.getInt("C_percentage"));
			return c;
		}
		return c;
	}
	/**
	 * @return List<entity.Class>����
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 */
	public List<team543.entity.Class> getAllClass() throws SQLException, ReflectiveOperationException{
		String sql = "SELECT * FROM t_class ;";
		
		Connection connection = team543.utils.DBUtils.getConnection();
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery(sql);
		List<team543.entity.Class> cl = null;
		
		while(rs.next()) {
			team543.entity.Class c =new team543.entity.Class();
			c.setC_id(rs.getString("c_id"));
			c.setC_name(rs.getString("c_name"));
			c.setC_classstate(rs.getString("c_classState"));
			c.setC_source(rs.getString("c_source"));
			c.setC_opendp(rs.getString("c_openDP"));
			c.setC_percentage(rs.getInt("C_percentage"));
			cl.add(c);
		}
		return cl;
	}
}
