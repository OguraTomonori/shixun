package team543.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import team543.dao.*;
import team543.entity.Class;
import team543.entity.ElectiveClass;
import team543.entity.GiveClass;
import team543.entity.Student;
import team543.entity.StudentGrade;
import team543.entity.Teacher;

public class StudentAction {
	/**
	 * ��ȡѧ����Ϣ
	 * @return
	 * @throws SQLException
	 * @throws ReflectiveOperationException 
	 */
	public Student getStudentInfo(String Studentid) throws ReflectiveOperationException, SQLException {
		//�ж�id�Ƿ�Ϊ����
		if(team543.utils.Basic.isNumeric(Studentid)) {
			return  new StudentDao().getStudentById(Studentid);
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

		for(int i = 0 ; i < ec.size() ; i++) {

			list.add(ec.get(i).getC_id());
		
		}
		//��������γ���Ϣ���б�
		ArrayList<team543.entity.Class> cl = new ArrayList<team543.entity.Class>();

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
		return new StudentGradeDao().getStudentGrade(studentId);
	}
	
	/**
	 * ѧ��ѡ��
	 * @param studentId
	 * @param classId
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public void studentElectiveClass(String studentId , String classId) throws ReflectiveOperationException, SQLException {
		new ElectiveClassDao().addElectiveClass(studentId, classId);
	}
	
	/**
	 * ��ȡ���пγ���Ϣ
	 * @return
	 * @throws SQLException
	 * @throws ReflectiveOperationException
	 */
	public ArrayList<Class> getAllClass() throws SQLException, ReflectiveOperationException {
		return new ClassDao().getAllClass();
	}
	
	/**
	 * 
	 * @param ClassId
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public Teacher getTeacherByClassId(String ClassId) throws ReflectiveOperationException, SQLException {
		GiveClassDao giveClassDao = new GiveClassDao();
		TeacherDao teacherDao = new TeacherDao();
		GiveClass giveClass = new GiveClass();
		//���ݿγ�id��ȡ�ڿ�
		giveClass = giveClassDao.getGiveClassByClassId(ClassId);
		//�����ڿλ�ý�ʦ��Ϣ
		return teacherDao.getTeacherById(giveClass.getT_id());
	}
	
	/**
	 * 学生获取教师信息
	 * @param StudentId
	 * @return
	 * @throws ReflectiveOperationException
	 * @throws SQLException
	 */
	public ArrayList<Teacher> getTeacherByStudent(String StudentId) throws ReflectiveOperationException, SQLException {
		ElectiveClassDao electiveClassDao = new ElectiveClassDao();
		
		ArrayList<ElectiveClass> list = electiveClassDao.getClassId(StudentId);
		ArrayList<Teacher> Lteacherist = new ArrayList<Teacher>();
		//查出学生选课的id查询教授的教师的信息
		for (ElectiveClass ec:list) {
			Lteacherist.add(getTeacherByClassId(ec.getC_id()));
		}
		return Lteacherist;
	}
	

	/**
	 * 下载学生课程信息
	 * @param cs
	 * @param fileName
	 * @return
	 * @throws RowsExceededException
	 * @throws WriteException
	 * @throws IOException
	 */
	public String putClassOut(ArrayList<Class> cs , String studentName) throws RowsExceededException, WriteException, IOException {
		String fileName = studentName;//+String.valueOf(System.currentTimeMillis());
		new PutExcelDao().putClass(cs, fileName);
		return "excel/Class/"+ fileName+".xls";
	}

}
