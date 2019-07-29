package team543.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import team543.dao.ClassDao;
import team543.dao.GiveClassDao;
import team543.dao.GradeDao;
import team543.dao.SearchDao;
import team543.dao.StudentGradeDao;
import team543.dao.StudentTeacherDao;
import team543.dao.TeacherDao;
import team543.entity.GiveClass;
import team543.entity.Grade;
import team543.entity.Student;
import team543.entity.StudentGrade;
import team543.entity.StudentTeacher;
import team543.entity.Teacher;

public class TeacherAction {
	
	SearchDao searchDao = new SearchDao();
	StudentGradeDao studentGradeDao = new StudentGradeDao();
	StudentTeacherDao studentTeacherDao = new StudentTeacherDao();
	TeacherDao teacherDao = new TeacherDao();
	
	/**
	 * 获取教师信息
	 * @param t_id
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public Teacher getTeacherInfo(String teacherId) throws ReflectiveOperationException, SQLException {
		return teacherDao.getTeacherById(teacherId);
	}
	
	/**
	 * 获取教授的学生信息
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<StudentTeacher> getTeachStudentInfo(String teacherId) throws ReflectiveOperationException, SQLException {
		
		return studentTeacherDao.getStudentByTeacherId(teacherId);
	}
	
	/**
	 * 获取教授课程的课程信息
	 * @param teacherId
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<team543.entity.Class> getTeachClassInfo(String teacherId) throws ReflectiveOperationException, SQLException{
		GiveClassDao giveClassDao = new GiveClassDao();
		
		ArrayList<GiveClass> giveClass = giveClassDao.getGiveClassById(teacherId);
		ArrayList<team543.entity.Class> cs = new ArrayList<team543.entity.Class>();
		
		for(GiveClass gc:giveClass) {
			ClassDao classDao = new ClassDao();
			team543.entity.Class c = classDao.getClassById(gc.getC_id());
			cs.add(c);
		}
		
		return cs;
	}
	
	/**
	 * 获取教授学生成绩信息
	 * @return
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 */
	public ArrayList<StudentGrade> getStudentGrade(String teacherId) throws SQLException, ReflectiveOperationException {
		return studentGradeDao.getStudentGradeByTeacher(teacherId);
		
	}
	
	/**
	 * 更新授课表操作
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void addGiveClassInfo(GiveClass giveClass) throws ReflectiveOperationException, SQLException {
		GiveClassDao giveClassDao = new GiveClassDao();
		giveClassDao.addGiveClass(giveClass);
	}
	
	/**
	 * 修改学生成绩信息
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void UpdataStudentGrade(ArrayList<Grade> grades) throws ReflectiveOperationException, SQLException {
		GradeDao gradeDao = new GradeDao();
		gradeDao.updateGrade(grades);
	}
	
	/**
	 * 搜索学生传入Student 开始 结束日期，若没有制空
	 * @param student
	 * @param firstDate
	 * @param secondDate
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<Student> searchStudent(Student student,Date firstDate,Date secondDate) throws ReflectiveOperationException, SQLException{
		return searchDao.searchStudent(student, firstDate, secondDate);
	}
}
