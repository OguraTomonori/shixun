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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import team543.dao.ClassDao;
import team543.dao.ElectiveClassDao;
import team543.dao.SearchDao;
import team543.dao.StudentDao;
import team543.dao.StudentGradeDao;
import team543.dao.TeacherDao;
import team543.entity.*;

public class AdminAction {
	StudentDao studentDao = new StudentDao();
	ClassDao classDao = new ClassDao();
	StudentDao student = new StudentDao();
	StudentGradeDao studentGradeDao = new StudentGradeDao();
	ElectiveClassDao electiveClassDao = new ElectiveClassDao();
	TeacherDao teacherDao = new TeacherDao();
	SearchDao searchDao = new SearchDao();
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
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<Teacher> getTeacher() throws ReflectiveOperationException, SQLException {
		return teacherDao.getTeachers();
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
	 * 
	 * 1.sort by student
	 * 2.sort by classGrade
	 * 1.DESC 降序
	 * 2.ASC 升序
	 * 获取成绩信息
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<StudentGrade> getGrade(int sort , int sequence) throws ReflectiveOperationException, SQLException{		
		return studentGradeDao.getGrades(sort,sequence);
	}
	
	/**
	 * 修改学生信息
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 * @throws ParseException 
	 * 
	 */
	public void updateStudent(ArrayList<Student> students) throws SQLException, ReflectiveOperationException, ParseException {
		student.updateStudent(students);
	}
	
	/**
	 * 更新教师信息
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void updateTeacher(Teacher teacher) throws ReflectiveOperationException, SQLException {
		teacherDao.updateTeacher(teacher);
	}
	
	/**
	 * 按选课id修改选课信息
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void updateElectiveClass(String id ,String StudentId , String ClassId) throws ReflectiveOperationException, SQLException {
		electiveClassDao.updateElectiveClass(id,StudentId, ClassId);
	}
	
	/**
	 * 修改成绩信息
	 * 
	 */
	public void updateGrade() {
		
	}
	
	/**
	 * 搜索学生
	 * @param student
	 * @param firstDate
	 * @param secondDate
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<Student> srarchStudent(Student student,Date firstDate,Date secondDate) throws ReflectiveOperationException, SQLException{
		return searchDao.searchStudent(student, firstDate, secondDate);
	}
	
	/**
	 * 搜索教师
	 * @param student
	 * @param firstDate
	 * @param secondDate
	 * @return
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 */
	public ArrayList<Teacher> searchTeacher(Teacher teacher,Date firstDate,Date secondDate) throws SQLException, ReflectiveOperationException{
		return searchDao.searchTeacher(teacher, firstDate, secondDate);
	}
	
}
