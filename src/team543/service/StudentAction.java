package team543.service;

import java.sql.SQLException;
import java.util.ArrayList;

import team543.dao.*;
import team543.entity.Class;
import team543.entity.ElectiveClass;
import team543.entity.GiveClass;
import team543.entity.Student;
import team543.entity.StudentGrade;
import team543.entity.Teacher;

 /**
  * 学生操作
 *	 @author 公子小白
 * 	 @date 2019年7月30日上午9:30:22
 *
 */
public class StudentAction {
	StudentDao studentDao = new StudentDao();
	StudentGradeDao studentGradeDao = new StudentGradeDao();
	ElectiveClassDao electiveClassDao = new ElectiveClassDao();
	ClassDao  classDao =new ClassDao();
	/**
	 * ��ȡѧ����Ϣ
	 * @return
	 * @throws SQLException
	 * @throws ReflectiveOperationException 
	 */
	public Student getStudentInfo(String id) throws ReflectiveOperationException, SQLException {
		//�ж�id�Ƿ�Ϊ����
		if(team543.utils.Basic.isNumeric(id)) {
			return studentDao.getStudentById(id);
		}else {
			return null;
		}
	}
	
	/**
	 * ��ȡѧ��ѡ����Ϣ
	 * @param c_id
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public  ArrayList<team543.entity.Class> getStudentClass(String studentId) throws ReflectiveOperationException, SQLException{
		ElectiveClassDao electiveClassDao = new ElectiveClassDao();
		ClassDao classDao = new ClassDao();
		//��������ѧ��ѡ�εĿγ�id���б�
		ArrayList<String> list = new ArrayList<String>();
		
		ArrayList<ElectiveClass> ec = new ArrayList<ElectiveClass>();
		
		ec = electiveClassDao.getClassId(studentId);
		//���ú�����ȡ
//		System.out.println(ec.get(0).getC_id());
//		String str = "1" ; 
		for(int i = 0 ; i < ec.size() ; i++) {

			list.add(ec.get(i).getC_id());
		
		}
		//��������γ���Ϣ���б�
		ArrayList<team543.entity.Class> cl = new ArrayList<team543.entity.Class>();
		
//		System.out.println(list);
		//��ѧ��ѡ�γ̵�id
		for(int i = 0 ; i<list.size();i++) {
			//��ѯ�γ���Ϣ
			cl.add(classDao.getClassById(list.get(i)));
		}
		return cl;
	}

	/**
	 * ��ȡѧ���ɼ��б�
	 * @param s_id
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<StudentGrade> getGrade(String studentId) throws ReflectiveOperationException, SQLException{
		return studentGradeDao.getStudentGrade(studentId);
	}
	
	/**
	 * ѧ��ѡ��
	 * @param studentId
	 * @param classId
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void studentElectiveClass(String studentId , String classId) throws ReflectiveOperationException, SQLException {
		electiveClassDao.addElectiveClass(studentId, classId);
	}
	
	/**
	 * ��ȡ���пγ���Ϣ
	 * @return
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 */
	public ArrayList<Class> getAllClass() throws SQLException, ReflectiveOperationException {
		return classDao.getAllClass();
	}
	
	public Teacher getTeacherByClassId(String ClassId) throws ReflectiveOperationException, SQLException {
		GiveClassDao giveClassDao = new GiveClassDao();
		TeacherDao teacherDao = new TeacherDao();
		GiveClass giveClass = new GiveClass();
		//���ݿγ�id��ȡ�ڿ�
		giveClass = giveClassDao.getGiveClassByClassId(ClassId);
		//�����ڿλ�ý�ʦ��Ϣ
		return teacherDao.getTeacherById(giveClass.getT_id());
	}

}
