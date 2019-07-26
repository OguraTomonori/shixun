package team543.service;

import java.sql.SQLException;
import java.util.ArrayList;

import team543.dao.*;
import team543.entity.ElectiveClass;
import team543.entity.Student;
import team543.entity.StudentGrade;

public class studentAction {
	StudentDao studentDao = new StudentDao();
	StudentGradeDao studentGradeDao = new StudentGradeDao();
	ElectiveClassDao electiveClassDao = new ElectiveClassDao();
	/**
	 * 获取学生信息
	 * @return
	 * @throws SQLException
	 * @throws ReflectiveOperationException 
	 */
	public  Student getStudentInfo(String id) throws ReflectiveOperationException, SQLException {
		//判断id是否都为数字
		if(team543.utils.Basic.isNumeric(id)) {
			return studentDao.getStudentById(id);
		}else {
			return null;
		}
	}
	
	/**
	 * 获取学生选课信息
	 * @param c_id
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public  ArrayList<team543.entity.Class> getStudentClass(String c_id) throws ReflectiveOperationException, SQLException{
		ElectiveClassDao electiveClassDao = new ElectiveClassDao();
		ClassDao classDao = new ClassDao();
		//创建保存学生选课的课程id的列表
		ArrayList<String> list = new ArrayList<String>();
		
		ArrayList<ElectiveClass> ec = new ArrayList<ElectiveClass>();
		
		ec = electiveClassDao.getClassId(c_id);
		//调用函数获取
//		System.out.println(ec.get(0).getC_id());
//		String str = "1" ; 
		for(int i = 0 ; i < ec.size() ; i++) {

			list.add(ec.get(i).getC_id());
		
		}
		//创建保存课程信息的列表
		ArrayList<team543.entity.Class> cl = new ArrayList<team543.entity.Class>();
		
//		System.out.println(list);
		//该学生选课程的id
		for(int i = 0 ; i<list.size();i++) {
			//查询课程信息
			cl.add(classDao.getClassById(list.get(i)));
		}
		return cl;
	}

	/**
	 * 获取学生成绩列表
	 * @param s_id
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
<<<<<<< HEAD
	public ArrayList<StudentGrade> getGrade(String s_id) throws ReflectiveOperationException, SQLException{
		return studentGradeDao.getStudentGrade(s_id);
	}
	
	public void studentElectiveClass(String studentId , String classId) throws ReflectiveOperationException, SQLException {
		electiveClassDao.addElectiveClass(studentId, classId);
=======
	public ArrayList<String> getGrade(String s_id) throws ReflectiveOperationException, SQLException{
		
		return null;
>>>>>>> 2436d5599ddf92e7181c58371cf287e93d41f781
	}

}
