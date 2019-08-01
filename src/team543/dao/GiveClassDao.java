package team543.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import team543.entity.GiveClass;
import team543.utils.DBUtils;
import team543.utils.MyException;


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
//	public void deleteGiveClass(String c_id) throws SQLException, ReflectiveOperationException {
//		String sql = "DELETE FROM t_giveclass WHERE c_id=?";
//		Connection connection = team543.utils.DBUtils.getConnection();
//		PreparedStatement pst = connection.prepareStatement(sql);
//		pst.setString(1, c_id);
//		pst.executeUpdate();
//		DBUtils.closeConn();
//	}
	
	/**
	 * @param giveclass
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 * @throws MyException 
	 */
	public void updateGiveClass(GiveClass gc) throws ReflectiveOperationException, SQLException, MyException {
		
		if(!(team543.utils.Basic.isNumeric(gc.getC_id())&&team543.utils.Basic.isNumeric(gc.getT_id()))) {
			throw new MyException();
		}
		String sql="UPDATE t_giveclass SET t_id=?,c_time=?, t_site=? WHERE c_id=?";
		Connection connection = team543.utils.DBUtils.getConnection();
		
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
	 * @throws MyException 
	 */
	public void addGiveClass(GiveClass gc) throws ReflectiveOperationException, SQLException, MyException {
		
		if(!(team543.utils.Basic.isNumeric(gc.getC_id())&&team543.utils.Basic.isNumeric(gc.getT_id()))) {
			throw new MyException();
		}
		
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
	/**
	 * @param ClassId
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public GiveClass getGiveClassByClassId(String ClassId) throws ReflectiveOperationException, SQLException {
		//��ȡ���ݿ�����
		Connection connection = team543.utils.DBUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "SELECT * FROM t_giveclass where c_id = '"+ ClassId +"';";
		
		ResultSet rs = statement.executeQuery(sql);
		GiveClass gc = new GiveClass();
		if(rs.next()) {
			gc.setC_id(rs.getString("c_id"));
			gc.setT_id(rs.getString("t_id"));
			gc.setC_time(rs.getString("c_time"));
			gc.setT_site(rs.getString("t_site"));
		}
		DBUtils.closeConn();
		return gc;
	}
	
	/**
	 * @param teacherId
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public GiveClass getGiveClassByTeacherId(String teacherId) throws ReflectiveOperationException, SQLException {
		//��ȡ���ݿ�����
		Connection connection = team543.utils.DBUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "SELECT * FROM t_giveclass where t_id = '"+ teacherId +"';";
		
		ResultSet rs = statement.executeQuery(sql);
		GiveClass gc = new GiveClass();
		if(rs.next()) {
			gc.setC_id(rs.getString("c_id"));
			gc.setT_id(rs.getString("t_id"));
			gc.setC_time(rs.getString("c_time"));
			gc.setT_site(rs.getString("t_site"));
		}
		DBUtils.closeConn();
		return gc;
	}
	/**
	 * @param id
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<GiveClass> getGiveClassById(String teacherId) throws ReflectiveOperationException, SQLException{
		//��ȡ���ݿ�����
		Connection connection = team543.utils.DBUtils.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "SELECT * FROM t_giveclass where t_id = '"+ teacherId +"';";
		
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
		//��ȡ���ݿ�����
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
