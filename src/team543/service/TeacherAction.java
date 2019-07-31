package team543.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import team543.dao.ClassDao;
import team543.dao.ElectiveClassDao;
import team543.dao.GiveClassDao;
import team543.dao.GradeDao;
import team543.dao.SearchDao;
import team543.dao.StudentDao;
import team543.dao.StudentGradeDao;
import team543.dao.StudentTeacherDao;
import team543.dao.TeacherDao;
import team543.entity.ElectiveClass;
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
	 * 通过课程查学生
	 * @param ClassId
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<Student> getStudentByClassId(String ClassId) throws ReflectiveOperationException, SQLException{
		
		StudentDao studentDao = new StudentDao();
		
		ArrayList<ElectiveClass> ecs =  new ElectiveClassDao().getStudentTd(ClassId);
		ArrayList<Student> arrayList = new ArrayList<Student>();
		
		
		for (ElectiveClass ec:ecs) {
			arrayList.add(studentDao.getStudentById(ec.getS_id()));
		}
		
		return arrayList;
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
	 * 
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
