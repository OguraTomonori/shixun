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
import team543.dao.GiveClassDao;
import team543.dao.SearchDao;
import team543.dao.StudentDao;
import team543.dao.StudentGradeDao;
import team543.dao.TeacherDao;
import team543.entity.*;
import team543.entity.Class;
import team543.utils.MyException;

public class AdminAction {

	
	/**
	 * ��ȡѧ����Ϣ
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public ArrayList<Student> getStudent() throws ReflectiveOperationException, SQLException {
		return new StudentDao().getStudents();
	}
	
	/**
	 * ��ȡ��ʦ��Ϣ
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<Teacher> getTeacher() throws ReflectiveOperationException, SQLException {
		return new TeacherDao().getTeachers();
	}
	
	/**
	 * ��ȡ�γ���Ϣ
	 * @return
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 */
	public ArrayList<team543.entity.Class> getClassInfo() throws SQLException, ReflectiveOperationException{
		return new ClassDao().getAllClass();
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
		return  new StudentGradeDao().getGrades(sort,sequence);
	}
	
	/**
	 * @param cl
	 * @return
	 * @throws MyException
	 */
	public ArrayList<Integer> updateClass(ArrayList<Class> cl){
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer m = 0 ; 
		for (Class c : cl) {
			try {
				new ClassDao().updateClass(c);
				m++;
			} catch (SQLException | ReflectiveOperationException | MyException e) {
				num.add(m);
				m++;
			} 
		}
		return num;
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
		for ( Student s : students) {
			try {
				 new StudentDao().updateStudent(s);
				m++;
			} catch (SQLException | ReflectiveOperationException | ParseException e) {
				num.add(m);
				m++;
			} 
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
				new TeacherDao().updateTeacher(teacher);
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
			new ElectiveClassDao().updateElectiveClass(id,StudentId, ClassId);
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
		return new SearchDao().searchStudent(student, firstDate, secondDate);
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
		return new SearchDao().searchTeacher(teacher, firstDate, secondDate);
	}
	
	/**
	 * 搜索课程
	 * @param cl
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<team543.entity.Class> searchClass(team543.entity.Class cl) throws ReflectiveOperationException, SQLException{
		return new SearchDao().searchClass(cl);
	}
	
	/**
	 * @param ClassId
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public Teacher getTeacherByClassId(String ClassId) throws ReflectiveOperationException, SQLException {
		String teacherId = new GiveClassDao().getGiveClassByTeacherId(ClassId).getT_id();
		return new TeacherDao().getTeacherById(teacherId);
	}
	
	/**
	 * 添加教师
	 * @return
	 * @throws MyException 
	 */
	public ArrayList<Integer> addTeacher(ArrayList<Teacher> teachers){
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
				
			} catch (ReflectiveOperationException | SQLException | MyException e) {
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
	
	public ArrayList<Integer> addClass(ArrayList<team543.entity.Class> cl)  {
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
				
			} catch (ReflectiveOperationException | SQLException | MyException e) {
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
	
	/**
	 * 删除学生
	 * @param studentIds
	 * @return
	 */
	public ArrayList<Integer> deleteStudent(ArrayList<Student> students)  {
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer n = 0;
		for(Student studentId:students)
			try {
				new StudentDao().deleteStudent(studentId.getS_id());
				n++;
			} catch (SQLException | ReflectiveOperationException e) {
				// TODO Auto-generated catch block
				num.add(n);
				n++;
			}
		return num;
	}
	
	/**
	 * 删除选课信息
	 * 仅使用e_id判断删除条件
	 * @param ec
	 * @return
	 */
	public ArrayList<Integer> deleteElectiveClass(ArrayList<ElectiveClass> ec){
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer n = 0;
		for(ElectiveClass e:ec)
			try {
				new ElectiveClassDao().deleteElectiveClass(e.getE_id());
				n++;
			} catch (SQLException | ReflectiveOperationException e1) {
				// TODO Auto-generated catch block
				num.add(n);
				n++;
			}
		return num;
	}
	
	/**
	 * 删除教师
	 * @param teachers
	 * @return
	 */
	public ArrayList<Integer> deleteTeacher(ArrayList<Teacher> teachers){
		
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer n = 0;
		for(Teacher t:teachers)
			try {
				new TeacherDao().deleteTeacher(Integer.valueOf(t.getT_id()));
				n++;
			} catch (SQLException | ReflectiveOperationException e) {
				num.add(n);
				n++;
			}
		return num;
	}
	
	public ArrayList<Integer> updateGiveClass(ArrayList<GiveClass> giveClass) {
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer n = 0;
		for(GiveClass gc:giveClass)
			try {
				new GiveClassDao().updateGiveClass(gc);;
				n++;
			} catch (SQLException | ReflectiveOperationException | MyException e) {
				num.add(n);
				n++;
			}
		return num;
	}
}
