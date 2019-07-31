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
	public ArrayList<Integer> updateStudent(ArrayList<Student> students) {
		
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer m = 0 ; 
		try {
			student.updateStudent(students);
			m++;
		} catch (SQLException | ReflectiveOperationException | ParseException e) {
			num.add(m);
			m++;
		}
		return num;
	}
	
	/**
	 * ���½�ʦ��Ϣ
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public ArrayList<Integer> updateTeacher(ArrayList<Teacher> teachers) {
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer m = 0;
		for (Teacher teacher:teachers) {
			try {
				teacherDao.updateTeacher(teacher);
				m++;
			} catch (Exception e) {
				num.add(m);
				m++;
			} 
		}
		return num;
	}
	
	/**
	 * ��ѡ��id�޸�ѡ����Ϣ
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public ArrayList<Integer> updateElectiveClass(String id ,String StudentId , String ClassId)  {
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer m = 0 ; 
		try {
			electiveClassDao.updateElectiveClass(id,StudentId, ClassId);
			m++;
		} catch (Exception e) {
			num.add(m);
			m++;
		}
		return num;
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
	
	/**
	 * 添加教师
	 * @return
	 */
	public ArrayList<Integer> addTeacher(ArrayList<Teacher> teachers) {
		//num保存出错的位数
		ArrayList<Integer> num  = new ArrayList<Integer>();
		//m记录
		Integer m = 0;
		
		for(Teacher t:teachers) {
			TeacherDao teacherDao = new TeacherDao();
			try {
				//成功m加一
				teacherDao.addTeacher(t);
				m++;
				
			} catch (ReflectiveOperationException | SQLException e) {
				//否则加入num
				num.add(m);
				m++;
			}
		}
		return num;
	}
	/**
	 * 添加学生
	 * @param students
	 * @return
	 */
	public ArrayList<Integer> addStudent(ArrayList<Student> students) {
		//num保存出错的位数
		ArrayList<Integer> num  = new ArrayList<Integer>();
		//m记录
		Integer m = 0;
		
		for(Student s:students) {
			StudentDao studentDao = new StudentDao();
			try {
				//成功m加一
				studentDao.addStudent(s);
				m++;
				
			} catch (ReflectiveOperationException | SQLException e) {
				//否则加入num
				num.add(m);
				m++;
			}
		}
		return num;
	}
	
	public ArrayList<Integer> addClass(ArrayList<team543.entity.Class> cl) {
		//num保存出错的位数
		ArrayList<Integer> num  = new ArrayList<Integer>();
		//m记录
		Integer m = 0;
		
		for(team543.entity.Class c:cl) {
			ClassDao classDao = new ClassDao();
			try {
				//成功m加一
				classDao.addClass(c);
				m++;
				
			} catch (ReflectiveOperationException | SQLException e) {
				//否则加入num
				num.add(m);
				m++;
			}
		}
		return num;
	}
	
	/**
	 * 添加选课
	 * @param electiveClass
	 * @return
	 */
	public ArrayList<Integer> addElectiveClass(ArrayList<ElectiveClass> electiveClass) {
		//num保存出错的位数
		ArrayList<Integer> num  = new ArrayList<Integer>();
		//m记录
		Integer m = 0;
		
		for(ElectiveClass c:electiveClass) {
			ElectiveClassDao electiveClassDao = new ElectiveClassDao();
			try {
				//成功m加一
				electiveClassDao.addElectiveClass(c.getS_id(), c.getC_id());;
				m++;
				
			} catch (ReflectiveOperationException | SQLException e) {
				//否则加入num
				num.add(m);
				m++;
			}
		}
		return num;
	}
	
	public ArrayList<Integer> deleteStudent(ArrayList<String> studentIds)  {
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer n = 0;
		for(String studentId:studentIds)
			try {
				studentDao.deleteStudent(studentId);
				n++;
			} catch (SQLException | ReflectiveOperationException e) {
				// TODO Auto-generated catch block
				num.add(n);
				n++;
			}
		return num;
	}
}
