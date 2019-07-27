package team543.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchGradeServlet
 */
public class SearchGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGradeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 只接受课程号或学生编号
		 * 
		 */
		
		/**
		 * "s_name"
		 * "s_id"
		 * "c_name"
		 * "c_id"
		 * "ordTimeGra"
		 * "exaPapGra"
		 * "grade"
		 * "eval"
		 * 
		 * 
		 */
		
		String studentID = request.getParameter("s_id");
		String courseID = request.getParameter("c_id");
		Map res = null;
		//其中应该有一个为null
		if (studentID != null) {
			
		}
		else {
			
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
