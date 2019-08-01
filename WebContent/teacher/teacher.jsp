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
	            <li class="active"><a href="${pageContext.request.contextPath }/teacher/teacher.jsp">个人信息</a></li>
	            <li><a href="${pageContext.request.contextPath }/teacher/teacherCourseInfo.jsp">教授课程</a></li>
	         
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath }/logout.jsp">登出</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li id="name"><a href="#"><span id="username"></span>老师,你好</a></li>
	            <li class="active" id="updateList_btn"><a href="${pageContext.request.contextPath }/teacher/commit.jsp">修改清单</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
 	<script>
	    	document.getElementById("username").innerHTML = getCookie("username");
	    </script>
 	<div class="container" id="main">
	  	<div class="row content">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table class="table" id="table">

				</table>
			</div>
		  </div>
 	</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>
	    $.post({
			"url":"${pageContext.request.contextPath }/TeacherInfoServlet",
			"data":{
				"teacherID": getCookie("userID"),
			},
			"dataType":"json",
			"success": function(response, status, xhr) {
				response = response["data"];
				var info = $("#table")[0];
				var res = {
						"姓名": response["t_name"],
						"工号": response["t_id"],
						"职位": response["t_jobtitle"],
						"院系": response["t_dp"],
						"电话号码": response["t_phonenum"],
						"薪水": response["t_salary"],
						"状态": response["t_state"],
						"入学时间": response["t_entertime"],
						"办公室": response["t_office"],
						"email": response["t_email"]
				};
				for (key in res) {
					info.innerHTML = info.innerHTML +
					"<tr><th>" + key + "</th><td>" + res[key] + "</td></tr>";
				}
			}
		});
    </script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>