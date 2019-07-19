<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <tags:head 
  css="${pageContext.request.contextPath }/css/index.css,
  ${pageContext.request.contextPath }/css/navbar.css,
  ${pageContext.request.contextPath }/css/rightbar.css,
  ${pageContext.request.contextPath }/css/leftbar.css"
  js="${pageContext.request.contextPath }/js/cookie.js,
  ${pageContext.request.contextPath }/js/login.js"/>
 <body>
  	<tags:titlebar/>
  	<tags:loginer/>
  		
	    <div class="container main" id="main">
	      <tags:search/>
	      <!-- Main component for a primary marketing message or call to action -->
	      <div class="row">
		      <tags:leftbar/>
	      </div>
	   </div> <!-- /container -->
	   <tags:rightbar/>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script type="text/javascript">
	    if (isLogined()) { 
	    	//如果登录，则取消模糊，不再display登录界面
	    	document.getElementById("loginer").style["display"] = "none";
	    	document.getElementById("main").style["filter"] = "blur(0px)";
	    	document.getElementById("titlebar").style["filter"] = "blur(0px)";
	    }
    </script>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/index.js"></script>
  </body>
</html>
