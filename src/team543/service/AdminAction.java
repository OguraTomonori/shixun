package team543.service;
//管理员
//查询学生信息
//查询教师信息
//查询课程信息
//查询成绩信息
//修改学生信息
//修改教师信息
//修改选课信息
//修改成绩信息

import java.sql.SQLException;
import java.util.ArrayList;

import team543.dao.ClassDao;
import team543.dao.StudentDao;
import team543.entity.*;

public class AdminAction {
	StudentDao studentDao = new StudentDao();
	ClassDao classDao = new ClassDao();
	StudentDao student = new StudentDao();
	/**
	 * 获取学生信息
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public ArrayList<Student> getStudent() throws ReflectiveOperationException, SQLException {
		return studentDao.getStudents();
	}
	
	/**
	 * 获取教师信息
	 * @return
	 */
	public ArrayList<Teacher> getTeacher() {
		return null;
		
	}
	
	/**
	 * 获取课程信息
	 * @return
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 */
	public ArrayList<team543.entity.Class> getClassInfo() throws SQLException, ReflectiveOperationException{
		return classDao.getAllClass();
		
	}
	
	/**
	 * 获取成绩信息
	 * @return
	 */
	public ArrayList<Grade> getGrade(){
		return null;
	}
	
	/**
	 * 修改学生信息
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 * 
	 */
	public void updateStudent(Student[] StudentId) throws SQLException, ReflectiveOperationException {
		student.updateStudent(StudentId);
	}
	
	/**
	 * 更新教师信息
	 * 
	 */
	public void updateTeacher() {
		
	}
	
	/**
	 * 修改选课信息
	 * 
	 */
	public void updateElectiveClass() {
		
	}
	
	/**
	 * 修改成绩信息
	 * 
	 */
	public void updateGrade() {
		
	}

}
