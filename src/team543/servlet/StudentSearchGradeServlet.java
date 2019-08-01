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
import team543.service.StudentAction;

/**
 * Servlet implementation class StudentSearchGradeServlet
 */
public class StudentSearchGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=utf-8");
		String studentID = request.getParameter("studentID");
		ArrayList<StudentGrade> resp = null;
		try {
			resp = new StudentAction().getGrade(studentID);
		} catch (ReflectiveOperationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> res = new HashMap<String, Object>();
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
