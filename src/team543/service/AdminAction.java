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
import java.util.ArrayList;
import java.util.List;

import team543.dao.ClassDao;
import team543.dao.ElectiveClassDao;
import team543.dao.StudentDao;
import team543.dao.StudentGradeDao;
import team543.entity.*;

public class AdminAction {
	StudentDao studentDao = new StudentDao();
	ClassDao classDao = new ClassDao();
	StudentDao student = new StudentDao();
	StudentGradeDao studentGradeDao = new StudentGradeDao();
	ElectiveClassDao electiveClassDao = new ElectiveClassDao();
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
	 */
	public ArrayList<Teacher> getTeacher() {
		return null;
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
	 * 
	 */
	public void updateStudent(ArrayList<Student> students) throws SQLException, ReflectiveOperationException {
		student.updateStudent(students);
	}
	
	/**
	 * ���½�ʦ��Ϣ
	 * 
	 */
	public void updateTeacher() {
		
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

}
