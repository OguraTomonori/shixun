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

import team543.dao.ClassDao;
import team543.dao.StudentDao;
import team543.entity.*;

public class AdminAction {
	StudentDao studentDao = new StudentDao();
	ClassDao classDao = new ClassDao();
	StudentDao student = new StudentDao();
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
	 * ��ȡ�ɼ���Ϣ
	 * @return
	 */
	public ArrayList<Grade> getGrade(){
		return null;
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 * 
	 */
	public void updateStudent(Student[] StudentId) throws SQLException, ReflectiveOperationException {
		student.updateStudent(StudentId);
	}
	
	/**
	 * ���½�ʦ��Ϣ
	 * 
	 */
	public void updateTeacher() {
		
	}
	
	/**
	 * �޸�ѡ����Ϣ
	 * 
	 */
	public void updateElectiveClass() {
		
	}
	
	/**
	 * �޸ĳɼ���Ϣ
	 * 
	 */
	public void updateGrade() {
		
	}

}
