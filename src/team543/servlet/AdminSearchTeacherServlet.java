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

import team543.entity.Teacher;
import team543.service.AdminAction;

/**
 * Servlet implementation class AdminSearchTeacherServlet
 */
public class AdminSearchTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchTeacherServlet() {
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
		ArrayList<Teacher> resp = null;
		try {
			resp = new AdminAction().searchTeacher(
				new Teacher(
						id, name, dp, null, null, null, null, null, null, null
						), null, null
					);
		} catch (SQLException | ReflectiveOperationException e) {
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
