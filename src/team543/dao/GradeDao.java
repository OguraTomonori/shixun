package team543.dao;

import team543.entity.Grade;
import team543.utils.DBUtils;
import team543.utils.MyException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
public class GradeDao {

	/*
	* ??????????
	*Grade[]>>>>>>>>
	*
	* */
    /**
     * 修改）添加判断
     * @param grades
     * @throws ReflectiveOperationException
     * @throws SQLException
     * @throws MyException
     */
    public void addGrade(Grade grade) throws ReflectiveOperationException, SQLException, MyException{
        //????????????
        Connection connection = DBUtils.getConnection();
        //sql???
        String sql = "INSERT into  t_grade (s_id, c_id, g_OrdTimeGra, g_ExaPapGra, g_evaluate) VALUES (?,?,?,?,?)";
        //????prepareStatement
        PreparedStatement pst = connection.prepareStatement (sql);
        
        if(!(team543.utils.Basic.isNumeric(grade.getS_id ())&& team543.utils.Basic.isNumeric(grade.getC_id ()))){
        	throw new MyException();
        }
        
        pst.setString (1, grade.getS_id ());
        pst.setString (2, grade.getC_id ());
        pst.setString (3, grade.getG_OrdTimGra ());
        pst.setString (4, grade.getG_ExaPopGra ());
        
        double m = (double)Integer.valueOf(grade.getG_OrdTimGra ()).intValue();
		double n =  (double)Integer.valueOf(grade.getG_ExaPopGra ()).intValue();
		double p = (double) (Integer.valueOf(new ClassDao().getClassById(grade.getC_id ()).getC_percentage()).intValue()*0.01);
		String totalMark = String.valueOf(m*p+n*(1-p));
        
        pst.setString (5, totalMark);

        pst.executeUpdate ();
        DBUtils.closeConn();
    }


    /*
    * ?????????
    * Grade[]>>>>>>>
    *
    * */
    public void updateGrade(Grade grade)throws ReflectiveOperationException, SQLException, MyException{
        Connection connection = DBUtils.getConnection ();

        if(!(team543.utils.Basic.isNumeric(grade.getG_OrdTimGra())&&team543.utils.Basic.isNumeric(grade.getG_ExaPopGra())&&team543.utils.Basic.isNumeric(grade.getS_id ())&& team543.utils.Basic.isNumeric(grade.getC_id ()))){
        	throw new MyException();
        }
        String sql = "UPDATE t_grade SET g_OrdTimeGra=?,g_ExaPapGra=?,g_evaluate=? WHERE s_id=? and c_id=?";
        //????prepareStatement
        PreparedStatement pst = connection.prepareStatement (sql);
        pst.setString (1, grade.getG_OrdTimGra ());
        pst.setString (2, grade.getG_ExaPopGra ());
        pst.setString (3, grade.getG_evaluate ());
        pst.setString (4, grade.getS_id ());
        pst.setString (5, grade.getC_id ());
        pst.executeUpdate ();

        //sql???
        DBUtils.closeConn ();
    }
    
    /**
     * @param grade
     * @throws ReflectiveOperationException
     * @throws SQLException
     * @throws MyException
     */
    public void deleteGrade(Grade grade) throws ReflectiveOperationException, SQLException, MyException {
    	  Connection connection = DBUtils.getConnection ();

          if(!(team543.utils.Basic.isNumeric(grade.getS_id ())&& team543.utils.Basic.isNumeric(grade.getC_id ()))){
          	throw new MyException();
          }
          String sql = "DELETE FROM t_grade WHERE  s_id=? and c_id=?";
          //????prepareStatement
          PreparedStatement pst = connection.prepareStatement (sql);

          pst.setString (1, grade.getS_id ());
          pst.setString (2, grade.getC_id ());
          pst.executeUpdate ();

          //sql???
          DBUtils.closeConn ();
    }


}
