package team543.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import team543.entity.Student;
import team543.service.TeacherAction;
import team543.utils.Basic;

/**
 * Servlet implementation class AdminSearchStudentServlet
 */
public class AdminSearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 这里是根据
		 *  "s_id":
			"s_name":
			"s_sex":
			"s_dp":
			"s_major":
			"s_class":
			"s_state":
			
			"starttime"
			"endtime":
		 * 
		 * 
		 * 给前端返回数组
		*/
		
		response.setContentType("application/json; charset=utf-8");
		/*
		Map<String, Object> params = team543.utils.ParamUtil.getRequestParameters(request);
		String studentID = (String) params.get("s_id");
		String name = (String) params.get("s_name");
		String sex = (String) params.get("s_sex");
		String dp = (String) params.get("s_dp");
		String major = (String) params.get("s_major");
		String class_ = (String) params.get("s_class");
		String state = (String) params.get("s_state");
		String ST = (String) params.get("startTime");
		String ET = (String) params.get("endTime");
		Date startTime = null;
		try {
			if (ST != null)
				startTime = Basic.StringToDate(ST);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date endTime = null;
		try {
			if (ET != null)
				endTime = Basic.StringToDate(ET);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Student> resp = null;
		try {
			resp = new TeacherAction().searchStudent(
				new Student(studentID, name, sex, dp, major, class_, state, null)
				, startTime, endTime);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> res = new HashMap();
		res.put("data", resp);
		JSONObject jsonObj = new JSONObject(res);
		String json = jsonObj.toJSONString();
		System.out.println(json);
		response.getWriter().append(json);
		*/
		String search_option = request.getParameter("search_option");
		String search_text = request.getParameter("search_text");
		String name = null;
		String id = null;
		String major = null;
		String class_ = null;
		switch (search_option) {
		case "0":
			name = search_text;
			break;
		case "1":
			id = search_text;
			break;
		case "2":
			major = search_text;
			break;
		case "3":
			class_ = search_text;
		}
		ArrayList<Student> resp = null;
		try {
			resp = new TeacherAction().searchStudent(
				new Student(id, name, null, null, major, class_, null, null)
				, null, null);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> res = new HashMap();
		res.put("data", resp);
		JSONObject jsonObj = new JSONObject(res);
		String json = jsonObj.toJSONString();
		System.out.println(json);
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
