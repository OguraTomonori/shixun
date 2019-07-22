<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!DOCTYPE html>
<html lang="zh-CN">
  <tags:head 
  css="${pageContext.request.contextPath }/css/navbar.css,
  ${pageContext.request.contextPath }/css/main.css"
  js="${pageContext.request.contextPath }/js/cookie.js"/>
 <body>
 <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
 	<nav class="navbar navbar-default navbar-fixed-top" id="titlebar">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">学生管理系统</a>
	        </div>
	        <div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="admin.jsp">个人信息</a></li>
	            <li><a href="studInfoSearch.jsp">学生信息查询</a></li>
	            <li><a href="teacInfoSearch.jsp">教师信息查询</a></li>
	            <li><a href="courInfoSearch.jsp">课程信息查询</a></li>
	            <li><a href="gradeInfoSearch.jsp">成绩信息查询</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	              	<li><a href="addStudent.jsp">添加学生</a></li>
	              	<li><a href="studInfoSearch.jsp">添加老师</a></li>
	              	<li><a href="studInfoSearch.jsp">添加课程</a></li>
	              	<li><a href="studInfoSearch.jsp">添加成绩</a></li>
	              	<li role="separator" class="divider"></li>
	                <li><a href="logout.jsp">登出</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li id="name"><a href="#">管理员<span id="username"></span>,你好</a></li>
	            <li class="active" id="updateList_btn"><a href="#">修改清单<span class="caret"></span></a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
 	<div class="container-fluid" id="main">
 		<div class="row content">
 			<div class="col-md-2"></div>
 			<div class="col-md-8">
		  		<tags:adminInfo/> 
		  		<script>
		  		$.post({
		  			"data":{"user_id": getCookie("userID")},
		  			"url":"Temp",// TODO
		  			"success": function(response, status, xhr) {
		  				alert("dasssss");
		  				var obj = document.getElementById("admintable");
		  				//response为一个json
		  				for (var key in response) {
		  					var target_str = "<tr><th class=\"text-center\">" + key + "</th><th class=\"text-center\">" + response[key]  + "</th></tr>";
		  					obj.innerHTML += target_str;
		  				}
		  			}
		  		})</script>
 			</div>
 		
 		</div>
 	</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>