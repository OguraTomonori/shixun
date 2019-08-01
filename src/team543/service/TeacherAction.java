package team543.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import team543.dao.ClassDao;
import team543.dao.ElectiveClassDao;
import team543.dao.GiveClassDao;
import team543.dao.GradeDao;
import team543.dao.PutExcelDao;
import team543.dao.SearchDao;
import team543.dao.StudentDao;
import team543.dao.StudentGradeDao;
import team543.dao.StudentTeacherDao;
import team543.dao.TeacherDao;
import team543.entity.Class;
import team543.entity.ElectiveClass;
import team543.entity.GiveClass;
import team543.entity.Grade;
import team543.entity.Student;
import team543.entity.StudentGrade;
import team543.entity.StudentTeacher;
import team543.entity.Teacher;
import team543.utils.MyException;

public class TeacherAction {
	
	
	/**
	 * ��ȡ��ʦ��Ϣ
	 * @param t_id
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public Teacher getTeacherInfo(String teacherId) throws ReflectiveOperationException, SQLException {
		return new TeacherDao().getTeacherById(teacherId);
	}
	
	/**
	 * ��ȡ���ڵ�ѧ����Ϣ
	 * @return
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public ArrayList<StudentTeacher> getTeachStudentInfo(String teacherId) throws ReflectiveOperationException, SQLException {
		return new StudentTeacherDao().getStudentByTeacherId(teacherId);
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
		
		ArrayList<ElectiveClass> ecs =  new ElectiveClassDao().getStudentId(ClassId);
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
		return new StudentGradeDao().getStudentGradeByTeacher(teacherId);
		
	}
	
	/**
	 * �����ڿα����
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 * @throws MyException 
	 * 
	 */
	public void addGiveClassInfo(GiveClass giveClass) throws ReflectiveOperationException, SQLException, MyException {
		GiveClassDao giveClassDao = new GiveClassDao();
		giveClassDao.addGiveClass(giveClass);
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
		return new SearchDao().searchStudent(student, firstDate, secondDate);
	}
	
	/**
	 * 通过课程id获取该课程学生的成绩
	 * @return
	 * @throws ReflectiveOperationException 
	 * @throws SQLException 
	 */
	public ArrayList<StudentGrade> getGradeByClass(String classId) throws SQLException, ReflectiveOperationException{
		return new StudentGradeDao().getClassGrade(classId);
	}
	
	/**
	 * 导出学生信息
	 * @param students
	 * @param studentName
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws IOException
	 */
	public String putStudentOut(ArrayList<Student> students , String studentName) throws RowsExceededException, WriteException, IOException {
		String fileName = studentName;//+String.valueOf(System.currentTimeMillis());
		new PutExcelDao().putStudent(students, fileName);
		return "excel/Student/"+ fileName+".xls";
	}
	
	/**
	 * 添加成绩
	 * @param grade
	 * @return
	 * @throws MyException
	 */
	public ArrayList<Integer> addGrade(ArrayList<Grade> grade) {
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer m = 0 ; 
		for (Grade c : grade) {
			try {
				new GradeDao().addGrade(c);
				m++;
			} catch (SQLException | ReflectiveOperationException | MyException e) {
				num.add(m);
				m++;
			} 
		}
		return num;
	}
	
	/**
	 * @param grade
	 * @return
	 * @throws MyException
	 */
	public ArrayList<Integer> updateGrade(ArrayList<Grade> grade) {
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer m = 0 ; 
		for (Grade c : grade) {
			try {
				new GradeDao().updateGrade(c);
				m++;
			} catch (SQLException | ReflectiveOperationException | MyException e) {
				num.add(m);
				m++;
			} 
		}
		return num;
	}
	
	/**
	 * @param grade
	 * @return
	 * @throws MyException
	 */
	public ArrayList<Integer> deleteGrade(ArrayList<Grade> grade) {
		ArrayList<Integer> num =new ArrayList<Integer>();
		Integer m = 0 ; 
		for (Grade c : grade) {
			try {
				new GradeDao().deleteGrade(c);
				m++;
			} catch (SQLException | ReflectiveOperationException | MyException e) {
				num.add(m);
				m++;
			} 
		}
		return num;
	}
}
