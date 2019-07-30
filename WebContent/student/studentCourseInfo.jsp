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
	            <li><a href="${pageContext.request.contextPath }/student/student.jsp">个人信息</a></li>
	            <li class="active"><a href="${pageContext.request.contextPath }/student/studentCourseInfo.jsp">选课信息</a></li>
	            <li><a href="${pageContext.request.contextPath }/student/studentGradeInfo.jsp">成绩信息</a></li>
	            <li class="dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
	              <ul class="dropdown-menu">
	                <li><a href="${pageContext.request.contextPath }/logout.jsp">登出</a></li>
	              </ul>
	            </li>
	          </ul>
	          <ul class="nav navbar-nav navbar-right">
	            <li id="name"><a href="#"><span id="username"></span>同学,你好</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
		</nav>
		<script>
	    	document.getElementById("username").innerHTML = getCookie("username");
	    </script>
 	<div class="container" id="main">
 		<div class="content">
		  	<table class="table table-hover content" id="table">
					 	<tr>
					 		<th>名称</th>
					 		<th>课程号</th>
					 		<th>院系</th>
							<th>学分</th>
							<th>状态</th>
					 		<th>占比</th>
					 		<th>教师</th>
					 		<th></th>
					 	</tr>
					</table>
 		</div>
 	</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script>
		$.post({
			"url":"${pageContext.request.contextPath }/StudentSearchCourseServlet",
			"data": {
				"studentID": getCookie("userID")
			},
			"dataType":"json",
			"success": function(response, status, xhr) {
				var res = response["data"];
				console.log(res);
				var info = $("#table")[0];
				for (var i in res) {
					var arr = [
						res[i]["c_id"],
						res[i]["c_name"],
						res[i]["c_opendp"],
						res[i]["c_score"],
						res[i]["c_classstate"],
						res[i]["c_percentage"]
					]
					info.innerHTML = 
						info.innerHTML + 
						"<tr>"
					for (var j in arr) {
						info.innerHTML = 
							info.innerHTML + 
							"<td>" + arr[j] + "</td>"
					}
					info.innerHTML = 
						info.innerHTML + 
						"" //教师a标签
						+ "</tr>";
				}
			}
		});
	</script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  </body>
</html>