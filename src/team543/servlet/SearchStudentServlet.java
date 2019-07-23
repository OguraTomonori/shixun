package team543.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

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
		response.setContentType("application/json; charset=utf-8");
		Map<String, Object> params = team543.utils.ParamUtil.getRequestParameters(request);
		
		Map<String, Object> a = new HashMap();
		a.put("id", "dasfsfd");
		a.put("name", "asdas");
		a.put("class", "rua");
		a.put("dp", "ÖÐÎç");
		a.put("sex", "sex");
		a.put("major", "adsada");
		a.put("entertime", "asdadas");
		Map<String, Object> b = new HashMap();
		b.put("id", "dasfsfd");
		b.put("name", "asdas");
		b.put("class", "rua");
		b.put("dp", "ÖÐdasdsÎç");
		b.put("sex", "sex");
		b.put("major", "adsada");
		b.put("entertime", "asdadas");
		List t = new ArrayList();
		t.add(a);
		t.add(b);
		Map<String, Object> res = new HashMap();
		res.put("data", t);
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
