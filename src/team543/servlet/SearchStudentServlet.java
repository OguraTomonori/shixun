package team543.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import team543.entity.Student;
import team543.service.*;

/**
 * Servlet implementation class SearchStudentServlet
 */
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 *  "s_id":
			"s_name":
			"s_sex":
			"s_dp":
			"s_major":
			"s_class":
			"s_state":
			"s_entertime":
		 * 
		 * 
		 * 给前端返回数组
		*/
		response.setContentType("application/json; charset=utf-8");
		Map<String, Object> params = team543.utils.ParamUtil.getRequestParameters(request);
		String studentID = (String) params.get("s_id");
		Student [] resp = new Student[1];
		
		StudentAction action = new StudentAction();
		try {
			resp[0] = action.getStudentInfo(studentID);
		} catch (ReflectiveOperationException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> res = new HashMap();
		res.put("data", resp);
		JSONObject json = new JSONObject(res);
		String dd = json.toJSONString();
		System.out.println(dd);
		response.getWriter().append(dd);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
