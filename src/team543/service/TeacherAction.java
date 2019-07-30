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


 /**
  * 教师操作
 *	 @author 公子小白
 * 	 @date 2019年7月30日上午9:30:35
 *
 */
public class TeacherAction {
	
	SearchDao searchDao = new SearchDao();
	StudentGradeDao studentGradeDao = new StudentGradeDao();
	StudentTeacherDao studentTeacherDao = new StudentTeacherDao();
	TeacherDao teacherDao = new TeacherDao();
	
	/**
	 * ��ȡ��ʦ��Ϣ
	 * @param t_id
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public Teacher getTeacherInfo(String teacherId) throws ReflectiveOperationException, SQLException {
		return teacherDao.getTeacherById(teacherId);
	}
	
	/**
	 * ��ȡ���ڵ�ѧ����Ϣ
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<StudentTeacher> getTeachStudentInfo(String teacherId) throws ReflectiveOperationException, SQLException {
		
		return studentTeacherDao.getStudentByTeacherId(teacherId);
	}
	
	/**
	 * ��ȡ���ڿγ̵Ŀγ���Ϣ
	 * @param teacherId
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<team543.entity.Class> getTeachClassInfo(String teacherId) throws ReflectiveOperationException, SQLException{
		GiveClassDao giveClassDao = new GiveClassDao();
		//根据教师id查询授课信息
		ArrayList<GiveClass> giveClass = giveClassDao.getGiveClassById(teacherId);
		ArrayList<team543.entity.Class> cs = new ArrayList<team543.entity.Class>();
		//从每个授课信息中获取课程id，在查出课程信息
		for(GiveClass gc:giveClass) {
			ClassDao classDao = new ClassDao();
			team543.entity.Class c = classDao.getClassById(gc.getC_id());
			cs.add(c);
		}
		
		return cs;
	}
	
	/**
	 * ��ȡ����ѧ���ɼ���Ϣ
	 * @return
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 */
	public ArrayList<StudentGrade> getStudentGrade(String teacherId) throws SQLException, ReflectiveOperationException {
		return studentGradeDao.getStudentGradeByTeacher(teacherId);
		
	}
	
	/**
	 * �����ڿα����
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void addGiveClassInfo(GiveClass giveClass) throws ReflectiveOperationException, SQLException {
		GiveClassDao giveClassDao = new GiveClassDao();
		giveClassDao.addGiveClass(giveClass);
	}
	
	/**
	 * �޸�ѧ���ɼ���Ϣ
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * 
	 */
	public void UpdataStudentGrade(ArrayList<Grade> grades) throws ReflectiveOperationException, SQLException {
		GradeDao gradeDao = new GradeDao();
		gradeDao.updateGrade(grades);
	}
	
	/**
	 * ����ѧ������Student ��ʼ �������ڣ���û���ƿ�
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

}
