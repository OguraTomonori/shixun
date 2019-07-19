<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <tags:head 
  css="${pageContext.request.contextPath }/css/leftbar.css,
  ${pageContext.request.contextPath }/css/rightbar.css,
  ${pageContext.request.contextPath }/css/navbar.css"
  js="${pageContext.request.contextPath }/js/cookie.js"/>
 <body>
  	<tags:titlebar/>
  	<tags:search/>
  	<tags:leftbar/>
  	<tags:rightbar/>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>