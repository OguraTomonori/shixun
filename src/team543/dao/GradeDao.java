package team543.dao;

import team543.entity.GiveClass;
import team543.entity.Grade;
import team543.utils.DBUtils;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class GradeDao {

/*
* 增加学生成绩
*Grade[]>>>>>>>>
*
* */
    public void addGrade(Grade[] g) throws ReflectiveOperationException, SQLException{
        //获取数据库连接
        Connection connection = DBUtils.getConnection();
        //sql语句
        for (Grade grade:g
        ) {
            String sql = "INSERT into  t_grade (s_id, c_id, g_OrdTimeGra, g_ExaPapGra, g_evaluate) VALUES (?,?,?,?,?)";
            //创建prepareStatement
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
    * 更新成绩信息
    * Grade[]>>>>>>>
    *
    * */
    public void updateGrade(Grade[] g)throws ReflectiveOperationException, SQLException{
        Connection connection = DBUtils.getConnection ();

        for (Grade grade:g
        ) {
            String sql = "UPDATE t_grade SET g_OrdTimeGra=?,g_ExaPapGra=?,g_evaluate=? WHERE s_id=? and c_id=?";
            //创建prepareStatement
            PreparedStatement pst = connection.prepareStatement (sql);
            pst.setString (1, grade.getG_OrdTimGra ());
            pst.setString (2, grade.getG_ExaPopGra ());
            pst.setString (3, grade.getG_evaluate ());
            pst.setString (4, grade.getS_id ());
            pst.setString (5, grade.getC_id ());
            pst.executeUpdate ();
        }
        //sql语句
        DBUtils.closeConn ();
    }



}
