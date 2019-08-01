package team543.servlet;

import java.awt.List;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import team543.entity.ElectiveClass;
import team543.entity.Student;
import team543.entity.Teacher;
import team543.service.AdminAction;
import team543.utils.*;
/**
 * Servlet implementation class AdminCommitServlet
 */
public class AdminCommitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCommitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws ParseException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void commitStudent(AdminAction admin, JSONObject student) throws ParseException {
    	ArrayList<Object> studentAddObj = (ArrayList<Object>) JSONObject.parseArray(student.getJSONArray("add").toString(), Object.class);
		ArrayList<Student> studentAdd = new ArrayList();
		
		ArrayList<Object> studentUpdateObj = (ArrayList<Object>) JSONObject.parseArray(student.getJSONArray("update").toString(), Object.class);
		ArrayList<Student> studentUpdate = new ArrayList();
		
		ArrayList<Object> studentDeleteObj = (ArrayList<Object>) JSONObject.parseArray(student.getJSONArray("delete").toString(), Object.class);
		ArrayList<Student> studentDelete = new ArrayList();
		
		for (int i = 0; i < studentAddObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) studentAddObj.get(i)).get("ori");
			studentAdd.add(
				new Student(
					(String) temp.get("s_id"),
					(String) temp.get("s_name"),
					(String) temp.get("s_sex"),
					(String) temp.get("s_dp"),
					(String) temp.get("s_major"),
					(String) temp.get("s_class"),
					(String) temp.get("s_state"),
					team543.utils.Basic.StringToDate((String) temp.get("entertime"))
				)
			);
		}
		admin.addStudent(studentAdd);
		
		
		for (int i = 0; i < studentUpdateObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) studentUpdateObj.get(i)).get("after");
			studentUpdate.add(
				new Student(
					(String) temp.get("s_id"),
					(String) temp.get("s_name"),
					(String) temp.get("s_sex"),
					(String) temp.get("s_dp"),
					(String) temp.get("s_major"),
					(String) temp.get("s_class"),
					(String) temp.get("s_state"),
					team543.utils.Basic.StringToDate((String) temp.get("entertime"))
				)
			);
		}
		admin.updateStudent(studentUpdate);
		
		
    }
    
    private void commitTeacher(AdminAction admin, JSONObject teacher) {
    	ArrayList<Object> teacherAddObj = (ArrayList<Object>) JSONObject.parseArray(teacher.getJSONArray("add").toString(), Object.class);
		ArrayList<Teacher> teacherAdd = new ArrayList();
		
		ArrayList<Object> teacherUpdateObj = (ArrayList<Object>) JSONObject.parseArray(teacher.getJSONArray("update").toString(), Object.class);
		ArrayList<Teacher> teacherUpdate = new ArrayList();
		
		ArrayList<Object> teacherDeleteObj = (ArrayList<Object>) JSONObject.parseArray(teacher.getJSONArray("delete").toString(), Object.class);
		ArrayList<Teacher> teacherDelete = new ArrayList();
		
		for (int i = 0; i < teacherAddObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) teacherAddObj.get(i)).get("ori");
			try {
				teacherAdd.add(
					new Teacher(
						(String) temp.get("t_id"),
						(String) temp.get("t_name"),
						(String) temp.get("t_dp"),
						(String) temp.get("t_jobtitle"),
						(String) temp.get("t_salary"),
						(String) temp.get("t_phonenum"),
						(String) temp.get("t_email"),
						(String) temp.get("t_office"),
						(String) temp.get("s_state"),
						team543.utils.Basic.StringToDate((String) temp.get("entertime"))
					)
				);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		admin.addTeacher(teacherAdd);
		
		
		for (int i = 0; i < teacherUpdateObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) teacherUpdateObj.get(i)).get("after");
			try {
				teacherUpdate.add(
						new Teacher(
							(String) temp.get("t_id"),
							(String) temp.get("t_name"),
							(String) temp.get("t_dp"),
							(String) temp.get("t_jobtitle"),
							(String) temp.get("t_salary"),
							(String) temp.get("t_phonenum"),
							(String) temp.get("t_email"),
							(String) temp.get("t_office"),
							(String) temp.get("s_state"),
							team543.utils.Basic.StringToDate((String) temp.get("entertime"))
						)
					);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		admin.updateTeacher(teacherUpdate);
		
    }
	private void commitCourse(AdminAction admin, JSONObject course) {
		ArrayList<Object> courseAddObj = (ArrayList<Object>) JSONObject.parseArray(course.getJSONArray("add").toString(), Object.class);
		ArrayList<team543.entity.Class> courseAdd = new ArrayList();
		
		ArrayList<Object> courseUpdateObj = (ArrayList<Object>) JSONObject.parseArray(course.getJSONArray("update").toString(), Object.class);
		ArrayList<team543.entity.Class> courseUpdate = new ArrayList();
		
		ArrayList<Object> courseDeleteObj = (ArrayList<Object>) JSONObject.parseArray(course.getJSONArray("delete").toString(), Object.class);
		ArrayList<team543.entity.Class> courseDelete = new ArrayList();
		
		for (int i = 0; i < courseAddObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) courseAddObj.get(i)).get("ori");
			courseAdd.add(
				new team543.entity.Class(
					(String) temp.get("c_id"),
					(String) temp.get("c_name"),
					(String) temp.get("c_classstate"),
					(String) temp.get("c_score"),
					(String) temp.get("c_opendp"),
					Integer.valueOf(((String) temp.get("c_percentage")))
				)
			);
		}
		admin.addClass(courseAdd);
		
		
		for (int i = 0; i < courseUpdateObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) courseUpdateObj.get(i)).get("after");
			courseUpdate.add(
					new team543.entity.Class(
							(String) temp.get("c_id"),
							(String) temp.get("c_name"),
							(String) temp.get("c_classstate"),
							(String) temp.get("c_score"),
							(String) temp.get("c_opendp"),
							Integer.valueOf(((String) temp.get("c_percentage")))
						)
				);
		}
		admin.updateClass(courseUpdate);
		
	}
	private void commitSelC(AdminAction admin, JSONObject selC) {
		ArrayList<Object> selCAddObj = (ArrayList<Object>) JSONObject.parseArray(selC.getJSONArray("add").toString(), Object.class);
		ArrayList<ElectiveClass> selCAdd = new ArrayList();
		
		//只有删除
		ArrayList<Object> selCDeleteObj = (ArrayList<Object>) JSONObject.parseArray(selC.getJSONArray("delete").toString(), Object.class);
		ArrayList<String> selCDelete = new ArrayList();
		
		for (int i = 0; i < selCAddObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) selCAddObj.get(i)).get("ori");
			selCAdd.add(
				new ElectiveClass(
					(String) temp.get("c_id"),
					(String) temp.get("s_id")
				)
			);
		}
		admin.addElectiveClass(selCAdd);
		
		
		for (int i = 0; i < selCDeleteObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) selCDeleteObj.get(i)).get("after");
			selCDelete.add(
					(String) temp.get("e_id")
				);
		}
		admin.deleteElectiveClass(selCDelete);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8");
		//相当于Map<String, Object>
		JSONObject data =  JSONObject.parseObject(request.getParameter("data"));
		JSONObject student = data.getJSONObject("student");
		JSONObject teacher = data.getJSONObject("teacher");
		JSONObject course = data.getJSONObject("course");
		JSONObject selC = data.getJSONObject("selC");
		AdminAction admin = new AdminAction();
		if (student != null)
			try {
				this.commitStudent(admin, student);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (teacher != null)
			this.commitTeacher(admin, teacher);
		if (course != null)
			this.commitCourse(admin, course);
		if (selC != null)
			this.commitSelC(admin, selC);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
