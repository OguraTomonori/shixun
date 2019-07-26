package team543.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import team543.entity.GiveClass;
import team543.utils.DBUtils;


public class GiveClassDao {
	 /**
	  * 删除授课信息
	  *	 传入课程id，连接
	  * @throws ReflectiveOperationException 
	  *
	  */
		/**
		 * @param c_id
		 * @throws SQLException
		 * @throws ReflectiveOperationException
		 */
	public void deleteGiveClass(String c_id) throws SQLException, ReflectiveOperationException {
		String sql = "DELETE FROM t_giveclass WHERE c_id=?";
		Connection connection = DBUtils.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, c_id);
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
	/**
	 * @param giveclass
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void updateGiveClass(GiveClass gc) throws ReflectiveOperationException, SQLException {
		String sql="UPDATE t_giveclass SET t_id=?,c_time=?, t_site=? WHERE c_id=?";
		Connection connection = DBUtils.getConnection();
		
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, gc.getT_id());
		pst.setString(2, gc.getC_time());
		pst.setString(3, gc.getT_site());
		pst.setString(4, gc.getC_id());
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
	/**
	 * @param gc
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void addGiveClass(GiveClass gc) throws ReflectiveOperationException, SQLException {
		String sql="INSERT INTO t_giveclass(c_id,t_id,c_time,t_site) VALUES(?,?,?,?)";
		Connection connection = team543.utils.DBUtils.getConnection();
		
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, gc.getC_id());
		pst.setString(2, gc.getT_id());
		pst.setString(3, gc.getC_time());
		pst.setString(4, gc.getT_site());
		
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
	public ArrayList<GiveClass> getGiveClassById(String id) throws ReflectiveOperationException, SQLException{
		//获取数据库连接
		Connection connection = team543.utils.DBUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "SELECT * FROM t_giveclass where t_id = '"+ id +"';";
		
		ResultSet rs = statement.executeQuery(sql);
		
		ArrayList<GiveClass> giveclass = new ArrayList<GiveClass>();
		
		while(rs.next()) {
			GiveClass gc = new GiveClass();
			gc.setC_id(rs.getString("c_id"));
			gc.setT_id(rs.getString("t_id"));
			gc.setC_time(rs.getString("c_time"));
			gc.setT_site(rs.getString("t_site"));
			giveclass.add(gc);
		}
		DBUtils.closeConn();
		return giveclass;
		
	}
	
	
	
	public ArrayList<GiveClass> getAllGiveClass() throws ReflectiveOperationException, SQLException{
		//获取数据库连接
		Connection connection = team543.utils.DBUtils.getConnection();
		
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM t_giveclass;";
		
		ResultSet rs = statement.executeQuery(sql);
		
		ArrayList<GiveClass> giveclass = new ArrayList<GiveClass>();
		
		while(rs.next()) {
			GiveClass gc = new GiveClass();
			gc.setC_id(rs.getString("c_id"));
			gc.setT_id(rs.getString("t_id"));
			gc.setC_time(rs.getString("c_time"));
			gc.setT_site(rs.getString("t_site"));
			giveclass.add(gc);
		}
		DBUtils.closeConn();
		return giveclass;
	}

}
