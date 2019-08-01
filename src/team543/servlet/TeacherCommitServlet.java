package team543.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import team543.entity.ElectiveClass;
import team543.entity.Grade;
import team543.entity.Student;
import team543.entity.Teacher;
import team543.utils.MyException;
import team543.service.TeacherAction;

/**
 * Servlet implementation class TeacherCommitServlet
 */
public class TeacherCommitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherCommitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void commitGrade(TeacherAction teacher, JSONObject grade) {
		ArrayList<Object> gradeAddObj = (ArrayList<Object>) JSONObject.parseArray(grade.getJSONArray("add").toString(), Object.class);
		ArrayList<Grade> gradeAdd = new ArrayList();
		
		ArrayList<Object> gradeUpdateObj = (ArrayList<Object>) JSONObject.parseArray(grade.getJSONArray("update").toString(), Object.class);
		ArrayList<Grade> gradeUpdate = new ArrayList();
		
		ArrayList<Object> gradeDeleteObj = (ArrayList<Object>) JSONObject.parseArray(grade.getJSONArray("delete").toString(), Object.class);
		ArrayList<Grade> gradeDelete = new ArrayList();
		
		for (int i = 0; i < gradeAddObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) gradeAddObj.get(i)).get("ori");
			gradeAdd.add(
				new Grade(
					(String) temp.get("s_id"),
					(String) temp.get("c_id"),
					(String) temp.get("reg"),
					(String) temp.get("test"),
					null
				)
			);
		}
		if (!gradeAdd.isEmpty())
			teacher.addGrade(gradeAdd);
		
		
		for (int i = 0; i < gradeUpdateObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) gradeUpdateObj.get(i)).get("after");
			gradeUpdate.add(
					new Grade(
							(String) temp.get("s_id"),
							(String) temp.get("c_id"),
							(String) temp.get("reg"),
							(String) temp.get("test"),
							null
						)
				);
		}
		if (!gradeUpdate.isEmpty())
			teacher.updateGrade(gradeUpdate);
		
		
		for (int i = 0; i < gradeAddObj.size(); i++) {
			Map<String, Object> temp = (Map<String, Object>)((Map<String, Object>) gradeDeleteObj.get(i)).get("ori");
			gradeAdd.add(
				new Grade(
					(String) temp.get("s_id"),
					(String) temp.get("c_id"),
					(String) temp.get("reg"),
					(String) temp.get("test"),
					null
				)
			);
		}
		if (!gradeDelete.isEmpty())
			teacher.deleteGrade(gradeDelete);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8");
		//Ïàµ±ÓÚMap<String, Object>
		JSONObject data =  JSONObject.parseObject(request.getParameter("data"));
		JSONObject grade = data.getJSONObject("grade");
		TeacherAction teacher = new TeacherAction();
		if (grade != null) {
			this.commitGrade(teacher, grade);
		}
		
		Map<String, Object> res = new HashMap();
		res.put("status", "success");
		JSONObject jsonObj = new JSONObject(res);
		String json = jsonObj.toJSONString();
		System.out.println(json);
		response.getWriter().append(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
