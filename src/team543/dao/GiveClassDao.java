package team543.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.GiveClass;


public class GiveClassDao {
	 /**
	  * ɾ���ڿ���Ϣ
	  *	 ����γ�id������
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
		Connection connection = utils.DBUtils.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, c_id);
		pst.executeUpdate();
	}
	
	/**
	 * @param giveclass
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void updateGiveClass(GiveClass gc) throws ReflectiveOperationException, SQLException {
		String sql="UPDATE t_giveclass SET t_id=?,c_time=?, t_stite=? WHERE c_id=?";
		Connection connection = utils.DBUtils.getConnection();
		
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, gc.getT_id());
		pst.setString(2, gc.getC_time());
		pst.setString(3, gc.getT_stite());
		pst.setString(4, gc.getC_id());
		pst.executeUpdate();
		
	}
	
	/**
	 * @param gc
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void addGiveClass(GiveClass gc) throws ReflectiveOperationException, SQLException {
		String sql="INSERT INTO t_giveclass(c_id,t_id,c_time,t_stite) VALUES(?,?,?,?)";
		Connection connection = utils.DBUtils.getConnection();
		
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, gc.getC_id());
		pst.setString(2, gc.getT_id());
		pst.setString(3, gc.getC_time());
		pst.setString(4, gc.getT_stite());
		
		pst.executeUpdate();
		
	}
	
	public List<GiveClass> getGiveClassById(String id) throws ReflectiveOperationException, SQLException{
		//��ȡ���ݿ�����
		Connection connection = utils.DBUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "SELECT * FROM t_giveclass where t_id = '"+ id +"';";
		
		ResultSet rs = statement.executeQuery(sql);
		
		List<GiveClass> giveclass = new ArrayList<GiveClass>();
		
		while(rs.next()) {
			GiveClass gc = new GiveClass();
			gc.setC_id(rs.getString("c_id"));
			gc.setT_id(rs.getString("t_id"));
			gc.setC_time(rs.getString("c_time"));
			gc.setT_stite(rs.getString("t_stite"));
			giveclass.add(gc);
		}
		return giveclass;
	}
	
	
	
	public List<GiveClass> getAllGiveClass() throws ReflectiveOperationException, SQLException{
		//��ȡ���ݿ�����
		Connection connection = utils.DBUtils.getConnection();
		
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM t_giveclass;";
		
		ResultSet rs = statement.executeQuery(sql);
		
		List<GiveClass> giveclass = new ArrayList<GiveClass>();
		
		while(rs.next()) {
			GiveClass gc = new GiveClass();
			gc.setC_id(rs.getString("c_id"));
			gc.setT_id(rs.getString("t_id"));
			gc.setC_time(rs.getString("c_time"));
			gc.setT_stite(rs.getString("t_stite"));
			giveclass.add(gc);
		}
		return giveclass;
	}

}
