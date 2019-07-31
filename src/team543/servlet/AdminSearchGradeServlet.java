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

import team543.entity.StudentGrade;
import team543.entity.Teacher;
import team543.service.AdminAction;
import team543.service.StudentAction;

/**
 * Servlet implementation class AdminSearchGradeServlet
 */
public class AdminSearchGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchGradeServlet() {
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
		ArrayList<StudentGrade> resp = null;
		switch (search_option) {
		case "0"://根据学生id
			try {
				System.out.println(search_text);
				resp = new StudentAction().getGrade(search_text);
				System.out.println(new StudentAction().getGrade(search_text));
			} catch (ReflectiveOperationException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "1"://根据课程id
			//TODO resp = new 
			
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
