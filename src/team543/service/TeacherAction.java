package team543.service;

import java.util.ArrayList;

import team543.entity.Student;
import team543.entity.StudentGrade;
import team543.entity.Teacher;

public class TeacherAction {
	/**
	 * 获取教师信息
	 * @param t_id
	 * @return
	 */
	public Teacher getTeacherInfo(String t_id) {
		
		return null;
	}
	
	/**
	 * 获取教授的学生信息
	 * @return
	 */
	public ArrayList<Student> getTeachStudentInfo(String t_id) {
		
		return null;
	}
	
	/**
	 * 获取教授课程的课程信息
	 * @param t_id
	 * @return
	 */
	public ArrayList<team543.entity.Class> getTeachClassInfo(String t_id){
		return null;
	}
	
	/**
	 * 获取教授学生成绩信息1.学生id 2，学生姓名 3.学生成绩
	 * @return
	 */
	public ArrayList<StudentGrade> getStudentGrade(String t_id) {
		
		return null;
	}
	
	/**
	 * 更新授课表操作
	 * 
	 */
	public void updateGiveClassInfo() {
		
	}
	
	/**
	 * 修改学生成绩信息
	 * 
	 */
	public void UpdataStudentGrade() {
		
	}

}
