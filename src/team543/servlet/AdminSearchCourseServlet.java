package team543.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import team543.entity.Student;
import team543.entity.StudentGrade;
import team543.entity.Teacher;
import team543.service.AdminAction;
import team543.service.StudentAction;
import team543.service.TeacherAction;

/**
 * Servlet implementation class AdminSearchCourseServlet
 */
public class AdminSearchCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8");
		String search_option = request.getParameter("search_option");
		String search_text = request.getParameter("search_text");
		
		
		String name = null;
		String id = null;
		String dp = null;
		switch (search_option) {
		case "0":
			name = search_text;
			break;
		case "1":
			id = search_text;
			break;
		case "2":
			dp = search_text;
		}
		ArrayList<team543.entity.Class> cour = null;
		ArrayList<Teacher> teac = new ArrayList();
		try {
			cour = new AdminAction().searchClass(
				new team543.entity.Class(id, name, null, null, dp, null)
					);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (team543.entity.Class c : cour) {
			try {
				teac.add(new StudentAction().getTeacherByClassId(c.getC_id()));
			} catch (ReflectiveOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Map<String, Object> res = new HashMap();
		res.put("data", cour);
		res.put("teac", teac);
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
