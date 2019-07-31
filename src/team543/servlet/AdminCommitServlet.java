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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private void commitStudent(AdminAction admin, Map<String,Object> student) {
    	ArrayList<Object> studentAddObj = (ArrayList<Object>) student.get("add");
		ArrayList<Student> studentAdd = new ArrayList();
		
		ArrayList<Object> studentUpdateObj = (ArrayList<Object>) student.get("update");
		ArrayList<Student> studentUpdate = new ArrayList();
		
		ArrayList<Object> studentDeleteObj = (ArrayList<Object>) student.get("delete");
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
					(Date) temp.get("entertime")
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
					(Date) temp.get("entertime")
				)
			);
		}
		admin.updateStudent(studentUpdate);
		
		
    }
    
    private void commitTeacher(AdminAction admin, Map<String,Object> teacher) {
    	ArrayList<Object> teacherAddObj = (ArrayList<Object>) teacher.get("add");
		ArrayList<Teacher> teacherAdd = new ArrayList();
		
		ArrayList<Object> teacherUpdateObj = (ArrayList<Object>) teacher.get("update");
		ArrayList<Teacher> teacherUpdate = new ArrayList();
		
		ArrayList<Object> teacherDeleteObj = (ArrayList<Object>) teacher.get("delete");
		ArrayList<Teacher> teacherDelete = new ArrayList();
		
		for (int i = 0; i < teacherAddObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) teacherAddObj.get(i)).get("ori");
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
					(Date) temp.get("entertime")
				)
			);
		}
		admin.addTeacher(teacherAdd);
		
		
		for (int i = 0; i < teacherUpdateObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) teacherUpdateObj.get(i)).get("after");
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
						(Date) temp.get("entertime")
					)
				);
		}
		admin.updateTeacher(teacherUpdate);
		
    }
	private void commitCourse(AdminAction admin, Map<String,Object> course) {
		ArrayList<Object> courseAddObj = (ArrayList<Object>) course.get("add");
		ArrayList<team543.entity.Class> courseAdd = new ArrayList();
		
		ArrayList<Object> courseUpdateObj = (ArrayList<Object>) course.get("update");
		ArrayList<team543.entity.Class> courseUpdate = new ArrayList();
		
		ArrayList<Object> courseDeleteObj = (ArrayList<Object>) course.get("delete");
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
		try {
			admin.updateClass(courseUpdate);
		} catch (SQLException | ReflectiveOperationException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO 课程删除
		
	}
	private void commitSelC(AdminAction admin, Map<String,Object> selC) {
		ArrayList<Object> selCAddObj = (ArrayList<Object>) selC.get("add");
		ArrayList<ElectiveClass> selCAdd = new ArrayList();
		
		//只有删除
		ArrayList<Object> selCUpdateObj = (ArrayList<Object>) selC.get("update");
		ArrayList<String> selCUpdate = new ArrayList();
		
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
		
		
		for (int i = 0; i < selCUpdateObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) selCUpdateObj.get(i)).get("after");
			selCUpdate.add(
					(String) temp.get("e_id")
				);
		}
		admin.deleteElectiveClass(selCUpdate);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8");
		//相当于Map<String, Object>
		JSONObject obj = JSON.parseObject(request.getParameter("data"));
		@SuppressWarnings("unchecked")
		Map<String,Object> student = (Map<String, Object>) obj.get("student");
		@SuppressWarnings("unchecked")
		Map<String,Object> teacher = (Map<String, Object>) obj.get("teacher");
		@SuppressWarnings("unchecked")
		Map<String,Object> course = (Map<String, Object>) obj.get("course");
		@SuppressWarnings("unchecked")
		Map<String,Object> selC = (Map<String, Object>) obj.get("selC");
		AdminAction admin = new AdminAction();
		this.commitStudent(admin, student);
		this.commitTeacher(admin, teacher);
		this.commitCourse(admin, course);
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
