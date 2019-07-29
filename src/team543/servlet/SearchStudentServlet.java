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

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  Auto-generated method stub
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
		Map<String, Object> params = team543.utils.ParamUtil.getRequestParameters(request);
		String studentID = (String) params.get("s_id");
		String name = (String) params.get("s_name");
		String sex = (String) params.get("s_sex");
		String dp = (String) params.get("s_dp");
		String major = (String) params.get("s_major");
		String class_ = (String) params.get("s_class");
		String state = (String) params.get("s_state");
		
		Date starttime = new Date((String) params.get("starttime"));
		Date endtime = new Date((String) params.get("endtime"));
		
		ArrayList<Student> resp = null;
		try {
			resp = new TeacherAction().searchStudent(
				new Student(studentID, name, sex, dp, major, class_, state, null)
				, starttime, endtime);
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

		doGet(request, response);
	}
}
