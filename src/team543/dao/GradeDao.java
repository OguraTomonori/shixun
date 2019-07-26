package team543.dao;

import team543.entity.Grade;
import team543.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class GradeDao {

/*
* ??????????
*Grade[]>>>>>>>>
*
* */
    public void addGrade(Grade[] g) throws ReflectiveOperationException, SQLException{
        //????????????
        Connection connection = DBUtils.getConnection();
        //sql???
        for (Grade grade:g
        ) {
            String sql = "INSERT into  t_grade (s_id, c_id, g_OrdTimeGra, g_ExaPapGra, g_evaluate) VALUES (?,?,?,?,?)";
            //????prepareStatement
            PreparedStatement pst = connection.prepareStatement (sql);
            pst.setString (1, grade.getS_id ());
            pst.setString (2, grade.getC_id ());
            pst.setString (3, grade.getG_OrdTimGra ());
            pst.setString (4, grade.getG_ExaPopGra ());
            pst.setString (5, grade.getG_evaluate ());
            pst.executeUpdate ();
        }
        DBUtils.closeConn();
    }


    /*
    * ?????????
    * Grade[]>>>>>>>
    *
    * */
    public void updateGrade(Grade[] g)throws ReflectiveOperationException, SQLException{
        Connection connection = DBUtils.getConnection ();

        for (Grade grade:g
        ) {
            String sql = "UPDATE t_grade SET g_OrdTimeGra=?,g_ExaPapGra=?,g_evaluate=? WHERE s_id=? and c_id=?";
            //????prepareStatement
            PreparedStatement pst = connection.prepareStatement (sql);
            pst.setString (1, grade.getG_OrdTimGra ());
            pst.setString (2, grade.getG_ExaPopGra ());
            pst.setString (3, grade.getG_evaluate ());
            pst.setString (4, grade.getS_id ());
            pst.setString (5, grade.getC_id ());
            pst.executeUpdate ();
        }

        //sql???
        DBUtils.closeConn ();
    }



}
