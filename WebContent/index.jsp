<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <tags:head 
  css="${pageContext.request.contextPath }/css/index.css"
  js="${pageContext.request.contextPath }/js/cookie.js,
  ${pageContext.request.contextPath }/js/login.js"/>
 <body>
  	<tags:loginer/>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript">
	    if (isLogined()) { 
	    	var permission = parseInt(getCookie("permission"));
	    	var str = "${pageContext.request.contextPath }"
	    	if (permission == 0) {
	    		str += "/admin.jsp";
	    	}
	    	else if (permission == 1) {
	    		str += "/teacher.jsp";
	    	}
	    	else {
	    		str += "/student.jsp";
	    	}
	    	document.location.href = str;
	    }
    </script>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/index.js"></script>
  </body>
</html>
