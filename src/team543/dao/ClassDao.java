package team543.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import team543.utils.DBUtils;
import team543.utils.MyException;

 /**
  * �γ���Ϣ��������
 *	 @author ����С��
 * 	 @date 2019��7��30������9:09:45
 *
 */
public class ClassDao {
	/**
	 * @param c_id
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void deleteClass(String ClassId) throws ReflectiveOperationException, SQLException {
		//sql���
		String sql = "DELETE FROM t_class WHERE c_id=?";
		//��ȡ����
		Connection connection = team543.utils.DBUtils.getConnection();
		//Ԥ����
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, ClassId);
		//ִ��
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
	/**
	 * @param c
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 * @throws MyException 
	 */
	public void updateClass(team543.entity.Class c) throws SQLException, ReflectiveOperationException, MyException {
		
		if(!(team543.utils.Basic.isNumeric(c.getC_id())&&team543.utils.Basic.isNumeric(c.getC_score()))) {
			throw new MyException();
		}
		
		String sql = "UPDATE t_class SET c_name=? , c_classState=? , c_score = ?, c_openDP=? , c_percentage=?  WHERE c_id=?";
		Connection connection = team543.utils.DBUtils.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, c.getC_name());
		pst.setString(2, c.getC_classstate());
		pst.setString(3, c.getC_score());
		pst.setString(4, c.getC_opendp());
		pst.setInt(5, c.getC_percentage());
		pst.setString(6, c.getC_id());
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	
	/**
	 * @param c
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 * @throws MyException 
	 */
	public void addClass(team543.entity.Class c) throws ReflectiveOperationException, SQLException, MyException {
		if(!(team543.utils.Basic.isNumeric(c.getC_id())&&team543.utils.Basic.isNumeric(c.getC_score()))) {
			throw new MyException();
		}
		//sql���
		String sql="INSERT INTO t_class(c_id,c_name,c_classState,c_score,c_openDP,c_percentage) VALUES(?,?,?,?,?,?)";
		//��ȡ����
		Connection connection = team543.utils.DBUtils.getConnection();
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, c.getC_id());
		pst.setString(2, c.getC_name());
		pst.setString(3, c.getC_classstate());
		pst.setString(4, c.getC_score());
		pst.setString(5, c.getC_opendp());
		pst.setInt(6, c.getC_percentage());
		pst.executeUpdate();
		DBUtils.closeConn();
	}
	/**
	 * ����γ�id�Ŀγ���Ϣ����ʼ��ѧ���ɼ�ʱ��Ҫ�����쳣��
	 * @param id
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public team543.entity.Class getClassById(String Classid)  {
		String sql = "SELECT * FROM t_class where c_id = '"+ Classid +"';";
		team543.entity.Class c = null;
		
		try {
			//��ȡ����
			Connection connection = team543.utils.DBUtils.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			c = new team543.entity.Class();
			if (rs.next()) {
				c.setC_id(rs.getString("c_id"));
				c.setC_name(rs.getString("c_name"));
				c.setC_classstate(rs.getString("c_classState"));
				c.setC_score(rs.getString("c_score"));
				c.setC_opendp(rs.getString("c_openDP"));
				c.setC_percentage(rs.getInt("c_percentage"));
				return c;
			}
			//�ر�����
			DBUtils.closeConn();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
	/**
	 * ������пγ��б�
	 * @return List<entity.Class>����
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 */
	public ArrayList<team543.entity.Class> getAllClass() throws SQLException, ReflectiveOperationException{
		//sql���
		String sql = "SELECT * FROM t_class ;";
		//��ȡ����
		Connection connection = team543.utils.DBUtils.getConnection();
		Statement statement = connection.createStatement();
		//ִ��sql���
		ResultSet rs = statement.executeQuery(sql);
		ArrayList<team543.entity.Class> cl = new ArrayList<team543.entity.Class>();
		//��ֵ
		while(rs.next()) {
			team543.entity.Class c =new team543.entity.Class();
			c.setC_id(rs.getString("c_id"));
			c.setC_name(rs.getString("c_name"));
			c.setC_classstate(rs.getString("c_classState"));
			c.setC_score(rs.getString("c_score"));
			c.setC_opendp(rs.getString("c_openDP"));
			c.setC_percentage(rs.getInt("c_percentage"));
			cl.add(c);
		}
		DBUtils.closeConn();
		return cl;
	}
}
