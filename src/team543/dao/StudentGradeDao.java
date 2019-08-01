package team543.dao;

import team543.entity.GiveClass;
import team543.entity.StudentGrade;
import team543.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
* ��ѯѧ���γ̳ɼ�
* ��v_student_grade��ͼ�Ĳ���
* */


public class StudentGradeDao {

    /*
    * 
    *  studentId>>>>>StudentGrade(class)
    * */

    public ArrayList<StudentGrade>  getStudentGrade(String studentId)throws SQLException, ReflectiveOperationException{

        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //sql���
        String sql="SELECT * FROM v_student_grade WHERE s_id='"+studentId+"'";
        //ִ��sql���
        ResultSet rs = statement.executeQuery(sql);
        
        ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
        while(rs.next()) {
            StudentGrade studentGrade = new StudentGrade();
            
            studentGrade.setStudentId (rs.getString ("s_id"));
            studentGrade.setStudentName (rs.getString("s_name"));
            studentGrade.setClassId (rs.getString("c_id"));
            studentGrade.setClassName (rs.getString ("c_name"));
            studentGrade.setRegularGrade (rs.getString("g_OrdTimeGra"));
            studentGrade.setTestGrade (rs.getString  ("g_ExaPapGra"));
            studentGrade.setTotalMark (rs.getString("g_evaluate"));
            studentGrades.add(studentGrade);
        }
        return studentGrades;
    }

    /*
    * ��ѯ���гɼ�
    * 0>>>>>> list studentGrades
    * 1>>>>>> list classGrades
    * */

    public ArrayList<StudentGrade> getGrades(int i,int sequence) throws ReflectiveOperationException, SQLException{
        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        
        String sql = "SELECT * FROM v_student_grade ORDER BY ";
        
        //sql���
        if (i == 0) {
            sql += " s_id ";

        }else if(i==1){
            sql += " c_id ";
        }
        
        if(sequence==1) {
        	sql+=" DESC ;";
        } else {
        	sql+=" ; ";
        }
//        System.out.println(sql);
        //ִ��sql���
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<StudentGrade> studentGrades = new ArrayList<> ();
        while(rs.next()) {
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setStudentId (rs.getString ("s_id"));
            studentGrade.setStudentName (rs.getString("s_name"));
            studentGrade.setClassId (rs.getString("c_id"));
            studentGrade.setClassName (rs.getString ("c_name"));
            studentGrade.setRegularGrade (rs.getString("g_OrdTimeGra"));
            studentGrade.setTestGrade (rs.getString  ("g_ExaPapGra"));
            studentGrade.setTotalMark (rs.getString("g_evaluate"));
            studentGrades.add(studentGrade);
        }
        DBUtils.closeConn();
        return studentGrades;
    }

    /*
    * ��ѯ�����γ̳ɼ�
    * classID>>>>>>>
    * */

    /**
     * （修改）
     * @param classId
     * @return
     * @throws SQLException
     * @throws ReflectiveOperationException
     */
    public ArrayList<StudentGrade> getClassGrade(String classId)throws SQLException, ReflectiveOperationException{

        //��ȡ���ݿ�����
        Connection connection = DBUtils.getConnection();
        //����Statement
        Statement statement = connection.createStatement();
        //sql���
        String sql="SELECT * FROM v_student_grade WHERE c_id='"+classId+"';";
        //ִ��sql���
        ResultSet rs = statement.executeQuery(sql);
        System.out.println(sql);
        ArrayList<StudentGrade> arrayList = new ArrayList<StudentGrade>();
        
        while(rs.next()) {
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setStudentId (rs.getString ("s_id"));
            studentGrade.setStudentName (rs.getString("s_name"));
            studentGrade.setClassId (rs.getString("c_id"));
            studentGrade.setClassName (rs.getString ("c_name"));
            studentGrade.setRegularGrade (rs.getString("g_OrdTimeGra"));
            studentGrade.setTestGrade (rs.getString  ("g_ExaPapGra"));
            studentGrade.setTotalMark (rs.getString("g_evaluate"));
            arrayList.add(studentGrade);
        }
        return arrayList;
    }
    
    /**
     * ͨ����ʦid��ȡ����ѧ���ĳɼ�
     * @param teacherId
     * @return
     * @throws ReflectiveOperationException
     * @throws SQLException
     */
    public ArrayList<StudentGrade> getStudentGradeByTeacher(String teacherId) throws ReflectiveOperationException, SQLException{
    	GiveClassDao giveClassDao = new GiveClassDao();
    	
    	ArrayList<GiveClass> giveClassById = giveClassDao.getGiveClassById(teacherId);
    	ArrayList<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
    	
    	for( GiveClass classId :giveClassById ) {
    		 //��ȡ���ݿ�����
            Connection connection = DBUtils.getConnection();
            //����Statement
            Statement statement = connection.createStatement();
            //sql���
            String sql="SELECT * FROM v_student_grade WHERE c_id='"+classId.getC_id()+"' ORDER BY c_id";
            //ִ��sql���
            ResultSet rs = statement.executeQuery(sql);
           
            while(rs.next()) {
                StudentGrade studentGrade = new StudentGrade();
                
                studentGrade.setStudentId (rs.getString ("s_id"));
                studentGrade.setStudentName (rs.getString("s_name"));
                studentGrade.setClassId (rs.getString("c_id"));
                studentGrade.setClassName (rs.getString ("c_name"));
                studentGrade.setRegularGrade (rs.getString("g_OrdTimeGra"));
                studentGrade.setTestGrade (rs.getString  ("g_ExaPapGra"));
                studentGrade.setTotalMark (rs.getString("g_evaluate"));
                studentGrades.add(studentGrade);
            }
    		
    	}
    	
		return studentGrades;
    }
}
