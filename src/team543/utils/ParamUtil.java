package team543.utils;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

public class ParamUtil {
	public static Map getRequestParameters(HttpServletRequest request) {//��ȡ���з��ʲ�����ֵ
		Map params = new HashMap();
		
		String paramName = null;
		for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
			paramName = (String) e.nextElement();
			params.put(paramName, request.getParameter(paramName));
		}
		return params;
	}
}
