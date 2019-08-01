package team543.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import team543.service.UserCheckAction;

/**
 * Servlet Filter implementation class AdminCheckFilter
 */
public class AdminCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Cookie[] cookies = req.getCookies();
		String userID = null;
		String sessionID = null;
		String permission = null;
		for (Cookie c : cookies) {
			if (c.getName().equals("userID"))
				userID = c.getValue();
			else if (c.getName().equals("sessionID"))
				sessionID = c.getValue();
			else if (c.getName().equals("permission"))
				permission = c.getValue();
		}
		System.out.println(userID);
		System.out.println(sessionID);
		System.out.println(permission);
		System.out.println(permission.equals("0"));
		System.out.println(UserCheckAction.userCheck(userID, sessionID, permission));
		if ((userID != null && sessionID != null && permission != null) && permission.equals("0") && UserCheckAction.userCheck(userID, sessionID, permission)) 
			chain.doFilter(request, response);
		else {
			Map<String, Object> resp = new HashMap();
			resp.put("data", "err");
			JSONObject jsonObj = new JSONObject(resp);
			String json = jsonObj.toJSONString();
			System.out.println(json);
			res.getWriter().append(json);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
