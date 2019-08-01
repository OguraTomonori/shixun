package team543.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		boolean flag = true;
		for (Cookie c : cookies) {
			if (c.getName().equals("userID"))
				userID = c.getValue();
			else if (c.getName().equals("sessionID"))
				sessionID = c.getValue();
			else if (c.getName().equals("permission"))
				permission = c.getValue();
		}
		if ((userID != null && sessionID != null && permission != null) || !permission.equals("0") || !UserCheckAction.userCheck(userID, sessionID, permission))
			chain.doFilter(request, response);
		else {
			request.getRequestDispatcher("/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
