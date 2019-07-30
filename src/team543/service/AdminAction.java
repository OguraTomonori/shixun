package team543.service;
//����Ա
//��ѯѧ����Ϣ
//��ѯ��ʦ��Ϣ
//��ѯ�γ���Ϣ
//��ѯ�ɼ���Ϣ
//�޸�ѧ����Ϣ
//�޸Ľ�ʦ��Ϣ
//�޸�ѡ����Ϣ
//�޸ĳɼ���Ϣ

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

 /**
  * 管理员操作函数
 *	 @author 公子小白
 * 	 @date 2019年7月30日上午9:29:33
 *
 */
public class AdminAction {
	StudentDao studentDao = new StudentDao();
	ClassDao classDao = new ClassDao();
	StudentDao student = new StudentDao();
	StudentGradeDao studentGradeDao = new StudentGradeDao();
	ElectiveClassDao electiveClassDao = new ElectiveClassDao();
	TeacherDao teacherDao = new TeacherDao();
	SearchDao searchDao = new SearchDao();
	/**
	 * ��ȡѧ����Ϣ
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public ArrayList<Student> getStudent() throws ReflectiveOperationException, SQLException {
		return studentDao.getStudents();
	}
	
	/**
	 * ��ȡ��ʦ��Ϣ
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<Teacher> getTeacher() throws ReflectiveOperationException, SQLException {
		return teacherDao.getTeachers();
	}
	
	/**
	 * ��ȡ�γ���Ϣ
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
	 * 1.DESC ����
	 * 2.ASC ����
	 * ��ȡ�ɼ���Ϣ
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<StudentGrade> getGrade(int sort , int sequence) throws ReflectiveOperationException, SQLException{		
		return studentGradeDao.getGrades(sort,sequence);
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 * @throws ParseException 
	 * 
	 */
	public void updateStudent(ArrayList<Student> students) throws SQLException, ReflectiveOperationException, ParseException {
		student.updateStudent(students);
	}
	
	/**
	 * ���½�ʦ��Ϣ
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void updateTeacher(Teacher teacher) throws ReflectiveOperationException, SQLException {
		teacherDao.updateTeacher(teacher);
	}
	
	/**
	 * ��ѡ��id�޸�ѡ����Ϣ
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void updateElectiveClass(String id ,String StudentId , String ClassId) throws ReflectiveOperationException, SQLException {
		electiveClassDao.updateElectiveClass(id,StudentId, ClassId);
	}
	
	/**
	 * �޸ĳɼ���Ϣ
	 * 
	 */
	public void updateGrade() {
		
	}
	
	/**
	 * ����ѧ��
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
	 * ������ʦ
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
